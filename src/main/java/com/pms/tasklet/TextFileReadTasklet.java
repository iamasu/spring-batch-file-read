package com.pms.tasklet;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

public class TextFileReadTasklet implements Tasklet, InitializingBean {

    private Resource directory;
    private DataSource dataSource;

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(directory, "directory must be set");
        Assert.notNull(dataSource, "dataSource must be set");
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        BlockingQueue<Set<String>> ssnNumbers = new LinkedBlockingQueue<Set<String>>();
        DoInsertOperation insertOperation = new DoInsertOperation(ssnNumbers);
        Thread t = new Thread(insertOperation, "insertOperation");
        t.start();
        File dir = directory.getFile();
        Assert.state(dir.isDirectory());
        File[] files = dir.listFiles();
        for (File file : files) {
            readFileInList(insertOperation, file);
        }
        insertOperation.stop();
        return RepeatStatus.FINISHED;

    }

    public Resource getDirectory() {
        return directory;
    }

    public void setDirectory(Resource directory) {
        this.directory = directory;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private void readFileInList(DoInsertOperation insertOperation, File file) {
        if (file != null) {
            Set<String> strings = new HashSet<String>();
            List<String> lines = Collections.emptyList();
            try {
                lines = Files.readAllLines(Paths.get(file.getAbsolutePath()), StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Iterator<String> itr = lines.iterator();
            while (itr.hasNext()) {
                String ssn = itr.next();
                System.out.println("text=" + ssn);
                if (ssn.length() != 0 & ssn.length() > 21) {
                    strings.add(ssn.substring(12, 21));
                }
            }
            insertOperation.setCount(strings.size());
            insertOperation.getBlockingQeque().offer(strings);
        }
    }

    private class DoInsertOperation implements Runnable {

        private final BlockingQueue<Set<String>> blockingQueue;
        private volatile boolean stop = false;
        private volatile boolean exit = false;
        private int count = 0;
        private int inserted;

        public DoInsertOperation(BlockingQueue<Set<String>> blockingQueue) {
            this.blockingQueue = blockingQueue;
            this.inserted = 0;
        }

        public BlockingQueue<Set<String>> getBlockingQeque() {
            return blockingQueue;
        }

        public void stop() {
            this.exit = true;
            this.stop = count == inserted;
            System.out.println("stoped..." + stop);
        }

        public void setCount(int count) {
            this.count += count;
        }

        private void insert(String ssn) {
            inserted += 1;
            if (exit && count == inserted) {
                this.stop = true;
            }
            System.out.println(count + "\t:" + inserted + "\tname: " + ssn + "\tstop=" + stop);
        }

        @Override
        public void run() {
            Connection conn = null;
            try {
                conn = getDataSource().getConnection();
                while (!stop) {
                    try {
                        for (String ssn : getBlockingQeque().take()) {
                            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO SSN (id) VALUES(?)");
                            pstmt.setString(1, ssn);
                            pstmt.execute();
                            insert(ssn);
                        }
                    } catch (InterruptedException | SQLException ex) {
                        Logger.getLogger(TextFileReadTasklet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (SQLException e) {
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                    }
                }
            }
        }
    }

}

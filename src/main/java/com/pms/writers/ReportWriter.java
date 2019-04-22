package com.pms.writers;

import com.pms.model.Report;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileFooterCallback;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemWriter;

/**
 *
 * @author Asu
 */
public class ReportWriter implements FlatFileHeaderCallback, ItemWriter<Report>, FlatFileFooterCallback, ItemStream, StepExecutionListener {

    private FlatFileItemWriter delegate;
    private int recordCount;
    private int preCount = 0;
    private String stepContext;

    @Override
    public void writeHeader(Writer writer) throws IOException {
        System.out.println("Header");
        writer.write("Header");
    }

    @Override
    public void write(List<? extends Report> items) throws Exception {
        int chunkRecord = items.size();
        System.out.println("writer..." + chunkRecord);
        delegate.write(items);
        recordCount += chunkRecord;
    }

    @Override
    public void writeFooter(Writer writer) throws IOException {
        System.out.println("footer");
        int count = recordCount + preCount;
        writer.write("TOTAL : [" + count + "]");
    }

    public void setDelegate(FlatFileItemWriter delegate) {
        this.delegate = delegate;
    }

    @Override
    public void close() throws ItemStreamException {
        this.delegate.close();
        this.recordCount = 0;
    }

    @Override
    public void open(ExecutionContext arg0) throws ItemStreamException {
        this.delegate.open(arg0);
    }

    @Override
    public void update(ExecutionContext arg0) throws ItemStreamException {
        this.delegate.update(arg0);
    }

    public void setStepContext(String stepContext) {
        this.stepContext = stepContext;
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        if (stepContext.equals("secondStep")) {
            preCount = stepExecution.getJobExecution().getExecutionContext().getInt("count");
        }
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        if (stepContext.equals("firstStep")) {
            stepExecution.getJobExecution().getExecutionContext().put("count", recordCount);
        }
        return stepExecution.getExitStatus();
    }
}

package com.pms;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asu
 */
public class FileComparator {

    private void loadData() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("", "", "");
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("");
            ResultSetMetaData metadata = rs.getMetaData();
            int columnCount = metadata.getColumnCount();
            System.out.println();
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.println(rs.getObject(metadata.getColumnName(i)));
                }
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {

        }
    }

    public static void main(final String[] args) throws IOException {
        final String firstFile = "D:\\test\\a.txt";
        final String secondFile = "D:\\test\\b.txt";
        compareFiles(firstFile, secondFile);

    }

    private static void compareFiles(final String firstFile, final String secondFile) throws IOException {
        final long start = System.nanoTime();
        final String resulFileName = System.getProperty("user.home") + "\\result.txt";
        final Path firstFilePath = Paths.get(firstFile);
        final Path secondFilePath = Paths.get(secondFile);
        final List<String> firstFileContent = Files.readAllLines(firstFilePath, StandardCharsets.UTF_8);
        final List<String> secondFileContent = Files.readAllLines(secondFilePath, StandardCharsets.UTF_8);
        final List<String> diffLiles = new ArrayList<>();
        for (final String line : secondFileContent) {
            if (!firstFileContent.contains(line)) {
                diffLiles.add(line);
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(resulFileName))) {
            for (String line : diffLiles) {
                writer.write(line);
                writer.newLine();

            }
        }
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().edit(new File(resulFileName));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        final long end = System.nanoTime();
        System.out.print("Execution time: " + (end - start) / 1000000 + "ms");
    }
}

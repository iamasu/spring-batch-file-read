package com.pms;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author Asu
 */
public class DBUtility {
    
    private static final String[] TABLE_TYPES = {"TABLE", "VIEW"};
    
    public static void getTableMetadata(Connection jdbcConnection) throws Exception {
        try {
            DatabaseMetaData meta = jdbcConnection.getMetaData();
            ResultSet rs = null;
            try {
                rs = meta.getTables(null, null, null, TABLE_TYPES);
                while (rs.next()) {
                    String tableName = rs.getString("TABLE_NAME");
                    System.out.println("table = " + tableName);
                    System.out.println("-------------------------------");
                    StringBuilder sb = new StringBuilder("SELECT * FROM ");
                    sb.append(tableName);
                    try (ResultSet resultSet = jdbcConnection.createStatement().executeQuery(sb.toString())) {
                        ResultSetMetaData metadata = resultSet.getMetaData();
                        int columnCount = metadata.getColumnCount();
                        for (int i = 1; i <= columnCount; i++) {
                            String columnName = metadata.getColumnName(i);
                            System.out.println(columnName + ":" + metadata.getColumnTypeName(i));
                        }
                    }
                    System.out.println("");
                }
                ResultSetMetaData metadata = rs.getMetaData();
                int columnCount = metadata.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metadata.getColumnName(i);
                    System.out.println(columnName);
                }
            } finally {
                if (rs != null) {
                    rs.close();
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) throws Exception {
        Connection jdbcConnection;
        try {
            jdbcConnection = DriverManager.getConnection("", "", "");
            getTableMetadata(jdbcConnection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {
    // Logic: Look for "DB_HOST" environment variable. If not found, use "localhost"
    private static final String dbHost = System.getenv("DB_HOST") != null ? System.getenv("DB_HOST") : "localhost";
    // Logic: Look for "DB_PORT" environment variable. If not found, use "3307" (your host port)
    private static final String dbPort = System.getenv("DB_PORT") != null ? System.getenv("DB_PORT") : "3307";

    //private static final String URL = "jdbc:mysql://localhost:3306/avgCalResults"
    private static final String URL = "jdbc:mysql://"+ dbHost +":"+ dbPort +"/avgCalResults?autoReconnect=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "mysql1234";

    public static void saveResult(double average) {
        String sql = "INSERT INTO calculations (average_value, calculation_time) VALUES (?, NOW())";

        int retries = 5;
            while (retries > 0) {



        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
                    // ... your table creation and insert logic ...
                       conn.createStatement().execute("CREATE TABLE IF NOT EXISTS calculations (id INT AUTO_INCREMENT PRIMARY KEY, average_value DOUBLE, calculation_time DATETIME)");

                    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                        pstmt.setDouble(1, average);
                        pstmt.executeUpdate();
                        System.out.println(">>> Database: Result successfully saved to MySQL!");
                    }
                    return;
                } catch (SQLException e) {
                    System.out.println("DB not ready yet, retrying... (" + retries + " left)");
                    retries--;
                      System.err.println("Database Error: " + e.getMessage());
                    try { Thread.sleep(5000); } catch (InterruptedException ie) {}
                }



            }

        /**
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            conn.createStatement().execute("CREATE TABLE IF NOT EXISTS calculations (id INT AUTO_INCREMENT PRIMARY KEY, average_value DOUBLE, calculation_time DATETIME)");

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setDouble(1, average);
                pstmt.executeUpdate();
                System.out.println(">>> Database: Result successfully saved to MySQL!");
            }
        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }**/
    }
}

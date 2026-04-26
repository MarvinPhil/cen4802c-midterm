package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {
    // Note: The host is "db" because that's the name of our service in docker-compose
    private static final String URL = "jdbc:mysql://localhost:3306/avgCalResults";
    private static final String USER = "root";
    private static final String PASS = "mysql1234";

    public static void saveResult(double average) {
        String sql = "INSERT INTO calculations (average_value, calculation_time) VALUES (?, NOW())";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            conn.createStatement().execute("CREATE TABLE IF NOT EXISTS calculations (id INT AUTO_INCREMENT PRIMARY KEY, average_value DOUBLE, calculation_time DATETIME)");

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setDouble(1, average);
                pstmt.executeUpdate();
                System.out.println(">>> Database: Result successfully saved to MySQL!");
            }
        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }
    }
}

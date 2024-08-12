/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se3313project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp; 
/**
 *
 * @author psk
 */
class CoffeeMakerDatabase {
     private static final String URL = "jdbc:mysql://localhost:3306/se3313project";
    private static final String USER = "root";
    private static final String PASSWORD = "pelin2002";

    public static Connection getConnection() throws SQLException {
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        throw new SQLException("MySQL JDBC Driver not found.", e);
    }

    return DriverManager.getConnection(URL, USER, PASSWORD);
        
    }
    
    public void insertData(int cups, java.util.Date date) {
        try (Connection connection = getConnection()) {
        String query = "INSERT INTO coffee_data (cups, brewing_time) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, cups);
            preparedStatement.setTimestamp(2, new Timestamp(date.getTime()));
            preparedStatement.executeUpdate();
            System.out.println("Data inserted");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        
    }
    }
}

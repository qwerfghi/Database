package com.qwerfghi.database.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnection {

    private final static String URL = "jdbc:mysql://127.0.0.1:3306/hostel?autoReconnect=true&useSSL=false";
    private static String USER = "root";
    private static String PASS = "root";
    private Connection connection;
    private Statement statement;

    public void connect() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addRecall(String email, int mark, String recall) {
        String sql = "INSERT INTO recall (email, mark, recall) VALUES (" +
                "'" + email + "', " +
                "'" + mark + "', " +
                "'" + recall + "');";
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
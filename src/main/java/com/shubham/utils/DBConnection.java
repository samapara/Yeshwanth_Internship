package com.shubham.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    static Connection connection = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        if (connection != null)
            return connection;
        else {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "shubham", "shubham");
        }
        return connection;
    }
}

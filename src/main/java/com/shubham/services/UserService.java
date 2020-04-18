package com.shubham.services;

import com.shubham.Model.User;
import com.shubham.utils.Constants;
import com.shubham.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserService {

    Connection connection;


    public Optional<User> getUserByEmail(String email) throws SQLException, ClassNotFoundException {
        User user = null;
        connection = DBConnection.getConnection();

        String query = "select * from users where email = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, email);

        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                user = new User();
                user.setEmail(resultSet.getString("email"));
                user.setName(resultSet.getString("name"));

                System.out.println(user.toString());
                return Optional.of(user);
            }
        }
//        connection.close();
        return Optional.empty();
    }

    public Optional<User> authorizeUser(String email, String password) throws ClassNotFoundException, SQLException {
        connection = DBConnection.getConnection();
        User user = null;

        String query = "select * from users where email = ? and password = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, email);
        statement.setString(2, password);

        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                user = new User();
                user.setEmail(resultSet.getString("email"));
                user.setName(resultSet.getString("name"));
                System.out.println(user.toString());
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public String insertUser(User user) throws ClassNotFoundException, SQLException {
        connection = DBConnection.getConnection();
        String email = user.getEmail();

        if (getUserByEmail(email).isPresent()) {
            System.out.println("User Already Exists with email!");
            return Constants.USERALREADYEXISTS;
        }

        String query = "insert into users values(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, user.getName());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getPassword());

        int status = statement.executeUpdate();
        if (status > 0)
            return Constants.SUCCESS;
        else
            return Constants.UNKNOWNERROR;
    }
}

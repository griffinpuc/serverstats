package com.griffinpuc.serverstats;

import com.griffinpuc.serverstats.Library.User;

import java.sql.*;
import java.util.Date;

public class DatabaseConnection {

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public User checkUser(String uuid) throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager.getConnection("jdbc:mysql://localhost/server_stats?"+"user=pluginconnection&password=Fall2020!&useSSL=false");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();

            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect.prepareStatement("SELECT * FROM user WHERE userUuid = ?");
            preparedStatement.setString(1, uuid);
            resultSet = preparedStatement.executeQuery();

            if(resultSet != null){
                String userUuid = resultSet.getString("userUuid");
                String userName = resultSet.getString("userName");
                Timestamp firstLogin = resultSet.getTimestamp("firstLogin");
                Timestamp lastLogin = resultSet.getTimestamp("lastLogin");

                return new User(userUuid, userName, firstLogin, lastLogin);
            }

            return null;


        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    public void createUser(String uuid, String userName) throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager.getConnection("jdbc:mysql://localhost/server_stats?"+"user=pluginconnection&password=Fall2020!&useSSL=false");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();

            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect.prepareStatement("INSERT INTO user (userUuid, userName, lastLogin, firstLogin) VALUES (?, ?, ?, ?)");

            Timestamp currentStamp = new java.sql.Timestamp(new Date().getTime());

            // Parameters start with 1
            preparedStatement.setString(1, uuid);
            preparedStatement.setString(2, userName);
            preparedStatement.setTimestamp(3, currentStamp);
            preparedStatement.setTimestamp(4, currentStamp);
            preparedStatement.executeUpdate();


        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}

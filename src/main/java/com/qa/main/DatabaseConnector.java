package com.qa.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.qa.utils.DatabaseConfiguration;

public class DatabaseConnector {
    private Connection connection;

    private Statement statement;

    public DatabaseConnector() throws SQLException {
        connection = DriverManager.getConnection(DatabaseConfiguration.URL, DatabaseConfiguration.USER,
                DatabaseConfiguration.PASSWORD);
    }

    public void createActor(String forename, String surname) throws SQLException {
        statement.executeUpdate(String.format("INSERT INTO actor (`first_name`, `last_name`)" + " VALUES ('%s', '%s')",
                forename, surname));
    }

    public void readAllActors() throws SQLException {
        String sql = "SELECT * FROM actor";
        this.statement = connection.createStatement();
        ResultSet results = this.statement.executeQuery(sql);

        while (results.next()) {
            System.out.println(String.format("%s %s", results.getString("first_name"), results.getString("last_name")));
        }
    }

    public void updateActor(String first_name_new, String last_name_new, String first_name_old, String last_name_old) throws SQLException {
    	statement.executeUpdate(String.format("UPDATE actor SET first_name='%s', last_name='%s' WHERE first_name='%s' and last_name='%s'", first_name_new, last_name_new, first_name_old, last_name_old));
    }

    public void deleteActor(String first_name, String last_name) throws SQLException {
    	statement.executeUpdate(String.format("DELETE FROM actor WHERE first_name='%s' and last_name='%s'", first_name, last_name));
    }

}

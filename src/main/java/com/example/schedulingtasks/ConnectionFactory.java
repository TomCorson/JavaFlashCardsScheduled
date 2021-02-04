package com.example.schedulingtasks;
import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public  static final String URL = System.getenv("MYSQLURL");
    public  static final String USER = System.getenv("MYSQLUSER");
    public  static final String PASS = System.getenv("MYSQLPASS");

    public static Connection getConnection(){
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException throwables) {
            throw new RuntimeException("Error connecting to the database", throwables);
        }
    }

}


package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnsectionUtill {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECT = "jdbc:mysql://localhost:3306/dbwd?serverTimezone=UTC";
    private static final String DB_USER = "user";
    private static final String DB_PASSWORD = "1234";
    public static Connection myCon() throws ClassNotFoundException {
        Class.forName(DB_DRIVER);
        try {
            return DriverManager.getConnection(DB_CONNECT,DB_USER,DB_PASSWORD);
        } catch (SQLException throwables) {
            return null;
        }
    }
}
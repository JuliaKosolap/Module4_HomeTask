package org.example.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static Connection connection;
    private static String dbUrl = "jdbc:h2:~/test";
    private static String userName = "sa";
    private static String password = "";

    public static void CreateDBConnection() throws SQLException {
        connection = DriverManager.getConnection(dbUrl, userName, password);
    }
    public static Connection getConnection() {
        return connection;
    }
}

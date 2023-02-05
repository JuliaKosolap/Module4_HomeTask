package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) throws SQLException, IOException {
        Database.CreateDBConnection();
        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();
        String sqlFromFile = String.join("\n", Files.readAllLines(Paths.get("src/main/java/sql/populate_db.sql")));
        statement.execute(sqlFromFile);
        statement.close();
        connection.close();
    }
}

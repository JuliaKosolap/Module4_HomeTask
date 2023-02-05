package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

public class DatabaseInitService {
    public static void main(String[] args) throws SQLException, IOException {

        Database.CreateDBConnection();

        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();
        String sqlFromFile = String.join("\n", Files.readAllLines(Paths.get("src/main/java/sql/drop_db.sql")));
        statement.execute(sqlFromFile);
        sqlFromFile = String.join("\n", Files.readAllLines(Paths.get("src/main/java/sql/init_db.sql")));
        statement.execute(sqlFromFile);
        connection.close();
    }
}


package org.example.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void fillTablesWithData() {
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            String sqlFromFile = String.join("\n", Files.readAllLines(Paths.get("src/main/java/sql/populate_db.sql")));
            statement.execute(sqlFromFile);
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

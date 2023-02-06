package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class DatabaseQueryService {
    public static void main(String[] args) throws SQLException, IOException {
        Database.CreateDBConnection();
        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();
        ArrayList maxSalaryList = findMaxSalary(statement);
        System.out.println(maxSalaryList);
        ArrayList longestProjectsList = findLongestProject(statement);
        System.out.println(longestProjectsList);
        ArrayList maxProjectClientsList = findMaxProjectClients(statement);
        System.out.println(maxProjectClientsList);
        ArrayList youngestEldestWorkersList = findYoungestEldestWorkers(statement);
        System.out.println(youngestEldestWorkersList);
        ArrayList projectPricesList = getProjectPrice(statement);
        System.out.println(projectPricesList);
        statement.close();
        connection.close();
    }
    public static ArrayList findMaxSalary(Statement statement) throws IOException, SQLException {
        String sqlFromFile = String.join("\n", Files.readAllLines(Paths.get("src/main/java/sql/find_max_salary_worker.sql")));
        ResultSet resultSet = statement.executeQuery(sqlFromFile);
        ArrayList<Object> list = new ArrayList<>();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int salary = resultSet.getInt("salary");
            list.add(new MaxWorkerSalary(name, salary));
        }

        return list;
    }
    public static ArrayList findLongestProject(Statement statement) throws IOException, SQLException {
        String sqlFromFile = String.join("\n", Files.readAllLines(Paths.get("src/main/java/sql/find_longest_project.sql")));
        ResultSet resultSet = statement.executeQuery(sqlFromFile);
        ArrayList<Object> list = new ArrayList<>();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int monthCount = resultSet.getInt("month_count");
            list.add(new LongestProject(name, monthCount));
        }
        return list;
    }

    public static ArrayList findMaxProjectClients(Statement statement) throws IOException, SQLException {
        String sqlFromFile = String.join("\n", Files.readAllLines(Paths.get("src/main/java/sql/find_max_projects_client.sql")));
        ResultSet resultSet = statement.executeQuery(sqlFromFile);
        ArrayList<Object> list = new ArrayList<>();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int projectCount = resultSet.getInt("project_count");
            list.add(new MaxProjectClients(name, projectCount));
        }
        return list;
    }

    public static ArrayList findYoungestEldestWorkers(Statement statement) throws IOException, SQLException {
        String sqlFromFile = String.join("\n", Files.readAllLines(Paths.get("src/main/java/sql/find_youngest_eldest_workers.sql")));
        ResultSet resultSet = statement.executeQuery(sqlFromFile);
        ArrayList<Object> list = new ArrayList<>();
        while (resultSet.next()) {
            String type = resultSet.getString("type");
            String name = resultSet.getString("name");
            String rawDate = resultSet.getString("birthday");
            LocalDate birthday = LocalDate.parse(rawDate);
            list.add(new YoungestEldestWorkers(type, name, birthday));
        }
        return list;
    }
    public static ArrayList<ProjectPrice> getProjectPrice(Statement statement) throws IOException, SQLException {
        ArrayList<ProjectPrice> list = new ArrayList<ProjectPrice>();
        String sqlFromFile = String.join("\n", Files.readAllLines(Paths.get("src/main/java/sql/print_project_prices.sql")));
        ResultSet resultSet = statement.executeQuery(sqlFromFile);
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int price = resultSet.getInt("price");
            list.add(new ProjectPrice(name, price));
        }
        return list;
    }

}

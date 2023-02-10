package org.example.common;

import org.example.entities.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class DatabaseQueryService {

    public static ArrayList<MaxWorkerSalary> findMaxSalary() {
        ArrayList<MaxWorkerSalary> list = null;
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            String sqlFromFile = String.join("\n", Files.readAllLines(Paths.get("src/main/java/sql/find_max_salary_worker.sql")));
            ResultSet resultSet = statement.executeQuery(sqlFromFile);
            list = new ArrayList<>();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int salary = resultSet.getInt("salary");
                list.add(new MaxWorkerSalary(name, salary));
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    public static ArrayList<LongestProject> findLongestProject() {
        ArrayList<LongestProject> list = null;
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            String sqlFromFile = String.join("\n", Files.readAllLines(Paths.get("src/main/java/sql/find_longest_project.sql")));
            ResultSet resultSet = statement.executeQuery(sqlFromFile);
            list = new ArrayList<>();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int monthCount = resultSet.getInt("month_count");
                list.add(new LongestProject(name, monthCount));
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<MaxProjectClients> findMaxProjectClients() {
        ArrayList<MaxProjectClients> list = null;
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            String sqlFromFile = String.join("\n", Files.readAllLines(Paths.get("src/main/java/sql/find_max_projects_client.sql")));
            ResultSet resultSet = statement.executeQuery(sqlFromFile);
            list = new ArrayList<>();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int projectCount = resultSet.getInt("project_count");
                list.add(new MaxProjectClients(name, projectCount));
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
            return list;
        }


    public static ArrayList<YoungestEldestWorkers> findYoungestEldestWorkers() {
        ArrayList<YoungestEldestWorkers> list = null;
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            String sqlFromFile = String.join("\n", Files.readAllLines(Paths.get("src/main/java/sql/find_youngest_eldest_workers.sql")));
            ResultSet resultSet = statement.executeQuery(sqlFromFile);
            list = new ArrayList<>();
            while (resultSet.next()) {
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                String rawDate = resultSet.getString("birthday");
                LocalDate birthday = LocalDate.parse(rawDate);
                list.add(new YoungestEldestWorkers(type, name, birthday));
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<ProjectPrice> getProjectPrice()  {
        ArrayList<ProjectPrice> list = null;
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            list = new ArrayList<>();
            String sqlFromFile = String.join("\n", Files.readAllLines(Paths.get("src/main/java/sql/print_project_prices.sql")));
            ResultSet resultSet = statement.executeQuery(sqlFromFile);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                list.add(new ProjectPrice(name, price));
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

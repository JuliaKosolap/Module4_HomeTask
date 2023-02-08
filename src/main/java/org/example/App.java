package org.example;

import org.example.common.DatabaseInitService;
import org.example.common.DatabasePopulateService;

import java.util.ArrayList;

import static org.example.common.DatabaseQueryService.*;

public class App {
    public static void main(String[] args) {
        try {
            DatabaseInitService.createTables();
            DatabasePopulateService.fillTablesWithData();
            ArrayList maxSalaryList = findMaxSalary();
            System.out.println(maxSalaryList);
            ArrayList longestProjectsList = findLongestProject();
            System.out.println(longestProjectsList);
            ArrayList maxProjectClientsList = findMaxProjectClients();
            System.out.println(maxProjectClientsList);
            ArrayList youngestEldestWorkersList = findYoungestEldestWorkers();
            System.out.println(youngestEldestWorkersList);
            ArrayList projectPricesList = getProjectPrice();
            System.out.println(projectPricesList);;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

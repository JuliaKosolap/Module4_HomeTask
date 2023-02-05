package org.example;

public class MaxProjectClients {
    private static String name;
    private static int project_count;

    public MaxProjectClients(String name, int projectCount) {
        this.name = name;
        this.project_count = projectCount;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        MaxProjectClients.name = name;
    }

    public static int getProject_count() {
        return project_count;
    }

    public static void setProject_count(int project_count) {
        MaxProjectClients.project_count = project_count;
    }
    @Override
    public String toString() {
        return "MaxProjectClients{" +
                "name='" + name + '\'' +
                ", project_count=" + project_count +
                '}';
    }

}

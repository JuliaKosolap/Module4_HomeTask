package org.example.entities;

public class MaxProjectClients {
    private String name;
    private int project_count;

    public MaxProjectClients(String name, int projectCount) {
        this.name = name;
        this.project_count = projectCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProject_count() {
        return project_count;
    }

    public void setProject_count(int project_count) {
        this.project_count = project_count;
    }
    @Override
    public String toString() {
        return "MaxProjectClients{" +
                "name='" + name + '\'' +
                ", project_count=" + project_count +
                '}';
    }

}

package org.example.entities;

public class LongestProject {
    private String name;
    private int month_count;

    public LongestProject(String name, int monthCount) {
        this.name = name;
        this.month_count = monthCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonth_count() {
        return month_count;
    }

    public void setMonth_count(int month_count) {
        this.month_count = month_count;
    }

    @Override
    public String toString() {
        return "LongestProject{" +
                "name='" + name + '\'' +
                ", month_count=" + month_count +
                '}';
    }
}

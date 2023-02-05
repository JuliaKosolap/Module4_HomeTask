package org.example;

import java.time.LocalDate;

public class YoungestEldestWorkers {

    private static String type;
    private static String name;
    private static LocalDate birthday;


    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        YoungestEldestWorkers.type = type;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        YoungestEldestWorkers.name = name;
    }

    public static LocalDate getBirthday() {
        return birthday;
    }

    public static void setBirthday(LocalDate birthday) {
        YoungestEldestWorkers.birthday = birthday;
    }

    @Override
    public String toString() {
        return "YoungestEldestWorkers{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}

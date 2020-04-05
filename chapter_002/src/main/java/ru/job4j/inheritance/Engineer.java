package ru.job4j.inheritance;

public class Engineer extends Profession {

    private String schedule;

    public String getSchedule(String schedule) {
        this.schedule = schedule;
        return this.schedule;
    }
}

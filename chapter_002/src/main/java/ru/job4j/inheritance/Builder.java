package ru.job4j.inheritance;

public class Builder extends Engineer {

    private String buildings;

    public String getBuildings(String buildings) {
        this.buildings = buildings;
        return this.buildings;
    }
}

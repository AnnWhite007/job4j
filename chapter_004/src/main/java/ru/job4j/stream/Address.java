package ru.job4j.stream;

import java.nio.MappedByteBuffer;

public class Address {
    private String city;
    private String street;
    private int home;
    private int apartment;

    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Address {"
                + city
                + ", " + street
                + " " + home
                + ", " + apartment
                + "}";
    }
}

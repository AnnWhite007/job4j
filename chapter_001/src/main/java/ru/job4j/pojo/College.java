package ru.job4j.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Ivanov Ivan Ivanovich");
        student.setGroup("RS1001");
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        student.setCreated(new Date());
        System.out.println("Student: "
                + student.getFio() + ", "
                + student.getGroup() + ", "
                + formater.format(student.getCreated())
        );
    }
}

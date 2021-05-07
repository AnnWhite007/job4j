package ru.job4j.stream;

/**
 * 9. Шаблоны проектирования в Stream API
 * - для построения потоков при работе со Stream используется шаблон проектирования Builder.
 * Строитель - это порождающий шаблон проектирования, который позволяет создавать сложные объекты пошагово.
 * Строитель позволяет использовать один и тот же код построения объекта для получения разных представлений объектов.
 * Чтобы создавать объекты таким образом, нам нужно поочередно вызывать методы строителя.
 * При этом нам не нужно запускать все шаги, а только те, которые нужны для производства объекта определенной конфигурации.
 *
 */

public class Patient {
    private String surname;
    private String name;
    private String birthday;
    private int age;
    private String bloodtype;
    private String diagnosis;
    private String pill;

    static class Builder {
        private String surname;
        private String name;
        private String birthday;
        private int age;
        private String bloodtype;
        private String diagnosis;
        private String pill;

        Builder buildSurname(String surname) {
            this.surname = surname;
            return this;
        }

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildBirthday(String birthday) {
            this.birthday = birthday;
            return this;
        }

        Builder buildAge(int age) {
            this.age = age;
            return this;
        }

        Builder buildBloodtype(String bloodtype) {
            this.bloodtype = bloodtype;
            return this;
        }

        Builder buildDiagnosis(String diagnosis) {
            this.diagnosis = diagnosis;
            return this;
        }

        Builder buildPill(String pill) {
            this.pill = pill;
            return this;
        }

        Patient build() {
            Patient patient = new Patient();
            patient.surname = surname;
            patient.name = name;
            patient.birthday = birthday;
            patient.age = age;
            patient.bloodtype = bloodtype;
            patient.diagnosis = diagnosis;
            patient.pill = pill;
            return patient;
        }
    }
    public static void main(String[] args) {
        Patient patient = new Builder().buildSurname("Ivanov")
                .buildName("Ivan")
                .buildBirthday("10.10.2020")
                .buildAge(1)
                .buildBloodtype("I+")
                .buildDiagnosis("headache")
                .buildPill("Nurofen")
                .build();
        System.out.println(patient);
    }

    @Override
    public String toString() {
        return "Surname = " + this.surname
                + ", name = " + this.name
                + ", birthday = " + this.birthday
                + ", age = " + this.age
                + ", bloodtype = " + this.bloodtype
                + ", diagnosis = " + this.diagnosis
                + ", pill = " + this.pill;
    }
}










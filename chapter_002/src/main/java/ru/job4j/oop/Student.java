package ru.job4j.oop;

/**
 * 1.2.1.2. Вызов метода объекта
 * Чтобы вызвать код, написанный внутри метода,
 * нам нужно обратиться к переменной объекта Studentи через точку написать имя метода.
 */
public class Student {
    public static void main(String[] args) {
        Student petya = new Student();
        petya.music();
        petya.music();
        petya.music();
        petya.song();
        petya.song();
        petya.song();
    }
    public void music() {
        System.out.println("Tra tra tra");
    }
    public void song() {
        System.out.println("I believe I can fly");
    }
}

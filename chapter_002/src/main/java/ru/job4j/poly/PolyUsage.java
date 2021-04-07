package ru.job4j.poly;

/**
 * 3.2. Зачем нужно приведение типов
 * мы создавали объекты разных классов, при этом приводя все их
 * к общему для каждого из этих классов типу Vehicle. В таком виде мы их уже можем "сложить"
 * в общий массив объектов типа Vehicle, и нам будет доступен общий для них метод move(),
 * однако для каждого класса он будет иметь свое поведение, определенное в каждом классе.
 */

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle train = new Train();
        Vehicle autobus = new Autobus();

        Vehicle[] vehicles = new Vehicle[] {plane, train, autobus};
        for (Vehicle a : vehicles) {
            a.move();
        }
    }
}

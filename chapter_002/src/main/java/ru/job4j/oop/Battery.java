package ru.job4j.oop;

/**
 * 2.1.7. Состояние объекта
 * Battery -конструктор для инициализации начального состояния батареи
 * exchange - метод, который будет принимать объект типа Battery
 * Вначале мы создаем два объекта first, second. В каждом объекте хранятся свои данные.
 * Дальше мы выводим на консоль значение value для каждого объекта.
 * У объекта first вызываем метод exchange.
 * В нем есть поле this.load - this - указывает на то что нужно взять значение этой переменной
 * у объекта для которого мы вызываем метод.
 * Дальше в методе exchange передается переменная another.
 * У нее мы тоже можем получить значение, но обращаться к полу этого объекта мы должны через имя переменной another.load.
 * в нашем методе есть два объекта и два значения load.
 * Первый это у кого мы вызываем метод exchange и второй этот тот объект,
 * который мы передаем в метод exchange.
 */

public class Battery {
    private int load;

    public Battery(int volume) {
        this.load = volume;
    }
    public void exchange(Battery another) {
        another.load = another.load + this.load;
        this.load = 0;
    }
    public static void main(String[] args) {
        Battery first = new Battery(40);
        Battery second = new Battery(30);
        System.out.println("first: " + first.load + " second: " + second.load);
        first.exchange(second);
        System.out.println("first: " + first.load + " second: " + second.load);
    }
}

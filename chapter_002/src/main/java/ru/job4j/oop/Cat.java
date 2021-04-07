package ru.job4j.oop;

/**
 * 2.1.5. Поля объекта
 *  "поле" обозначает переменную, которая связана с объектом.
 *  Для того, чтобы обратиться к полю объекта,
 *  нам нужно использовать ключевое слово this."дальше указываем имя поля, которое нужно вывести"
 *  По умолчанию, во всех полях объекта записываются значения по умолчанию.
 *  Каждый объект резервирует свой кусочек памяти. В этот кусок памяти мы записываем данные,
 *  которые принадлежат конкретному объекту.
 */

public class Cat {
    private String food;
    private String name;

    public void show() {
        System.out.println(this.name + " eats " + this.food);
    }
    public void eat(String meat) {
        this.food = meat;
    }
    public void giveNick(String nick) {
        this.name = nick;
    }
    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.giveNick("Gav");
        gav.eat("kotleta");
        gav.show();
        Cat black = new Cat();
        black.giveNick("Black");
        black.eat("fish");
        black.show();
    }
}

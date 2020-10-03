package ru.job4j.oop;

/**
 * 2.1.6. Взаимодействие объектов
 * В каждый класс мы добавили методы, которые принимают в качестве параметров другой класс.
 * То есть любой созданный класс - это новый тип данных.
 * Этот новый тип данных можно принимать как параметр, возвращать как параметр.
 */

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();
        ball.songForHare(hare);
        hare.tryEat(ball);
        ball.songForWolf(wolf);
        wolf.tryEat(ball);
        ball.songForFox(fox);
        fox.eat(ball);
    }
}

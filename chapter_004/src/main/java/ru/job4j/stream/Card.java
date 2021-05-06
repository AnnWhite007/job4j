package ru.job4j.stream;

import java.util.stream.Stream;

/**
 * 8. Перенос методов в Stream API.
 * Каждый метод Stream API начинаем с новой строки.
 *
 * Написать метод main, в котором генерируется колода карт.
 * Чтобы получить поток из перечисления, нужно использовать метод Stream.of(Suit.values())
 * Дано: два массива. Нужно вывести все элементы каждый с каждым.
 */

public class Card {

    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(s -> Stream.of(Value.values())
                .map(v -> s + " " + v))
        .forEach(System.out::println);
    }
}

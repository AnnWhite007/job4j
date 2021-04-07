package ru.job4j.poly;

/**
 * 3. Интерфейс Input
 * полиморфизм осуществляется за счет элемента interface
 * Interface  - это элемент, который содержит объявления методов,
 * но не содержит реализации этих методов.
 * После метода мы сразу ставим точку с запятой, а не начинаем блок кода { }.
 */

public interface Transport {
    // метод, который возвращает введенную строку от пользователя
    String askStr(String question);
    // метод, который будет возвращать от пользователя число
    int askInt(String question);

    void ehat();
    void passajiri(int num);
    int zapravit(int litres);
}

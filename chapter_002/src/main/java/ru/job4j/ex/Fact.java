package ru.job4j.ex;

/**
 * 0.2. Кидаем исключение - throw new RuntimeException
 * Чтобы прервать выполнение программы, нужно использовать оператор throw
 * с передачей этому оператору объекта типа java.util.Exception.
 *
 * В Java есть встроенные классы, которые описывают исключительные ситуации.
 * java.lang.IllegalArgumentException - метод вызывается с некорректными параметрами.
 * java.lang.IllegalStateException - метод вызывается с объекта в не корректном состоянии.
 * java.lang.NullPointerException - методы вызывается у переменной, которая инициализирована null ссылкой.
 * В конструкторе исключения нужно обязательно указать причину возникновения исключения. Никогда не оставляйте текст пустым.
 */

public class Fact {
    public static void main(String[] args) {
        System.out.println("Factorial 3 is : " + calc(-2));
    }

    public static int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n should be more then 0.");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}

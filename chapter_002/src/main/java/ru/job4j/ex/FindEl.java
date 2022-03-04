package ru.job4j.ex;

/**
 * 0.4. Пользовательские исключения.
 * java.lang.IllegalArgumentException - метод вызывается с некорректными параметрами.
 * java.lang.IllegalStateException - метод вызывается с объекта в некорректном состоянии.
 * java.lang.NullPointerException - метод вызывается у переменной, которая инициализирована null ссылкой.
 * Все эти классы наследуются от класса java.lang.RuntimeException. Эти исключения не обрабатывают.
 * В литературе можно встретить термин непроверяемые исключения (unchecked exception) или runtime exception.
 * Конструкция try-catch - позволяет выполнить методы, которые могут прерваться с исключением и обработать эти исключения.
 * В Java есть ключевое слово throws. Его можно добавить после параметров метода и указать,
 * какие прерывания могут случиться с этим методом.
 *
 * try содержит операторы, которые мы хотим выполнить.
 * catch содержит объявление исключение. Если операторы в блоке try вызовут исключение UserInputException,
 * то программа перейдет к выполнению блока catch.
 * Оператор выведет на консоль стек вызовов методов от начала программы до оператора, который вызвал прерывания.
 */

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
           if (value[i].equals(key)) {
               rsl = i;
               break;
           }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Key could not be find");
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            indexOf(new String[]{"Kate", "55", "Ann", "55"}, "Bob");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
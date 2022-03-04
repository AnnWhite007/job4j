package ru.job4j.pojo;

/**
 * 3. Массивы и модели.
 * использование моделей данных и массивы.
 *
 * Создаем 4 объекта и добавляем их в массив.
 * Выводим содержимое массива на консоль через цикл for + index.
 * Переставляем местами книги с индексом 0 и 3.
 * Цикл с выводом книг с именем "Clean code".
 */

public class Library {
    public static void main(String[] args) {
        Book first = new Book("Harry Potter", 567);
        Book second = new Book("Lost", 345);
        Book third = new Book("Heroes", 100);
        Book fourth = new Book("Clean code", 1236);
        Book[] lib = new Book[4];
        lib[0] = first;
        lib[1] = second;
        lib[2] = third;
        lib[3] = fourth;

        for (int index  = 0; index < lib.length; index++) {
            Book pr = lib[index];
            System.out.println(pr.getName() + " - " + pr.getNum());
        }
        System.out.println("Replace:");

        Book temp = lib[0];
        lib[0] = lib[3];
        lib[3] = temp;
        for (int index  = 0; index < lib.length; index++) {
            Book pr = lib[index];
            System.out.println(pr.getName() + " - " + pr.getNum());
        }
        System.out.println("Show Clean code:");

        for (int index = 0; index < lib.length; index++) {
            Book pr = lib[index];
            if (pr.getName().equals("Clean code")) {
                System.out.println(pr.getName() + " - " + pr.getNum());
            }
        }
    }
}

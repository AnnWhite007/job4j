package ru.job4j.pojo;

/**
 * 3. Массивы и модели.
 * использование моделей данных и массивы
 */

public class Library {
    public static void main(String[] args) {
        // Создаем 4 объекта и добавляем их в массив
        Book first = new Book("Harry Potter", 567);
        Book second = new Book("Lost", 345);
        Book third = new Book("Heroes", 100);
        Book fourth = new Book("Clean code", 1236);
        Book[] lib = new Book[4];
        lib[0] = first;
        lib[1] = second;
        lib[2] = third;
        lib[3] = fourth;
        // Выводим содержимое массива на консоль через цикл for + index
        for (int index  = 0; index < lib.length; index++) {
            Book pr = lib[index];
            System.out.println(pr.getName() + " - " + pr.getNum());
        }
        System.out.println("Replace:");
        // Переставляем местами книги с индексом 0 и 3
        Book temp = lib[0];
        lib[0] = lib[3];
        lib[3] = temp;
        for (int index  = 0; index < lib.length; index++) {
            Book pr = lib[index];
            System.out.println(pr.getName() + " - " + pr.getNum());
        }
        System.out.println("Show Clean code:");
        // Цикл с выводом книг с именем "Clean code"
        for (int index = 0; index < lib.length; index++) {
            Book pr = lib[index];
            if (pr.getName().equals("Clean code")) {
                System.out.println(pr.getName() + " - " + pr.getNum());
            }
        }
    }
}

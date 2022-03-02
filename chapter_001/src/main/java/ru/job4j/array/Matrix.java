package ru.job4j.array;

import java.io.FileOutputStream;

/**
 * 6.6. Двухмерный массив. Таблица умножения.
 * size - указывает на размер таблицы.
 * В элементах таблицы нужно записать элементы таблицы умножения.
 *
 * 0.1. FileOutputStream.
 * Консоль - это внешний приемник.
 * Файл - это источник данных и приемник.
 * В Java источник и приемник данных описаны через абстрактные классы.
 * java.io.InputStream и java.io.OutputStream
 * Класс java.io.FileOutputStream позволяет записать данные в файл.
 * 1. Конструктор класса FileOutputStream принимает имя файла. Файл будет создан в корне проекта.
 * 2. Для записи используется метод out.write. Этот метод принимает массив байт, поэтому строку преобразовали в массив байтов.
 * 3. Любой ресурс должен быть закрыт для это используется конструкция try-with-resources.
 * Обратите внимание, что для перехода на новую строку используется System.lineSeparator().
 * Это сделано специально, поскольку переход на новую строку зависит от операционной системы.
 * В какой-то \n, в какой-то \r\n. Использование System.lineSeparator() позволяет сделать код независимым от операционной системы.
 * В задаче нужно записать результат вычисление в файл.
 */

public class Matrix {
    public static int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i != size; i++) {
            for (int j = 0; j != size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }

    public static void main(String[] args) {
        int[][] array = multiple(9);
        String rsl = "";
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                rsl = rsl + array[i][j] + " ";
            }
            rsl = rsl + "\n";
        }
        try (FileOutputStream out = new FileOutputStream("resulttable.txt")) {
            out.write(rsl.getBytes());
            out.write(System.lineSeparator().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
package ru.job4j.max;

/**
 * 2.5.1. Зона видимости переменных
 * Переменная - это именованная область памяти.
 * Имя переменной должно быть уникальным.
 * "Scope" переводится с английского как "зона видимости"
 *
 * Поле класса доступно во всех методах класса.
 * Переменная внутри метода доступна только внутри этого метода.
 *
 * Если в блоках if-else содержат одинаковые переменные.
 * Зона их видимости определяется расположением фигурных скобок.
 */

public class Reduce {
    private int[] array;

    public void to(int[] array) {
        this.array = array;
    }

    public void print() {
        for (int index = 0; index < array.length; index++) {
            System.out.println(array[index]);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        Reduce reduce = new Reduce();
        reduce.to(array);
        reduce.print();
    }
}

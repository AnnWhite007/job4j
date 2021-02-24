package ru.job4j.ex;

/**
 * 0.6. Error - исключения, связанные с работой виртуальной машины
 * java.lang.StackOverflowError - ошибка связана с переполнением области памяти stack. В ней хранятся ссылки на объекты,
 * локальные переменные и вызовы функций. Часто можно увидеть при использовании рекурсии.
 * Решение проблемы. Поиск логической ошибки в коде.
 *
 * java.lang.OutOfMemoryError - переполнение выделенной памяти для виртуальной машины. Каждая программы используют память компьютера.
 * При старте виртуальной машины ей выделяется ограниченный объем памяти. Ваша программа может израсходовать всю выделенную память.
 * Решение проблемы. Поиск утечки памяти или увеличение памяти виртуальной машины за счет ключей -Xmx.
 *
 * java.lang.LinkageError - ошибка связана с загрузкой двух одинаковых библиотек. Имена библиотек отличаются, а классы в пространстве имен остаются одинаковые.
 * Решение проблемы. Построить иерархию зависимостей библиотеки найти дублирующие классы.
 *
 * java.lang.UnsupportedClassVersionError - ошибка связана с загрузкой скомпилированного кода на виртуальной машине с более старой версией.
 * Решение проблемы. Использовать версию одинаковую со скомпилированным кодом или более новую.
 */

public class FactRec {
    public static int calc(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return calc(n - 1) * n;
    }

    public static void main(String[] args) {
        int rsl = calc(3);
        System.out.println(rsl);
    }
}

package ru.job4j.oop;

/**
 * 2.1.3. Вызов метода с аргументами.
 *в методах можно указать входящие параметры.
 * Термин "входящие параметры" обозначает переменные,
 * которые будут доступны внутри метода
 * и которые нужно проинициализировать при вызове этого метода.
 */
public class Jukebox {
    public static void main(String[] args) {
        Jukebox one = new Jukebox();
        one.music(1);
    }
    public void music(int position) {
        if (position == 1) {
        System.out.println("Пусть бегут неуклюже");
    } else if (position == 2) {
            System.out.println("Пусть бегут неуклюже");
        } else {
            System.out.println("Песня не найдена");
        }
    }
}

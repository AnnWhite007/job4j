package ru.job4j.oop;

/**
 * 2.1.4. Вызов метода с возвращаемым типом.
 * Чтобы метод мог вернуть значение надо в объявление метода вместо слова void
 * указать тип данных, который описывает результат работы метода.
 */
public class DummyDic {
    public static void main(String[] args){
        DummyDic first = new DummyDic();
        String word = "table";
        System.out.println (first.engToRus(word));
    }
    public String engToRus(String eng) {
        return "Неизвестное слово: " + eng;
    }
}

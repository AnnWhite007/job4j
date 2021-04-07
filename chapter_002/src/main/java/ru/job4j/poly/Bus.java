package ru.job4j.poly;

/**
 * implements Input - эта строчка заставляет нас в классе StubInput создать те же методы,
 * что и в интерфейсе Input и добавить в них реализацию.
 */
public class Bus implements Transport {

    @Override
    public String askStr(String question) {
        return null;
    }

    @Override
    public int askInt(String question) {
        return 0;
    }

    @Override
    public void ehat() {

    }

    @Override
    public void passajiri(int num) {

    }

    @Override
    public int zapravit(int litres) {
        return 0;
    }
}

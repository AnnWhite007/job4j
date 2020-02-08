package ru.job4j.array;

/**
 * 6.3. Массив заполнен true или false.
 * {true, true, true} - вернет true; массив однородный, он заполнен true.
 * {true, false, true} - вернет false; массив не однородный, он заполнен и true и false.
 * {false, false, false} - вернет true; массив однородный, он заполнен false.
 *
 */

public class Check {
    //Метод должен проверить, что все элементы в массиве являются или true или false.
    public boolean mono(boolean[] data) {
        boolean result = true;
            for (boolean index : data) {
                if (data[0] != index) {
                    result = false;
                    break;
                }
            }
        return result;
    }
}
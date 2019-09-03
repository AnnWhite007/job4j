package ru.job4j.loop;

public class Counter {
    public int add(int start, int finish) {
        int sum = 0;
        if (start % 2 == 0) {
            for (; start <= finish; start = start + 2)
                sum = sum + start;
        } else {
            for (start = start + 1; start <= finish; start = start + 2)
                sum = sum + start;
        }
        return sum;
    }
}
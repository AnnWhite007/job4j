package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {
    //для первого метода
    @Test
    public void whenArrayHas5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }
    @Test
    public void whenArrayHas5ThenNo() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {7, 6, 9, 25};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
    @Test
    public void whenArrayHas13Then3() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {4, 11, 88, 13};
        int value = 13;
        int result = find.indexOf(input, value);
        int expect = 3;
        assertThat(result, is(expect));
    }
   // для второго метода
    @Test
    public void whenFind3() {
        int[] data = new int[] {5, 2, 10, 2, 4};
        int el = 2;
        int start = 2;
        int finish = 4;
        int result = FindLoop.indexOf(data, el, start, finish);
        int expect = 3;
        assertThat(result, is(expect));
    }
    @Test
    public void whenFind2() {
        int[] data = new int[] {6, 11, 9, 1, 0, 9, 4};
        int el = 9;
        int start = 1;
        int finish = 3;
        int result = FindLoop.indexOf(data, el, start, finish);
        int expect = 2;
        assertThat(result, is(expect));
    }
}
package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {

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
}
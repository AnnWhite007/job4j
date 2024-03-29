package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CheckTest {

    /** В тестах можно сразу проверять целиком массив через метод assertThat(resultArray, is(expectArray)) */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[]{true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[]{true, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenDataNotMonoByThreeTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[]{true, false, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenDataNotMonoByFourFalse() {
        Check check = new Check();
        boolean[] input = new boolean[]{false, false, false, false};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
}
package ru.job4j.lambda;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;


import java.util.Arrays;
import java.util.List;

public class FunctionCounterTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionCounter.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenKvadrResults() {
        List<Double> result = FunctionCounter.diapason(2, 4, x -> Math.pow(x, 2));
        List<Double> expected = Arrays.asList(4D, 9D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenPokazResults() {
        List<Double> result = FunctionCounter.diapason(1, 4, x -> Math.pow(x, x));
        List<Double> expected = Arrays.asList(1D, 4D, 27D);
        assertThat(result, is(expected));
    }
}

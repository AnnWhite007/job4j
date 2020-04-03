package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void dist() {
        Point a = new Point(3, 3, 3);
        Point b = new Point(3, 3, 5);
        double result = a.distance3d(b);
        assertThat(result, is(2.0));
    }
}
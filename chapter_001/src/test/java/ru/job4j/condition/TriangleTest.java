package ru.job4j.condition;

import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@Ignore
public class TriangleTest {

    /*
    @Test
    public void whenExist() {
        boolean result = Triangle.exist(2.0, 2.0, 2.0);
        assertThat(result, is(true));
    }
    public void whenNotExist() {
        boolean result = Triangle.exist(2.0, 2.0, 1.0);
        assertThat(result, is(false));
    }

     */
    @Test
    public void whenExist() {
        Point first = new Point(6, 1);
        Point second = new Point(2, 1);
        Point third = new Point(3, 3);
        Triangle check = new Triangle(first, second, third);
        double result = check.area();
        assertThat(result, is(4.000000000000001));
    }
    public void whenNotExist() {
        Point first = new Point(1, 1);
        Point second = new Point(2, 2);
        Point third = new Point(3, 3);
        Triangle check = new Triangle(first, second, third);
        double result = check.area();
        assertThat(result, is(-1));
    }

}
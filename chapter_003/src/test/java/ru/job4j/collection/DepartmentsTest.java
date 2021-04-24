package ru.job4j.collection;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = Arrays.asList("k1", "k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenDif() {
        List<String> input = Arrays.asList("k2", "k1/sk10", "k2/sk1/ssk4");
        List<String> expect = Arrays.asList("k2", "k1", "k1/sk10",  "k2/sk1", "k2/sk1/ssk4");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortAsc() {
        List<String> input = Arrays.asList("k2", "k1/sk10", "k2/sk1/ssk4");
        List<String> result = Departments.fillGaps(input);
        Departments.sortAsc(result);
        List<String> expect = Arrays.asList("k1", "k1/sk10", "k2", "k2/sk1", "k2/sk1/ssk4");
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortDesc() {
        List<String> input = Arrays.asList("k2", "k1/sk10", "k2/sk1/ssk4");
        List<String> result = Departments.fillGaps(input);
        Departments.sortDesc(result);
        List<String> expect = Arrays.asList("k2", "k2/sk1", "k2/sk1/ssk4", "k1", "k1/sk10");
        assertThat(result, is(expect));
    }
}
package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Метод возвращает меньше нуля, ноль, больше нуля.
 * Меньше нуля - если входящее значение больше, чем текущий объект.
 * Ноль - если значение равны.
 * Больше нуля - если текущее значение больше, чем входящее.
 * Чтобы обеспечить сортировку по убыванию,
 * в компараторе мы сравниваем второй параметр с первым,
 * а в случае сортировки по возрастанию - первый со вторым.
 */
public class JobTest {
    @Test
    public void whenCompatorByNameDownAndProrityDown() {
        Comparator<Job> cmpNamePriorityDown = new JobDescByNameDown().thenComparing(new JobDescByPriorityDown());
        int rsl = cmpNamePriorityDown.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameDown() {
        int rsl = new JobDescByNameDown().compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameUp() {
        int rsl = new JobDescByNameUp().compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByPriorityDown() {
        int rsl = new JobDescByPriorityDown().compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 0)
        );
        assertThat(rsl, equalTo(0));
    }

    @Test
    public void whenCompatorByPriorityUp() {
        int rsl = new JobDescByPriorityUp().compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameUpAndProrityUp() {
        Comparator<Job> cmpNamePriorityUp = new JobDescByNameUp().thenComparing(new JobDescByPriorityUp());
        int rsl = cmpNamePriorityUp.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}
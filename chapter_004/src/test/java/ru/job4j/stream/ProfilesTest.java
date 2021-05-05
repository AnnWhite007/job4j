package ru.job4j.stream;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    @Test
    public void whenCollectAddress() {
        List<Profile> profiles = List.of(
                new Profile(new Address("Moscow", "Novay", 5, 6)),
                new Profile(new Address("Kirov", "Lenina", 1, 2))
        );
        List<Address> rsl = Profiles.collect(profiles);
        List<Address> expected = List.of(
                new Address("Moscow", "Novay", 5, 6),
                new Address("Kirov", "Lenina", 1, 2)
        );
        assertThat(rsl, is(expected));
    }
}

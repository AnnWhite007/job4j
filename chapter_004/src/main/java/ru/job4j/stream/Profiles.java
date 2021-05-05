package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 2. Список адресов
 * В туристической компании появилась задача составить список адресов клиентов.
 * В анкете у клиента, есть адрес проживания.
 * Анкета клиента описывается моделью
 */

public class Profiles {
    public static List<Address> collect(List<Profile> profiles) {
        List<Address> rsl = profiles.stream()
                .map(profile -> profile.getAddress())
                .collect(Collectors.toList());
        return rsl;
    }
}

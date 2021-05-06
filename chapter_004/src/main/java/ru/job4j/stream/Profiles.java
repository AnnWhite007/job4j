package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 2. Список адресов
 * В туристической компании появилась задача составить список адресов клиентов.
 * В анкете у клиента, есть адрес проживания.
 * Анкета клиента описывается моделью.
 *
 * 3. Уникальность элементов и сортировка.
 * - Оказалось, что часть людей живет по одному и тому же адресу. Нужно в списке оставить только уникальные элементы.
 * Метод distinct()  - позволяет убрать дублирующие элементы.
 * - Для быстрого поиска по адресам список нужно отсортировать.
 */

public class Profiles {
    public static List<Address> collect(List<Profile> profiles) {
        List<Address> rsl = profiles.stream()
                .map(Profile::getAddress)
                .sorted(Comparator.comparing(Address::getCity))
                .distinct()
                .collect(Collectors.toList());
        return rsl;
    }
}

package ru.job4j.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. Паспорт и жители
 * Нам нужно занести всех пользователей в систему и выдать им уникальный номер.
 * + находить информацию о пользователе по номеру паспорта.
 * Ассоциация - это номер паспорта, который ассоциирован с информацией о пользователе.
 * Для решения потребуются методы Map.containsKey(key) и Map.get(key).
 */

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl = false;
        if (get(citizen.getPassport()) == null) {
            citizens.put(citizen.getPassport(), citizen);
            rsl = true;
        }
        return rsl;
    }

    public Citizen get(String passport) {
            if (citizens.containsKey(passport)) {
                return citizens.get(passport);
            }
        return null;
    }
}
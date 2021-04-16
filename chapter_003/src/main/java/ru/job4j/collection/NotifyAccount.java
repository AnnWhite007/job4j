package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

/**
 * 3. Модели данных и HashSet.
 * Уникальность элементов в HashSet проверяется через методы equals и hashCode.
 * Если мы хотим хранить в HashSet пользовательские темы данных нам нужно обеспечить эти модели методами equals и hashCode.
 * Всегда переопределяйте методы equals и hashCode в моделях данных (это класс, который является контейнером и описывает бизнес-модель вашего приложения.).
 * Решение этой задачи сводиться к преобразованию List в Set.
 * HashSet устранит дубликаты клиентов банка самостоятельно.
 */

public class NotifyAccount {
    public static HashSet<Account> sent(List<Account> accounts) {
        HashSet<Account> rsl = new HashSet<>();
        /* for-each accounts to HashSet; */
        for (Account man : accounts) {
                rsl.add(man);
        }
        return rsl;
    }
}
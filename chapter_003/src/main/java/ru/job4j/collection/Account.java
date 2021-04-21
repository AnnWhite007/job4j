package ru.job4j.collection;

import java.util.Objects;

/**
 * Всегда переопределяйте методы equals и hashCode в моделях данных (это класс, который является контейнером и описывает бизнес-модель вашего приложения.).
 * Для вычисления equals и hashCode тут используется только одно поле - это серия и номер паспорта.
 * Этого поля достаточно, чтобы проверить, что клиент банка уникален.
 */

public class Account {
    private String passport;
    private String username;
    private String deposit;

    public Account(String passport, String username, String deposit) {
        this.passport = passport;
        this.username = username;
        this.deposit = deposit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(passport, account.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }

    @Override
    public String toString() {
        return "Account{"
                + "passport='" + passport + '\''
                + ", username='" + username + '\''
                + ", deposit='" + deposit + '\''
                + '}';
    }
}
package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает модель для банковской системы
 * @author ANNA BABINTSEVA
 * @version 1.0
 */

// 3. Банковские переводы
// В этом задании вам нужно разработать модель для банковской системы.
// В системе можно производить следующие действия.
// Регистрировать пользователя.
// Удалять пользователя из системы.
// Добавлять пользователю банковский счет. У пользователя системы могут быть несколько счетов.
// Переводить деньги с одного банковского счета на другой счет.

public class BankService {
    /**
     *  Хранение всех пользователей системы с привязанными к ним счетами осуществляется в коллекции типа Map
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет пользователя и пустую коллекцию счетов в систему, если такого еще нет.
     * @param user - новый пользователь
     */
    //Метод putIfAbsent позволяет проверить, если ли такой ключ в карте или нет и если его нет, то произвести вставку данных.
    public void addUser(User user) {
            users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод принимает параметр пользователя и счет и добавляет счет в коллекцию конкретного пользователя, если его еще нет в коллеции .
     * @param passport - номер паспорта пользователя
     * @param account - счет, который нужно добавить
     */
    public void addAccount(String passport, Account account) {
        User man = findByPassport(passport);
            if (man != null && !users.get(man).contains(account)) {
                users.get(man).add(account);
        }
    }

    /**
     * Метод принимает параметр пользователя и находит его.
     * @param passport - номер паспорта пользователя
     * @return - возвращает ключ пользователя если пользователь найден, 0 если нет
     */
    public User findByPassport(String passport) {
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                return key;
            }
        }
        return null;
    }

    /**
     * Метод принимает параметр пользователя и номер счета и находит данные по этому счету
     * @param passport - номер паспорта пользователя
     * @param requisite - счет пользователя
     * @return  - возвращает данные по счету, если пользователь и счет найдены, 0 если нет.
     */
    public Account findByRequisite(String passport, String requisite) {
        User man = findByPassport(passport);
        if (man != null) {
            for (Account money : users.get(man)) {
                if (money.getRequisite().equals(requisite)) {
                    return money;
                }
            }
        }
        return null;
    }

    /**
     * Метод принимает параметр пользователей и их счета и позволяет перевести средства с одного счета на другой.
     * Проверяет по паспорту и счетам есть ли пользователи и счета в системе. Сравнивает суммы и переводит если хватает.
     * @param srcPassport - номер паспорта пользователя, со счета которого будут переводиться сретдства
     * @param srcRequisite - номер счета, с которого переводим
     * @param destPassport - номер паспорта пользователя, на счет которого будут переводиться сретдства
     * @param destRequisite - номер счета, на который переводим
     * @param amount - сумма перевода
     * @return - если перевод прошел успешно true, false если нет.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account moneySrc = findByRequisite(srcPassport, srcRequisite);
        Account moneyDest = findByRequisite(destPassport, destRequisite);
        if (moneySrc != null
                && moneyDest != null
                && amount <= moneySrc.getBalance()) {
           moneySrc.setBalance(moneySrc.getBalance() - amount);
           moneyDest.setBalance(moneyDest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
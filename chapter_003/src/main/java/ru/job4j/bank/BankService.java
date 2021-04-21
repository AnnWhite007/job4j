package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 3. Банковские переводы
 * В этом задании вам нужно разработать модель для банковской системы.
 * В системе можно производить следующие действия.
 * 1. Регистрировать пользователя.
 * 2. Удалять пользователя из системы.
 * 3. Добавлять пользователю банковский счет. У пользователя системы могут быть несколько счетов.
 * 4. Переводить деньги с одного банковского счета на другой счет.
 *  * @author ANNA BABINTSEVA
 *  * @version 1.0
 */

public class BankService {
    /**
     *  Хранение всех пользователей системы с привязанными к ним счетами в коллекции Map
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Этот метод должен добавить пользователя и пустую коллекцию счетов в систему.
     * Метод putIfAbsent позволяет проверить, если ли такой ключ в карте или нет и если его нет, то произвести вставку данных.
     * @param user - новый пользователь
     */
    public void addUser(User user) {
            users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Этот метод должен добавить счет в коллекцию конкретного пользователя .
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
     * Этот метод должен найти пользователя по паспорту.
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
     * Этот метод позволяет найти данные по счету
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
     * Метод позволяет перевести средства с одного счета на другой.
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
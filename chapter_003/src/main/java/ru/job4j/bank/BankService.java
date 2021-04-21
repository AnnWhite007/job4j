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
 */

public class BankService {
    //Это поле содержит всех пользователей системы с привязанными к ним счетами.
    private Map<User, List<Account>> users = new HashMap<>();
//Этот метод должен добавить пользователя в систему.
    public void addUser(User user) {
        //Метод putIfAbsent позволяет проверить, если ли такой ключ в карте или нет и если его нет, то произвести вставку данных.
            users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User man = findByPassport(passport);
            if (man != null && !users.get(man).contains(account)) {
                users.get(man).add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                return key;
            }
        }
        return null;
    }

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
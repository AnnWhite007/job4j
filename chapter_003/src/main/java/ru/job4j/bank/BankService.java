package ru.job4j.bank;

import java.util.*;
import java.util.stream.Stream;

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

// 6. Тестовое задание из модуля коллекции Lite переделать на Stream API.
// рассмотрим примеры использования методов Stream API для коллекций типа Map.
// Поскольку Map не является наследником интерфейса Collection, то в Map не определен метод stream()
// - соответственно мы не можем получить поток значений напрямую. Однако у Map есть метод keySet(),
// который возвращает набор всех ключей в виде коллекции типа Set.
// В качестве терминальной операции будем использовать findFirst()
// - метод возвращает результат в виде объекта типа Optional.
// Однако поскольку на выходе нас интересует именно объект типа Student или Subject
// - для возврата значения используем метод orElse(), который возвращает значение если в объекте Optional есть значение,
// иначе - то значение которое мы передали в этот метод - в нашем случае это будет null.


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
        User man = findByPassport(passport).get();
            if (man != null && !users.get(man).contains(account)) {
                users.get(man).add(account);
        }
    }

    /**
     * Метод принимает параметр пользователя и находит его.
     * @param passport - номер паспорта пользователя
     * @return - возвращает ключ пользователя если пользователь найден, 0 если нет
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод принимает параметр пользователя и номер счета и находит данные по этому счету
     * @param passport - номер паспорта пользователя
     * @param requisite - счет пользователя
     * @return  - возвращает данные по счету, если пользователь и счет найдены, 0 если нет.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> man = findByPassport(passport);
        if (man != null) {
            return users.get(man)
                    .stream()
                    .filter(u -> u.getRequisite().equals(requisite))
                    .findFirst();
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
        Optional<Account> moneySrc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> moneyDest = findByRequisite(destPassport, destRequisite);
        if (moneySrc != null
                && moneyDest != null
                && amount <= moneySrc.get().getBalance()) {
           moneySrc.get().setBalance(moneySrc.get().getBalance() - amount);
           moneyDest.get().setBalance(moneyDest.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
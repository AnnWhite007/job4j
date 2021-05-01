package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 2.0. Встроенные функциональные интерфейсы.
 * Шаблон проектирования стратегия – это поведенческий шаблон проектирования,
 * который определяет семейство схожих алгоритмов и помещает каждый из них в собственный класс.
 * После этого, алгоритмы можно взаимозаменять прямо во время выполнения программы.
 * Т.е. данный шаблон предлагает определить семейство схожих алгоритмов, которые часто изменяются или расширяются,
 * и вынести их в отдельные классы, называемые стратегиями.
 * Вместо того чтобы изначальный класс сам выполнял тот или иной алгоритм,
 * он будет играть роль контекста и будет ссылаться на одну из стратегий и делегировать ей выполнение работы.
 * А для смены алгоритма будет достаточно подставить в контекст другой объект-стратегию.
 * Все стратегии должны иметь общий интерфейс. Используя этот интерфейс,
 * контекст будет независимым от конкретных классов стратегий.
 */

public class SearchFolder {
    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        List<Folder> rsl = new ArrayList<>();
        for (Folder f : list) {
          if (pred.test(f)) {
              rsl.add(f);
          }
        }
        return rsl;
    }
}
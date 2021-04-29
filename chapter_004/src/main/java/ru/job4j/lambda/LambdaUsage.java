package ru.job4j.lambda;

import java.util.Comparator;

/**
 * 2.1. Лямбда
 * В программировании термин лямбда обозначает возможность передать в качестве параметра блок кода.
 * Переданный блок кода может быть вызван в любой момент времени или не вызван вообще.
 * Правая сторона - это вывернутый наизнанку метод compare.
 * Java получает тип данных из объявления переменной
 * Символы тире и больше указывают на начало тела метода.
 * Если выражение содержит единственный оператор return, то его стоит убрать.
 *
 * 2.2. Лямбда блок
 * Если вычисление может занять несколько строчек. В этом случае лямбда описывается через блок.
 *
 */

public class LambdaUsage {
      public static void main(String[] args) {

          Comparator<String> cmpText = (left, right) -> {
              //с выводом отладочной информации на консоль
              System.out.println("compare - " + left + " : " + right);
              return left.compareTo(right);
          };

          Comparator<String> cmpDescSize = (left, right) -> {
              //с выводом отладочной информации на консоль
              System.out.println("compare - " + right.length() + " : " + left.length());
              return right.length() - left.length();
          };
      }
}

package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

/**
 * 2. Функциональный интерфейс
 * - это интерфейс, который содержит только один абстрактный метод.
 * Абстрактный метод - это метод в котором нет реализации.
 * Чтобы использовать функциональные интерфейсы надо импортировать их – import java.util.function.*
 * Буквы T, U, R – элементы обобщенного программирования,  чтобы под каждый тип данных не создавать отдельный интерфейс,
 * а просто вместо T U и R мы можем просто поставить любой тип и многократно переиспользовать один и тот же интерфейс с разным набором типов данных.
 * Функциональные интерфейсы:
 * 1. Supplier (поставщик) используется для создания какого-либо объекта и при этом ему не требуется входной параметр.
 * "@FunctionalInterface"
 * "public interface Supplier<T> {"
 * "    T get();"
 * "}"
 * 2. Consumer (BiConsumer) (потребитель) используется в том случае, если нам нужно применить какое-то действие
 * или операцию к параметру (для BiConsumer два параметра) и при этом у метода нет возвращаемого значения.
 * "@FunctionalInterface"
 * "public interface Consumer<T> {"
 * "    void accept(T t);"
 * "}"
 * "@FunctionalInterface"
 * "public interface BiConsumer<T, U> {"
 * "    void accept(T t, U u);"
 * "}"
 * 3. Predicate (BiPredicate) (утверждение) наиболее часто применяется в фильтрах и сравнении.
 * в метод test() передается один или два параметра, в зависимости от функционального интерфейса
 * и возвращает логическое значение true или false.
 * "@FunctionalInterface"
 * "public interface Predicate<T> {"
 * "    boolean test(T t)"
 * "}"
 * "@FunctionalInterface"
 * "public interface BiPredicate<T, U> {"
 * "    boolean test(T t, U u);"
 * "}"
 * 4. Function (BiFunction)используется для преобразования входного параметра или двух параметров
 * (для Bi-формы этого функционального интерфейса) в какое-либо значение,
 * тип возвращаемого значения может не совпадать с типом входных параметров.
 * Несмотря на то, что в лямбда выражение передается один параметр, в обобщенных типах
 * мы должны указать 2 параметра – вторым параметром мы указываем тип возвращаемого значения
 * "@FunctionalInterface"
 * "public interface Function<T, R> {"
 * "    R apply(T t);"
 * "}"
 * "@FunctionalInterface"
 * "public interface BiFunction<T, U, R> {"
 * "    R apply(T t, U u);"
 * "}"
 * 5. UnaryOperator и BinaryOperator– это разновидность Function,
 * в которых входные и выходные обобщенные параметры должны совпадать.
 * Эти два интерфейса расширяют Function и BiFunction соответственно.
 * "@FunctionalInterface"
 * "public interface UnaryOperator<T> extends Function<T, T> {}"
 * "@FunctionalInterface"
 * "public interface BinaryOperator<T> extends BiFunction<T,T,T> {}"
 * для функциональных интерфейсов UnaryOperator и BinaryOperator обобщенные типы должны совпадать
 * и указывать три одинаковых типа обобщения не имеет смысла.
 *
 * помимо абстрактных методов функциональные интерфейсы могут иметь целый набор статических методов или методы по умолчанию.
 */

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        // вставка элементов в карту с использованием BiConsumer
        BiConsumer<Integer, String> biCon = (i, s) -> map.put(i, s);
        biCon.accept(1, "one");
        biCon.accept(2, "two");
        biCon.accept(3, "three");
        biCon.accept(4, "four");
        biCon.accept(5, "five");
        biCon.accept(6, "six");
        biCon.accept(7, "seven");

        BiPredicate<Integer, String> biPred = (i, s) -> i % 2 == 0 || s.length() == 4;
        for (Integer i : map.keySet()) {
            if (biPred.test(i, map.get(i))) {
                System.out.println("key: " + i + " value: " + map.get(i));
            }
        }
            Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
            List<String> strings = sup.get();
            Consumer<String> con = (s) -> System.out.println(s);
            Function<String, String> func = s -> s.toUpperCase();
            for (String s : strings) {
                con.accept(func.apply(s));
            }
    }
}
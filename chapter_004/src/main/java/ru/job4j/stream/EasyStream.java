package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Экзамен. Lambda, Stream API, JDK Features.
 * EasyStream
 * Представьте, что разработчики JDK не сделали Stream API.
 * В этом задании Вам нужно реализовать каркас упрощенного Stream API.
 *
 * of - получает исходные данные
 * map - преобразует число в другое число
 * filter - фильтрует поток элементов
 * collect - собирает все элементы из source по заданным условиям map и filter
 */

public class EasyStream {
    private List<Integer> list = new ArrayList<Integer>();

    private EasyStream(List<Integer> origin) {
            this.list.addAll(origin);
    }

    public static EasyStream of(List<Integer> source) {
        EasyStream easyStream = new EasyStream(source);
        return easyStream;
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> forMap = new ArrayList<Integer>();
        for (Integer value : list) {
            forMap.add(fun.apply(value));
        }
        EasyStream easyStream = new EasyStream(forMap);
        return easyStream;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> forFil = new ArrayList<Integer>();
        for (Integer value : list) {
            if (fun.test(value)) {
                forFil.add(value);
            }
        }
        EasyStream easyStream = new EasyStream(forFil);
        return easyStream;
    }

    public List<Integer> collect() {
        List<Integer> forCol = new ArrayList<Integer>();
        forCol.addAll(this.list);
        return forCol;
    }
}
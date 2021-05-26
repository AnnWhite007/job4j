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
 */

public class EasyStream {
    private List<Integer> list = new ArrayList<Integer>();

    private EasyStream(List<Integer> origin) {
            this.list.addAll(origin);
    }
    //получает исходные данные
    public static EasyStream of(List<Integer> source) {
        EasyStream easyStream = new EasyStream(source);
        return easyStream;
    }
//преобразует число в другое число
    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> forMap = new ArrayList<Integer>();
        for (Integer value : list) {
            forMap.add(fun.apply(value));
        }
        EasyStream easyStream = new EasyStream(forMap);
        return easyStream;
    }
//фильтрует поток элементов
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
//собирает все элементы из source по заданным условиям map и filter
    public List<Integer> collect() {
        List<Integer> forCol = new ArrayList<Integer>();
        forCol.addAll(this.list);
        return forCol;
    }
}
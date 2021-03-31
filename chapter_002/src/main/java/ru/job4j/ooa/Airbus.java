package ru.job4j.ooa;

/**
 * Модификатор final - "окончательный, последний". Ключевое слово чтобы сделать дальнейшее изменение объекта невозможным.
 * если мы задали переменную у которой есть ключевое слово final, то изменить ее мы не сможем.
 * final для методов - при наследовании данный метод нельзя будет переопределить
 * Final для классов - не сможем создать наследников этого класса, в какой-то степени, и все его методы тоже становятся final
 * Важная особенность поведения ключевого слова final для ссылочных типов данных - после присвоения объекта, нельзя изменить ссылку на данный объект.
 * Однако при этом мы можем изменить внутреннее состояние объекта.
 * Необходимо чтобы класс Airbus нельзя было наследовать;
 * Метод printCountEngine() должен выводить реальное количество двигателей,
 * которое присуще той или иной модели самолета.
 * Поэтому если модель самолета A380 - количество двигателей должно равняться 4,
 * для всех остальных моделей - используем в качестве значения константу COUNT_ENGINE.
 */

public final class Airbus extends Aircraft {
    // константа на уровне класса
    private static final int COUNT_ENGINE = 2;
    private String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printModel() {
        System.out.println("Модель самолета: " + name);
    }

    public void printCountEngine() {
        int count = (name.equals("A380") ? 4 : COUNT_ENGINE);
        System.out.println("Количество двигателей равно: " + count);
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}

package ru.job4j.strategy;

/**
 * 7. Шаблон проектирования - Стратегия
 * - относится к поведенческим шаблонам.
 * Он позволяет изменить алгоритм работы программы в запущенной программе.
 * Термин шаблон проектирование означает схему решения часто возникающей задачи проектирования.
 * Paint - описывает основное поведение программы. Он использует действия интерфейса Shape.
 * Интерфейс Shape - описывает обобщенное действие.
 * Классы Triangle и Square - реализуют конкретное действие системы. Эти классы реализуют интерфейс Shape.
 *
 * В классе Paint реализовать метод public void draw(Shape shape).
 * Метод draw() должен печатать псевдокартинку на консоль через метод System.out.println(shape.draw())
 */

public class Paint {
    public void draw(Shape shape) {
        System.out.print(shape.draw());
    }

    public static void main(String[] args) {
        Paint context = new Paint();
        context.draw(new Triangle());
        context.draw(new Square());
    }
}

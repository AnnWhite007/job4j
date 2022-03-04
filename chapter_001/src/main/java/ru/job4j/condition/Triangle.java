package ru.job4j.condition;

/**
 * 4.3. Вычисление площади треугольника.
 * Нужно проверить, что треугольник может существовать.
 * треугольник может существовать, если сумму двух сторон больше третьей для всех комбинаций.
 * Допустим у нас заданы три переменные
 * double ab, ac, dc - это длины сторон.
 *
 * 2. Рефакторинг - Площадь треугольника.
 * Создадим три поля с типом Point.
 * Создадим конструктор с тремя переменными типа Point.
 * Проинициализируем начальная состояние объекта Triangle c помощью входящих параметров.
 * Поправим метод area. Нужно убрать входящие параметры, вместо них нужно использовать поля объекта
 * public class Triangle {
 *     public static boolean exist(double ab, double ac, double bc) {
 *         if (ab + ac > bc && ac + bc > ab && ab + bc > ac) {
 *             return true;
 *         } else {
 *             return false;
 *         }
 *     }
 * }
 */

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    /**
     * Метод вычисления  полу-периметра по длинам сторон.
     * Формула.
     * (a + b + c) / 2
     * @param a расстояние между точками a b
     * @param b расстояние между точками a c
     * @param c расстояние между точками b c
     * @return полу-Периметр.
     */
    public double period(double a, double b, double c) {
        return ((a + b + c) / 2);
    }

    /**
     * Метод должен вычислить площадь треугольника.
     * Формула.
     * √ p *(p - ab) * (p - ac) * (p - bc)
     * где √ - корень квадратный, для извлечения корня использовать метод Math.sqrt().
     * @return Вернуть площадь, если треугольник существует или -1.
     */
    public double area() {
        double rsl = -1;
        double a = first.distance(second);
        double b = first.distance(third);
        double c = second.distance(third);
        double p = period(a, b, c);
        if (this.exist(a, b, c)) {
            rsl = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return rsl;
    }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     * @return возвращается условие, чтобы определить можно ли построить треугольник.
     * @param a Длина от точки a b.
     * @param b Длина от точки a c.
     * @param c Длина от точки b c.
     */
    private boolean exist(double a, double c, double b) {
            return a + b > c && b + c > a && a + c > b;
    }
}
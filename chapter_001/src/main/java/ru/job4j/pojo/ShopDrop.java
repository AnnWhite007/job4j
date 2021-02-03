package ru.job4j.pojo;

/**
 * 3.2. Удаление моделей из массива.
 * Метод должен сместить ячейки на одну позицию влево.
 * Метод leftShift принимает индекс ячейки, с которого нужно начинать смещение
 */
public class ShopDrop {
    public static Product[] leftShift(Product[] products, int index) {
        if (index < products.length - 1) {
            products[index] = products[index + 1];
            products[index + 1] = null;
        }
        else {
            products[index] = null;
        }
        return products;
    }
}

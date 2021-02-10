package ru.job4j.pojo;

/**
 * 3.2. Удаление моделей из массива.
 * Метод должен сместить ячейки на одну позицию влево.
 * Метод leftShift принимает индекс ячейки, с которого нужно начинать смещение
 */
public class ShopDrop {
    public static Product[] leftShift(Product[] products, int index) {
        for (int i = index; i < products.length; i++) {
            if (i < products.length - 1) {
                products[i] = products[i + 1];
                products[i + 1] = null;
            } else {
                products[i] = null;
            }
        }
            return products;
    }
}

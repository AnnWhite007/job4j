package ru.job4j.pojo;

/**
 * 3.2. Удаление моделей из массива.
 * Метод должен сместить ячейки на одну позицию влево.
 * Метод leftShift принимает индекс ячейки, с которого нужно начинать смещение
 */
public class ShopDrop {
    public static Product[] leftShift(Product[] products, int index) {
        for (int i = index; i < products.length - 1; i++) {
                products[i] = products[i + 1];
            }
        products[products.length - 1] = null;
        return products;
    }
}

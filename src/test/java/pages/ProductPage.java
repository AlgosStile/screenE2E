package pages;

import core.ui.Target;

/**
 * Страница продукта, содержащая целевые элементы,
 * с которыми может взаимодействовать актер.
 * Включает опции выбора объема памяти, кнопки для изменения количества
 * и кнопку для добавления товара в корзину.
 */
public class ProductPage {
    public static final Target STORAGE_OPTION_32 = Target.the("Диск 32 ГБ")
            .locatedBy("//label[.//input[@value='32']]");

    public static final Target STORAGE_OPTION_64 = Target.the("Диск 64 ГБ")
            .locatedBy("//label[.//input[@value='64']]");
    public static final Target STORAGE_OPTION_128 = Target.the("Диск 128 ГБ")
            .locatedBy("//label[.//input[@value='128']]");
    public static final Target QUANTITY_PLUS = Target.the("Кнопка увеличения количества")
            .locatedBy("//button[@aria-label='Добавить один товар']");

    public static final Target QUANTITY_MINUS = Target.the("Кнопка уменьшения количества")
            .locatedBy("//button[@aria-label='Убрать один товар']");

    public static final Target ADD_TO_CART_BUTTON = Target.the("Кнопка добавления в корзину")
            .locatedBy("//button[@type='submit']");
}



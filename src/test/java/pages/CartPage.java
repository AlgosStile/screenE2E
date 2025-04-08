package pages;


import core.ui.Target;

/**
 * Страница корзины, содержащая целевые элементы,
 * с которыми может взаимодействовать актер.
 * Включает кнопки для увеличения и уменьшения количества товаров,
 * а также кнопку для оформления заказа.
 */
public class CartPage {
    public static final Target QUANTITY_PLUS = Target.the("Кнопка '+' в корзине")
            .locatedBy("//button[@aria-label='Добавить один товар']");

    public static final Target QUANTITY_MINUS = Target.the("Кнопка '-' в корзине")
            .locatedBy("//button[@aria-label='Убрать один товар']");

    public static final Target CHECKOUT_BUTTON = Target.the("Кнопка 'Оформить заказ'")
            .locatedBy("//button[@type='submit']");
}


package pages;

import core.ui.Target;

/**
 * Страница заголовка, содержащая целевые элементы,
 * с которыми может взаимодействовать актер.
 * Включает иконку корзины, отображающую количество товаров.
 */
public class HeaderPage {
    public static final Target CART_ICON = Target.the("Иконка корзины")
            .locatedBy("//span[@aria-label='Количество товаров']");
}
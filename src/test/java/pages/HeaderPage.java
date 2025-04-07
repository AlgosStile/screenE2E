package pages;

import core.ui.Target;

public class HeaderPage {
    public static final Target CART_ICON = Target.the("Иконка корзины")
            .locatedBy("//span[@aria-label='Количество товаров']");
}
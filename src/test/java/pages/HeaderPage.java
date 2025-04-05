package pages;

import core.ui.Target;

public class HeaderPage {
    public static final Target CART_ICON = Target.the("Иконка корзины")
            .locatedBy("[data-test='header-cart']");

    public static final Target CART_ITEMS_COUNT = Target.the("Количество товаров в корзине")
            .locatedBy("[data-test='cart-counter']");
}
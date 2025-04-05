package pages;

import core.ui.Target;

public class CartPage {
    public static final Target PLUS_QUANTITY = Target.the("Кнопка увеличения количества")
            .locatedBy("[data-test='cart-item-plus']");

    public static final Target MINUS_QUANTITY = Target.the("Кнопка уменьшения количества")
            .locatedBy("[data-test='cart-item-minus']");

    public static final Target CHECKOUT_BUTTON = Target.the("Кнопка оформления заказа")
            .locatedBy("[data-test='cart-checkout']");

    public static final Target ITEM_PRICE = Target.the("Цена товара")
            .locatedBy("[data-test='cart-item-price']");
}
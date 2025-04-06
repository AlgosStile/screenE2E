package pages;


import core.ui.Target;

public class CartPage {
    public static final Target QUANTITY_PLUS = Target.the("Кнопка '+' в корзине")
            .locatedBy(".cart-item .quantity-plus");

    public static final Target QUANTITY_MINUS = Target.the("Кнопка '-' в корзине")
            .locatedBy(".cart-item .quantity-minus");

    public static final Target CHECKOUT_BUTTON = Target.the("Кнопка оформления заказа")
            .locatedBy("button.checkout");
}


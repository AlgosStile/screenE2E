package pages;

import core.ui.Target;

public class ProductPage {
    public static final Target ADD_BUTTON = Target.the("Кнопка добавления")
            .locatedBy("button[data-test='add-button']");

    public static final Target STORAGE_OPTION = Target.the("Вариант памяти")
            .locatedBy("[data-test='storage-%s']");

    public static final Target QUANTITY_PLUS = Target.the("Увеличить количество")
            .locatedBy("[data-test='quantity-plus']");

    public static final Target QUANTITY_MINUS = Target.the("Уменьшить количество")
            .locatedBy("[data-test='quantity-minus']");

    public static final Target ADD_TO_CART = Target.the("В корзину")
            .locatedBy("[data-test='add-to-cart']");

    public static final Target REMOVE_FROM_CART = Target.the("Удалить из корзины")
            .locatedBy("[data-test='remove-from-cart']");
}
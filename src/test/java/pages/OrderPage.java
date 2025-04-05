package pages;

import core.ui.Target;

public class OrderPage {
    public static final Target FULL_NAME = Target.the("Поле ФИО")
            .locatedBy("[data-test='order-fullname']");

    public static final Target ADDRESS = Target.the("Поле адреса")
            .locatedBy("[data-test='order-address']");

    public static final Target PHONE = Target.the("Поле телефона")
            .locatedBy("[data-test='order-phone']");

    public static final Target EMAIL = Target.the("Поле email")
            .locatedBy("[data-test='order-email']");

    public static final Target COMMENT = Target.the("Комментарий к заказу")
            .locatedBy("[data-test='order-comment']");

    public static final Target COURIER_CHECKBOX = Target.the("Чекбокс курьерской доставки")
            .locatedBy("[data-test='delivery-courier']");

    public static final Target SUBMIT_ORDER = Target.the("Кнопка оформления заказа")
            .locatedBy("[data-test='submit-order']");

    public static final Target ORDER_CONFIRMATION = Target.the("Подтверждение заказа")
            .locatedBy("[data-test='order-confirmation']");
}
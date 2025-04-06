package pages;

import core.ui.Target;

public class OrderPage {
    public static final Target FULL_NAME_INPUT = Target.the("Поле ФИО")
            .locatedBy("#fullName");

    public static final Target ADDRESS_INPUT = Target.the("Поле адреса")
            .locatedBy("#address");

    public static final Target PHONE_INPUT = Target.the("Поле телефона")
            .locatedBy("#phone");

    public static final Target EMAIL_INPUT = Target.the("Поле email")
            .locatedBy("#email");

    public static final Target COMMENTS_TEXTAREA = Target.the("Комментарий")
            .locatedBy("#comments");

    public static final Target COURIER_DELIVERY_CHECKBOX = Target.the("Доставка курьером")
            .locatedBy("#courierDelivery");

    public static final Target SUBMIT_ORDER_BUTTON = Target.the("Кнопка оформления")
            .locatedBy("button.submit-order");
}
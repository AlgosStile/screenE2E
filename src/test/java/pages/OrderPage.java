package pages;

import core.ui.Target;

public class OrderPage {
    public static final Target FULL_NAME_INPUT = Target.the("Поле ФИО")
            .locatedBy("//input[contains(@placeholder, 'имя')]");

    public static final Target ADDRESS_INPUT = Target.the("Поле адреса")
            .locatedBy("//input[@name='address']");

    public static final Target PHONE_INPUT = Target.the("Поле телефона")
            .locatedBy("//input[@type='tel']");

    public static final Target EMAIL_INPUT = Target.the("Поле email")
            .locatedBy("//input[@type='email']");

    public static final Target COMMENTS_TEXTAREA = Target.the("Комментарий")
            .locatedBy("//textarea[@placeholder='Ваши пожелания']");

    public static final Target COURIER_DELIVERY_CHECKBOX = Target.the("Доставка курьером")
            .locatedBy("//label[.//input[@value='500']]");

    public static final Target SUBMIT_ORDER_BUTTON = Target.the("Кнопка оформления")
            .locatedBy("//button[@type='submit']");
}
package pages;

import core.ui.Target;

public class OrderConfirmationPage {
    public static final Target HEADER = Target.the("Заголовок подтверждения")
            .locatedBy("//h1[contains(@class, 'content__title')]");
}
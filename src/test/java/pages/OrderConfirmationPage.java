package pages;

import core.ui.Target;

/**
 * Страница подтверждения заказа, содержащая целевые элементы,
 * с которыми может взаимодействовать актер.
 * Включает заголовок, отображающий информацию о подтверждении заказа.
 */
public class OrderConfirmationPage {
    public static final Target HEADER = Target.the("Заголовок подтверждения")
            .locatedBy("//h1[contains(@class, 'content__title')]");
}
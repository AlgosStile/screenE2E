package tests;

import core.Actor;
import core.abilities.BrowseTheWeb;
import core.interactions.Click;
import core.interactions.Enter;
import core.interactions.Select;
import core.interactions.Wait;
import core.questions.Text;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.*;

import static org.assertj.core.api.Assertions.assertThat;

public class FullE2ETest {
    private Actor actor;

    @BeforeEach
    void setUp() {
        actor = Actor.named("Test User")
                .can(BrowseTheWeb.withBrowser());
    }

    @AfterEach
    void tearDown() {
        actor.usingAbility(BrowseTheWeb.class).close();
    }

    @Test
    void fullPurchaseTest() {
        //$ Фильтрация товаров
        actor.attemptsTo(
                Enter.theText("1000").into(CatalogPage.PRICE_FROM),
                Enter.theText("100000").into(CatalogPage.PRICE_TO),
                Click.on(CatalogPage.CATEGORY_SELECT),
                Select.option(CatalogPage.CATEGORY_SELECT, "Телефоны")
        );

        //$ Выбор цветов
        for (int i = 0; i < 10; i++) {
            actor.attemptsTo(
                    Click.on(CatalogPage.COLOR_OPTION.withArgs(i)),
                    Click.on(CatalogPage.APPLY_FILTER_BUTTON),
                    Wait.forSeconds(2)
            );
        }

        //$ Выбор объема памяти
        String[] storages = {"8", "16", "32", "64", "128", "264"};
        for (String storage : storages) {
            actor.attemptsTo(
                    Click.on(CatalogPage.STORAGE_CHECKBOX.withArgs(storage))
            );
        }
        actor.attemptsTo(Click.on(CatalogPage.APPLY_FILTER_BUTTON));

        //$ Проверка пагинации
        for (int i = 1; i <= 7; i++) {
            actor.attemptsTo(
                    Click.on(CatalogPage.PAGINATION_BUTTON.withArgs(i)),
                    Wait.forSeconds(2)
            );
        }

        //$ Добавление товара
        actor.attemptsTo(
                Click.on(CatalogPage.PRODUCT_ITEM.withText("Квадрокоптер Xiaomi Mi Drone Mini")),
        Click.on(ProductPage.STORAGE_OPTION.withArgs("32")),
                Click.on(ProductPage.QUANTITY_PLUS).repeat(3),
                Click.on(ProductPage.QUANTITY_MINUS),
                Click.on(ProductPage.ADD_TO_CART)
        );

        //$ Оформление заказа
        actor.attemptsTo(
                Click.on(HeaderPage.CART_ICON),
                Click.on(CartPage.PLUS_QUANTITY),
                Click.on(CartPage.MINUS_QUANTITY),
                Click.on(CartPage.CHECKOUT_BUTTON),

                Enter.theValue("Иванов Иван Иванович").into(OrderPage.FULL_NAME),
                Enter.theValue("Москва").into(OrderPage.ADDRESS),
                Enter.theValue("+79508729322").into(OrderPage.PHONE),
                Enter.theValue("test@mail.ru").into(OrderPage.EMAIL),
                Enter.theValue("Доставка до дверей").into(OrderPage.COMMENT),
                Click.on(OrderPage.COURIER_CHECKBOX),
                Click.on(OrderPage.SUBMIT_ORDER)
        );

        //$ Проверка результата
        String confirmation = actor.asks(Text.of(OrderPage.ORDER_CONFIRMATION));
        assertThat(confirmation).contains("Заказ оформлен");
    }
}

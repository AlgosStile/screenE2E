package tests;

import core.Actor;
import core.abilities.BrowseTheWeb;
import core.interactions.*;
import core.questions.Verify;
import core.questions.VerifyText;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.*;

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
        // Фильтрация товаров -->>
        actor.attemptsTo(
                Clear.field(CatalogPage.PRICE_FROM),
                Enter.theText("1000").into(CatalogPage.PRICE_FROM),
                Enter.theText("100000").into(CatalogPage.PRICE_TO),
                Click.on(CatalogPage.CATEGORY_SELECT),
                Select.option(CatalogPage.CATEGORY_SELECT, "Телефоны"),
                Scroll.down(100)

        );

        // Выбор цвета -->>
        actor.attemptsTo(
                Click.on(ColorsPage.PURPLE_COLOR_OPTION),
                Scroll.toWithRetry(CatalogPage.APPLY_FILTER_BUTTON, 1),
                Click.on(CatalogPage.APPLY_FILTER_BUTTON),
                Click.on(ColorsPage.YELLOW_COLOR_OPTION),
                Click.on(CatalogPage.APPLY_FILTER_BUTTON),
                Click.on(ColorsPage.BLACK_COLOR_OPTION),
                Click.on(CatalogPage.APPLY_FILTER_BUTTON),
                Click.on(ColorsPage.GREEN_COLOR_OPTION),
                Click.on(CatalogPage.APPLY_FILTER_BUTTON),
                Click.on(ColorsPage.BLUE_COLOR_OPTION),
                Click.on(CatalogPage.APPLY_FILTER_BUTTON),
                Click.on(ColorsPage.GRAY_COLOR_OPTION),
                Click.on(CatalogPage.APPLY_FILTER_BUTTON),
                Click.on(ColorsPage.ORANGE_COLOR_OPTION),
                Click.on(CatalogPage.APPLY_FILTER_BUTTON),
                Click.on(ColorsPage.RED_COLOR_OPTION),
                Click.on(CatalogPage.APPLY_FILTER_BUTTON),
                Click.on(ColorsPage.WHITE_COLOR_OPTION),
                Click.on(CatalogPage.APPLY_FILTER_BUTTON),
                Click.on(ColorsPage.BLACK_TWO_COLOR_OPTION),
                Click.on(CatalogPage.APPLY_FILTER_BUTTON)
        );


        // Шаг 17: Сброс фильтров
        actor.attemptsTo(
                Wait.forSeconds(1),
                Click.on(CatalogPage.RESET_FILTERS_BUTTON),
                Wait.forSeconds(4)
        );


        // Шаг 18: Пагинация
        actor.attemptsTo(
                Scroll.to(CatalogPage.PAGINATION_2),
                Click.on(CatalogPage.PAGINATION_2),
                Scroll.to(CatalogPage.PAGINATION_3),
                Click.on(CatalogPage.PAGINATION_3),
                Scroll.to(CatalogPage.PAGINATION_4),
                Click.on(CatalogPage.PAGINATION_4),
                Scroll.to(CatalogPage.PAGINATION_5),
                Click.on(CatalogPage.PAGINATION_5),
                Scroll.to(CatalogPage.PAGINATION_6),
                Click.on(CatalogPage.PAGINATION_6),
                Click.on(CatalogPage.PAGINATION_7),
                Scroll.up(500)
//                new ClickPagination(CatalogPage.PAGINATION)

        );

        // Шаг 19: Выбор товара
        actor.attemptsTo(
                Click.on(CatalogPage.PRODUCT_ITEM.of("Квадрокоптер Xiaomi Mi Drone Mini")),
                WaitForUrl.toBe("https://algosstile.github.io/vue-app/index.html#/product/20")
        );

        // Шаг 20: Выбор объемов в карточке
        actor.attemptsTo(
                Click.on(ProductPage.STORAGE_OPTION_32.of("32gb")),
                Wait.forSeconds(2),
                Click.on(ProductPage.STORAGE_OPTION_64.of("64GB")),
                Wait.forSeconds(2),
                Click.on(ProductPage.STORAGE_OPTION_128.of("128gb"))
        );

        // Шаг 21: Изменение количества
        actor.attemptsTo(
                Repeat.times(3, Click.on(ProductPage.QUANTITY_PLUS)),
                Click.on(ProductPage.QUANTITY_MINUS)
        );

        // Шаг 22: Добавление в корзину
        actor.attemptsTo(
                Click.on(ProductPage.ADD_TO_CART_BUTTON)
        );

        // Шаг 23-24: Переход в корзину
        actor.attemptsTo(
                Scroll.to(HeaderPage.CART_ICON),
                Click.on(HeaderPage.CART_ICON),
                WaitForUrl.toBe("https://algosstile.github.io/vue-app/index.html#/cart")
        );

        // Шаг 25: Изменение количества в корзине
        actor.attemptsTo(
                Click.on(CartPage.QUANTITY_PLUS),
                Wait.forSeconds(1),
                Click.on(CartPage.QUANTITY_MINUS)
        );

        // Шаг 26-27: Оформление заказа
        actor.attemptsTo(
                Click.on(CartPage.CHECKOUT_BUTTON),
                WaitForUrl.toBe("https://algosstile.github.io/vue-app/index.html#/order"),
                Enter.theText("Иванов Иван Иванович").into(OrderPage.FULL_NAME_INPUT),
                Enter.theText("Москва").into(OrderPage.ADDRESS_INPUT),
                Enter.theText("+79508729322").into(OrderPage.PHONE_INPUT),
                Enter.theText("test@mail.ru").into(OrderPage.EMAIL_INPUT),
                Enter.theText("Доставка до дверей").into(OrderPage.COMMENTS_TEXTAREA)
        );

        // Шаг 28: Выбор способа доставки
        actor.attemptsTo(
                Click.on(OrderPage.COURIER_DELIVERY_CHECKBOX)
        );

        // Шаг 29-30: Подтверждение заказа
        actor.attemptsTo(
                Click.on(OrderPage.SUBMIT_ORDER_BUTTON),
                WaitForUrl.toContain("/order/"),
                Verify.that(VerifyText.of(OrderConfirmationPage.HEADER, "Заказ оформлен"))
        );
    }
}


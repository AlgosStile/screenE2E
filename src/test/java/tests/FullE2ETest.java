package tests;

import core.interactions.*;
import core.questions.Verify;
import core.questions.VerifyText;
import helper.BaseTest;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.*;

public class FullE2ETest extends BaseTest {

    @Test
    @DisplayName("Полный цикл покупки")
    void fullPurchaseTest() {
        executeStage("Настройка фильтров товаров", () ->
                actor.attemptsTo(
                        Clear.field(CatalogPage.PRICE_FROM),
                        Enter.theText("1000").into(CatalogPage.PRICE_FROM),
                        Enter.theText("100000").into(CatalogPage.PRICE_TO),
                        Click.on(CatalogPage.CATEGORY_SELECT),
                        Select.option(CatalogPage.CATEGORY_SELECT, "Телефоны"),
                        Scroll.down(100)
                ));

        executeStage("Выбор цветов товара", () ->
                actor.attemptsTo(
                        new SelectColorAndApply(ColorsPage.PURPLE_COLOR_OPTION),
                        new SelectColorAndApply(ColorsPage.YELLOW_COLOR_OPTION),
                        new SelectColorAndApply(ColorsPage.BLACK_COLOR_OPTION),
                        new SelectColorAndApply(ColorsPage.GREEN_COLOR_OPTION),
                        new SelectColorAndApply(ColorsPage.BLUE_COLOR_OPTION),
                        new SelectColorAndApply(ColorsPage.GRAY_COLOR_OPTION),
                        new SelectColorAndApply(ColorsPage.ORANGE_COLOR_OPTION),
                        new SelectColorAndApply(ColorsPage.RED_COLOR_OPTION),
                        new SelectColorAndApply(ColorsPage.WHITE_COLOR_OPTION),
                        new SelectColorAndApply(ColorsPage.BLACK_TWO_COLOR_OPTION)
                ));

        executeStage("Сброс примененных фильтров", () ->
                actor.attemptsTo(
                        new ResetFilters()
                ));

        executeStage("Навигация по страницам каталога", () ->
                actor.attemptsTo(
                        new ClickPagination(PaginationPage.PAGINATION_2),
                        new ClickPagination(PaginationPage.PAGINATION_3),
                        new ClickPagination(PaginationPage.PAGINATION_4),
                        new ClickPagination(PaginationPage.PAGINATION_5),
                        new ClickPagination(PaginationPage.PAGINATION_6),
                        new ClickPagination(PaginationPage.PAGINATION_7),
                        Scroll.up(500)
                ));

        executeStage("Выбор конкретного товара", () ->
                actor.attemptsTo(
                        Click.on(CatalogPage.PRODUCT_ITEM.of("Квадрокоптер Xiaomi Mi Drone Mini")),
                        WaitForUrl.toBe(UrlPage.PRODUCT_URL_20)
                ));

        executeStage("Конфигурация характеристик товара", () ->
                actor.attemptsTo(
                        Click.on(ProductPage.STORAGE_OPTION_32.of("32gb")),
                        Click.on(ProductPage.STORAGE_OPTION_64.of("64GB")),
                        Click.on(ProductPage.STORAGE_OPTION_128.of("128gb"))
                ));

        executeStage("Изменение количества товара", () ->
                actor.attemptsTo(
                        Repeat.times(3, Click.on(ProductPage.QUANTITY_PLUS)),
                        Click.on(ProductPage.QUANTITY_MINUS)
                ));

        executeStage("Добавление товара в корзину", () ->
                actor.attemptsTo(
                        Click.on(ProductPage.ADD_TO_CART_BUTTON)
                ));

        executeStage("Переход в корзину", () ->
                actor.attemptsTo(
                        Scroll.to(HeaderPage.CART_ICON),
                        Click.on(HeaderPage.CART_ICON),
                        WaitForUrl.toBe(UrlPage.CART_URL)
                ));

        executeStage("Редактирование корзины", () ->
                actor.attemptsTo(
                        Wait.forElementToBeVisible(CartPage.QUANTITY_PLUS),
                        Click.on(CartPage.QUANTITY_PLUS),
                        Wait.forElementToBeVisible(CartPage.QUANTITY_MINUS),
                        Click.on(CartPage.QUANTITY_MINUS),
                        Click.on(CartPage.CHECKOUT_BUTTON)
                ));

        executeStage("Заполнение данных для доставки", () ->
                actor.attemptsTo(
                        WaitForUrl.toBe(UrlPage.ORDER_URL),
                        Enter.theText("Иванов Иван Иванович").into(OrderPage.FULL_NAME_INPUT),
                        Enter.theText("Москва").into(OrderPage.ADDRESS_INPUT),
                        Enter.theText("+79508729322").into(OrderPage.PHONE_INPUT),
                        Enter.theText("test@mail.ru").into(OrderPage.EMAIL_INPUT),
                        Enter.theText("Доставка до дверей").into(OrderPage.COMMENTS_TEXTAREA)
                ));

        executeStage("Выбор способа доставки", () ->
                actor.attemptsTo(
                        Scroll.to(OrderPage.COURIER_DELIVERY_CHECKBOX),
                        Click.on(OrderPage.COURIER_DELIVERY_CHECKBOX)
                ));

        executeStage("Подтверждение заказа", () ->
                actor.attemptsTo(
                        Click.on(OrderPage.SUBMIT_ORDER_BUTTON),
                        WaitForUrl.toContain(UrlPage.ORDER_URL),
                        Wait.forElementToBeVisible(OrderConfirmationPage.HEADER),
                        Verify.that(VerifyText.of(OrderConfirmationPage.HEADER, "Заказ оформлен"))
                ));
    }

    private void executeStage(String stageName, Allure.ThrowableRunnableVoid stageActions) {
        Allure.step(stageName, stageActions);
    }
}
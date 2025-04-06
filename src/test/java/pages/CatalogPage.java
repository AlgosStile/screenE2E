package pages;

import core.ui.Target;

public class CatalogPage {
    public static final Target PRICE_FROM = Target.the("Поле 'Цена от'")
            .locatedBy("input[name='min-price']");

    public static final Target PRICE_TO = Target.the("Поле 'Цена до'")
            .locatedBy("input[name='max-price']");

    public static final Target APPLY_FILTER_BUTTON = Target.the("Кнопка применения фильтров")
            .locatedBy("button.filter__submit.button.button--primery");

    public static final Target RESET_FILTERS_BUTTON = Target.the("Кнопка сброса фильтров")
            .locatedBy("button.filter__reset.button.button--second");

    public static final Target CATEGORY_SELECT = Target.the("Выбор категории")
            .locatedBy("select[name='category']");

    public static final Target PAGINATION_1 = Target.the("Пагинация 1")
            .locatedBy("//li[@class='pagination__item']/a[@class='pagination__link' and normalize-space()='1']");

    public static final Target PAGINATION_2 = Target.the("Пагинация 2")
            .locatedBy("//li[@class='pagination__item']/a[@class='pagination__link' and normalize-space()='2']");
    public static final Target PAGINATION_3 = Target.the("Пагинация 3")
            .locatedBy("//li[@class='pagination__item']/a[@class='pagination__link' and normalize-space()='3']");
    public static final Target PAGINATION_4 = Target.the("Пагинация 4")
            .locatedBy("//li[@class='pagination__item']/a[@class='pagination__link' and normalize-space()='4']");
    public static final Target PAGINATION_5 = Target.the("Пагинация 5")
            .locatedBy("//li[@class='pagination__item']/a[@class='pagination__link' and normalize-space()='5']");
    public static final Target PAGINATION_6 = Target.the("Пагинация 6")
            .locatedBy("//li[@class='pagination__item']/a[@class='pagination__link' and normalize-space()='6']");
    public static final Target PAGINATION_7 = Target.the("Пагинация 7")
            .locatedBy("//li[@class='pagination__item']/a[@class='pagination__link' and normalize-space()='7']");
    public static final Target PRODUCT_ITEM = Target.the("Товар")
            .locatedBy("img[alt='Квадрокоптер Xiaomi Mi Drone Mini']");


    public static final Target VOLUME_FILTER_SECTION = Target.the("Секция фильтра по объему")
            .locatedBy("//h3[contains(text(), 'Объем в ГБ')]/ancestor::div[@class='filter-section']");

    public static final Target VOLUME_CHECKBOX = Target.the("Чекбокс объема")
            .locatedBy(".//label[contains(., '%s')]/preceding-sibling::input");

    public static final Target VOLUME_CHECKBOX_LABEL = Target.the("Лейбл чекбокса объема")
            .locatedBy(".//label[contains(., '%s')]");

}


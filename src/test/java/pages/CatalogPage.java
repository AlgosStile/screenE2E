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

    public static final Target PRODUCT_ITEM = Target.the("Товар")
            .locatedBy("img[alt='Квадрокоптер Xiaomi Mi Drone Mini']");



}


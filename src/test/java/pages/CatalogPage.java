package pages;

import core.tasks.AddTodoTask;
import core.ui.Target;

public class CatalogPage {
    public static final Target PRICE_FROM = Target.the("Поле 'Цена от'")
            .locatedBy("input[name='min-price']");

    public static final Target PRICE_TO = Target.the("Поле 'Цена до'")
            .locatedBy("input[name='max-price']");

    public static final Target APPLY_FILTER_BUTTON = Target.the("Кнопка применения фильтров")
            .locatedBy("button.apply-filters");

    public static final Target CATEGORY_SELECT = Target.the("Выбор категории")
            .locatedBy("select[name='category']");

    public static final Target COLOR_OPTION = Target.the("Цвет")
            .locatedBy("[data-test='color-option'] >> nth=%d");

    public static final Target STORAGE_CHECKBOX = Target.the("Объем памяти")
            .locatedBy("[data-test='storage-%s']");
    public static final Target PAGINATION_BUTTON =Target.the("Пагинация")
            .locatedBy("[a.pagination__link.pagination__link--current']");
    public static final Target PRODUCT_ITEM = Target.the("Элемент товара")
            .locatedBy("[data-test='product-item']");
}


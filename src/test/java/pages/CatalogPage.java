package pages;

import core.tasks.AddTodoTask;
import core.ui.Target;

public class CatalogPage {
    public static final Target PRICE_FROM = Target.the("Цена от")
            .locatedBy("[data-test='price-from']");

    public static final Target PRICE_TO = Target.the("Цена до")
            .locatedBy("[data-test='price-to']");

    public static final Target CATEGORY_SELECT = Target.the("Выбор категории")
            .locatedBy("[data-test='category-select']");

    public static final Target COLOR_OPTION = Target.the("Цвет")
            .locatedBy("[data-test='color-option'] >> nth=%d");

    public static final Target STORAGE_CHECKBOX = Target.the("Объем памяти")
            .locatedBy("[data-test='storage-%s']");

    public static final Target APPLY_FILTER_BUTTON = Target.the("Применить фильтры")
            .locatedBy("[data-test='apply-filters']");
    public static final Target PAGINATION_BUTTON =Target.the("Пагинация")
            .locatedBy("[a.pagination__link.pagination__link--current']");
    public static final Target PRODUCT_ITEM = Target.the("Элемент товара")
            .locatedBy("[data-test='product-item']");
}


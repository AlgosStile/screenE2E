package pages;

import core.ui.Target;

/**
 * Страница пагинации, содержащая целевые элементы,
 * представляющие номера страниц для навигации.
 * Включает элементы пагинации для страниц 2, 3, 4, 5, 6 и 7.
 */
public class PaginationPage {
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

}

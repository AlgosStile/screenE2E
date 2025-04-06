package pages;

import core.ui.Target;

public class ColorsPage {

    public static final Target PURPLE_COLOR_OPTION = Target.the("Фиолетовый цвет")
            .locatedBy("//span[contains(@style, 'rgb(146, 0, 224)')]");

    public static final Target YELLOW_COLOR_OPTION = Target.the("Желтый цвет")
            .locatedBy("//span[contains(@style, 'rgb(255, 190, 21)')]");

    public static final Target BLACK_COLOR_OPTION = Target.the("Черный цвет")
            .locatedBy("li.colors__item:nth-child(3)");

    public static final Target GREEN_COLOR_OPTION = Target.the("Зелёный цвет")
            .locatedBy("//span[contains(@style, 'rgb(139, 224, 0)')]");

    public static final Target BLUE_COLOR_OPTION = Target.the("Голубой цвет")
            .locatedBy("li.colors__item:nth-child(5)");

    public static final Target GRAY_COLOR_OPTION = Target.the("Серый цвет")
            .locatedBy("li.colors__item:nth-child(6)");
    public static final Target ORANGE_COLOR_OPTION = Target.the("Оранжевый цвет")
            .locatedBy("li.colors__item:nth-child(7)");
    public static final Target RED_COLOR_OPTION = Target.the("Красный цвет")
            .locatedBy("li.colors__item:nth-child(8)");

    public static final Target WHITE_COLOR_OPTION = Target.the("Красный цвет")
            .locatedBy("li.colors__item:nth-child(9)");
    public static final Target BLACK_TWO_COLOR_OPTION = Target.the("Красный цвет")
            .locatedBy("li.colors__item:nth-child(10)");
}




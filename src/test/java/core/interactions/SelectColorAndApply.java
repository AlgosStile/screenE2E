package core.interactions;

import core.Actor;
import core.ui.Target;
import pages.CatalogPage;

/**
 * Задача для выбора цвета и применения фильтра.
 * Выполняет клик по заданному варианту цвета и затем нажимает кнопку применения фильтра.
 */
public class SelectColorAndApply implements Task {
    private final Target colorOption;

    public SelectColorAndApply(Target colorOption) {
        this.colorOption = colorOption;
    }

    @Override
    public void perform(Actor actor) {
        actor.attemptsTo(
                Click.on(colorOption),
                Click.on(CatalogPage.APPLY_FILTER_BUTTON)
        );
    }
}


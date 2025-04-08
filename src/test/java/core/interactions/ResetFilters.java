package core.interactions;

import core.Actor;
import pages.CatalogPage;

/**
 * Задача для сброса фильтров на странице каталога.
 * Выполняет ожидание видимости кнопки сброса фильтров и затем кликает по ней.
 */
public class ResetFilters implements Task {

    @Override
    public void perform(Actor actor) {
        actor.attemptsTo(
                Wait.forElementToBeVisible(CatalogPage.RESET_FILTERS_BUTTON),
                Click.on(CatalogPage.RESET_FILTERS_BUTTON)
        );
    }
}
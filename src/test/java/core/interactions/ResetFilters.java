package core.interactions;

import core.Actor;
import pages.CatalogPage;

public class ResetFilters implements Task {

    @Override
    public void perform(Actor actor) {
        actor.attemptsTo(
                Wait.forElementToBeVisible(CatalogPage.RESET_FILTERS_BUTTON),
                Click.on(CatalogPage.RESET_FILTERS_BUTTON)
        );
    }
}
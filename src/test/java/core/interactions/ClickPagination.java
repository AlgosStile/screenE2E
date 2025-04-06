package core.interactions;

import com.microsoft.playwright.Locator;
import core.Actor;
import core.abilities.BrowseTheWeb;
import core.ui.Target;
import pages.CatalogPage;

public class ClickPagination implements Task {
    @Override
    public void perform(Actor actor) {
        Locator buttons = actor.usingAbility(BrowseTheWeb.class)
                .getPage()
                .locator(CatalogPage.PAGINATION_1.selector);

        int count = buttons.count();
        for (int i = 0; i < count; i++) {
            if (i > 6) break;
            actor.attemptsTo(
                    Click.on((Target) buttons.nth(i)),
                    Wait.forSeconds(2)
            );
        }
    }
}
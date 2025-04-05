package core.ui;

import com.microsoft.playwright.Locator;
import core.Actor;
import core.abilities.BrowseTheWeb;

public class Target {
    private final String description;
    private final String selector;

    public Target(String description, String selector) {
        this.description = description;
        this.selector = selector;
    }

    public Locator resolveFor(Actor actor) {
        return actor.usingAbility(BrowseTheWeb.class)
                .getPage()
                .locator(selector);
    }
}
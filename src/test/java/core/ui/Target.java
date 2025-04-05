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

    public static TargetBuilder the(String description) {
        return new TargetBuilder(description);
    }

    public Locator resolveFor(Actor actor) {
        return actor.usingAbility(BrowseTheWeb.class)
                .getPage()
                .locator(selector);
    }

    public Target withArgs(Object... args) {
        return new Target(description, String.format(selector, args));
    }

    public Target withText(String text) {
        String newSelector = String.format("%s:has-text('%s')", this.selector, text);
        return new Target(this.description + " с текстом '" + text + "'", newSelector);
    }

    public static class TargetBuilder {
        private final String description;

        private TargetBuilder(String description) {
            this.description = description;
        }

        public Target locatedBy(String selector) {
            return new Target(description, selector);
        }


        public static Target containingText(String text) {
            return new Target("Element containing text: " + text,
                    String.format("//*[contains(normalize-space(), '%s')]", text));
        }
    }
}
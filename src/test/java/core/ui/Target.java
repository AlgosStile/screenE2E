package core.ui;

import com.microsoft.playwright.Locator;
import core.Actor;
import core.abilities.BrowseTheWeb;

/**
 * Представляет целевой элемент на веб-странице, который может быть найден с помощью селектора.
 * Позволяет создавать экземпляры целевых элементов с описанием и селектором,
 * а также разрешать их для актера.
 */
public class Target {
    public final String selector;
    private String description;

    public Target(String description, String selector) {
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
    public Target of(String value) {
        return new Target(
                this.description + " with value " + value,
                String.format(this.selector, value)
        );
    }

    public static class TargetBuilder {
        private final String description;

        private TargetBuilder(String description) {
            this.description = description;
        }

        public Target locatedBy(String selector) {
            return new Target(description, selector);
        }
    }
}
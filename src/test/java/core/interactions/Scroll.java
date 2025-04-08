package core.interactions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import core.Actor;
import core.abilities.BrowseTheWeb;
import core.ui.Target;

/**
 * Задача для прокрутки страницы в заданном направлении или к определенному элементу.
 * Поддерживает прокрутку вверх, вниз, к нижней части страницы и к целевому элементу с возможностью повторной попытки.
 */
public class Scroll implements Task {
    private final ScrollDirection direction;
    private final Integer pixels;
    private Target target;

    private Scroll(ScrollDirection direction, Integer pixels) {
        this.direction = direction;
        this.pixels = pixels;
    }

    private Scroll(Target target) {
        this.target = target;
        this.direction = null;
        this.pixels = null;
    }

    public static Scroll down(int pixels) {
        return new Scroll(ScrollDirection.DOWN, pixels);
    }

    public static Scroll up(int pixels) {
        return new Scroll(ScrollDirection.UP, pixels);
    }

    public static Scroll to(Target target) {
        return new Scroll(target);
    }

    public static Scroll toBottom() {
        return new Scroll(ScrollDirection.BOTTOM, null);
    }

    public static Scroll toWithRetry(Target target, int attempts) {
        return new Scroll(target) {
            @Override
            public void perform(Actor actor) {
                for (int i = 0; i < attempts; i++) {
                    try {
                        super.perform(actor);
                        if (target.resolveFor(actor).isVisible()) break;
                    } catch (Exception e) {
                        if (i == attempts - 1) throw e;
                        Wait.forSeconds(1).perform(actor);
                    }
                }
            }
        };
    }


    @Override
    public void perform(Actor actor) {
        Page page = actor.usingAbility(BrowseTheWeb.class).getPage();

        if (target != null) {
            Locator locator = target.resolveFor(actor);
            locator.scrollIntoViewIfNeeded();
        } else if (direction != null) {
            switch (direction) {
                case DOWN:
                    page.evaluate("window.scrollBy(0, " + pixels + ")");
                    break;
                case UP:
                    page.evaluate("window.scrollBy(0, -" + pixels + ")");
                    break;
                case BOTTOM:
                    page.evaluate("window.scrollTo(0, button.filter__submit.button.button--primery)");
                    break;
            }
        }
        Wait.forSeconds(1).perform(actor);
    }

    private enum ScrollDirection {
        DOWN, UP, BOTTOM
    }
}
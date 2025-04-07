package core.interactions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import core.Actor;
import core.abilities.BrowseTheWeb;
import core.ui.Target;

public class Wait implements Task {
    private final long seconds;

    private Wait(long seconds) {
        this.seconds = seconds;
    }

    public static Task forSeconds(long seconds) {
        return new Wait(seconds);
    }

    @Override
    public void perform(Actor actor) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Wait interrupted", e);
        }
    }

    public static Task forElementToBeVisible(Target target) {
        return new Task() {
            @Override
            public void perform(Actor actor) {
                target.resolveFor(actor)
                        .waitFor(new Locator.WaitForOptions()
                                .setState(WaitForSelectorState.VISIBLE)
                                .setTimeout(10000));
            }
        };
    }


    public static Task forCondition(ExpectedCondition condition, String description) {
        return new Task() {
            @Override
            public void perform(Actor actor) {
                Page page = actor.usingAbility(BrowseTheWeb.class).getPage();
                page.waitForFunction(
                        description,
                        condition.getJsPredicate(),
                        new Page.WaitForFunctionOptions().setTimeout(10000)
                );
            }
        };
    }
}

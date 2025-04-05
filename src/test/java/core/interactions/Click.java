package core.interactions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;
import core.Actor;
import core.ui.Target;

public class Click implements Task {
    private final Target target;

    private Click(Target target) {
        this.target = target;
    }

    public static Click on(Target target) {
        return new Click(target);
    }

    @Override
    public void perform(Actor actor) {
        Locator locator = target.resolveFor(actor);
        locator.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE)
                .setTimeout(5000));
        locator.click();
    }
}
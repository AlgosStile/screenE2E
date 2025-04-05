package core.interactions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;
import core.Actor;
import core.ui.Target;

public class WaitFor implements Task {
    private final Target target;
    private final WaitForSelectorState state;
    private final long timeout;

    private WaitFor(Target target, WaitForSelectorState state, long timeout) {
        this.target = target;
        this.state = state;
        this.timeout = timeout;
    }

    public static WaitFor visibilityOf(Target target) {
        return new WaitFor(target, WaitForSelectorState.VISIBLE, 30_000);
    }

    @Override
    public void perform(Actor actor) {
        target.resolveFor(actor)
                .waitFor(new Locator.WaitForOptions()
                        .setState(state)
                        .setTimeout(timeout));
    }
}
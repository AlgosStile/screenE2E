package core.interactions;

import com.microsoft.playwright.Locator;
import core.Actor;
import core.ui.Target;

public class Select implements Task {
    private final Target target;
    private final String value;

    private Select(Target target, String value) {
        this.target = target;
        this.value = value;
    }

    public static Select option(Target target, String value) {
        return new Select(target, value);
    }

    @Override
    public void perform(Actor actor) {
        Locator locator = target.resolveFor(actor);
        locator.selectOption(value);
    }
}
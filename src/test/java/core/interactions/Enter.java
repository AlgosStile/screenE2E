package core.interactions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;
import core.Actor;
import core.ui.Target;

public class Enter implements Task {
    private final String text;
    private final Target target;

    private Enter(String text, Target target) {
        this.text = text;
        this.target = target;
    }

    public static EnterBuilder theText(String text) {
        return new EnterBuilder(text);
    }


    @Override
    public void perform(Actor actor) {
        Locator locator = target.resolveFor(actor);
        locator.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE)
                .setTimeout(5000));
        locator.fill(text);
    }

    public static class EnterBuilder {
        private final String text;

        public EnterBuilder(String text) {
            this.text = text;
        }

        public Enter into(Target target) {
            return new Enter(text, target);
        }

    }
}
package core.questions;

import core.Actor;
import core.interactions.Task;
import core.ui.Target;

public class VerifyText implements Question<Boolean> {
    private final Target target;
    private final String expectedText;

    private VerifyText(Target target, String expectedText) {
        this.target = target;
        this.expectedText = expectedText;
    }

    public static VerifyText of(Target target, String expectedText) {
        return new VerifyText(target, expectedText);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String actualText = target.resolveFor(actor).textContent().trim();
        return actualText.equals(expectedText);
    }
}
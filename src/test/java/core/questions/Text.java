package core.questions;

import core.Actor;
import core.ui.Target;

public class Text implements Question<String> {
    private final Target target;

    public Text(Target target) {
        this.target = target;
    }

    public static Text of(Target target) {
        return new Text(target);
    }

    @Override
    public String answeredBy(Actor actor) {
        return target.resolveFor(actor).textContent().trim();
    }
}
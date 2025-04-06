package core.questions;

import core.Actor;
import core.interactions.Task;
import core.questions.Question;

public class Verify implements Task {
    private final Question<Boolean> question;

    private Verify(Question<Boolean> question) {
        this.question = question;
    }

    public static Verify that(Question<Boolean> question) {
        return new Verify(question);
    }

    @Override
    public void perform(Actor actor) {
        if (!actor.asks(question)) {
            throw new AssertionError("Verification failed: " + question);
        }
    }
}
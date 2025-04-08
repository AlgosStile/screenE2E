package core.questions;

import core.Actor;
import core.interactions.Task;

/**
 * Задача для выполнения проверки, основанной на вопросе, который возвращает логическое значение.
 * Позволяет актеру подтвердить, что определенное условие выполняется.
 */
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

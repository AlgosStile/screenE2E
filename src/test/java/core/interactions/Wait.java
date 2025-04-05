package core.interactions;

import core.Actor;
import core.interactions.Task;

public class Wait implements Task {
    private final long seconds;

    private Wait(long seconds) {
        this.seconds = seconds;
    }

    public static Wait forSeconds(long seconds) {
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
}
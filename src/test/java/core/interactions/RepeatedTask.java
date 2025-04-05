package core.interactions;

import core.Actor;

public class RepeatedTask implements Task {
    private final Task task;
    private final int times;

    public RepeatedTask(Task task, int times) {
        this.task = task;
        this.times = times;
    }

    @Override
    public void perform(Actor actor) {
        for (int i = 0; i < times; i++) {
            task.perform(actor);
        }
    }
}
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
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Repeat interrupted", e);
            }
        }
    }

    public static RepeatedTaskBuilder times(int times) {
        return new RepeatedTaskBuilder(times);
    }

    public static class RepeatedTaskBuilder {
        private final int times;

        public RepeatedTaskBuilder(int times) {
            this.times = times;
        }

        public RepeatedTask the(Task task) {
            return new RepeatedTask(task, times);
        }
    }
}

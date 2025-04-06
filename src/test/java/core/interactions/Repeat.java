package core.interactions;

public class Repeat {
    public static RepeatedTask times(int times, Task task) {
        return new RepeatedTask(task, times);
    }
}
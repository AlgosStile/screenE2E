package core.interactions;

/**
 * Класс для повторного выполнения задачи заданное количество раз.
 * Позволяет легко организовать многократное выполнение одной и той же задачи в тестах.
 */
public class Repeat {
    public static RepeatedTask times(int times, Task task) {
        return new RepeatedTask(task, times);
    }
}
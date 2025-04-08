package core.interactions;

import core.Actor;

/**
 * Интерфейс для представления задачи, которую может выполнять актер.
 * Каждая задача должна реализовывать метод {@link #perform(Actor)},
 * который определяет, как именно задача будет выполняться.
 */
public interface Task {
    void perform(Actor actor);
}
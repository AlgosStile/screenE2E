package core.questions;

import core.Actor;

/**
 * Интерфейс для представления вопроса, на который актер может ответить.
 * Каждый вопрос должен реализовывать метод {@link #answeredBy(Actor)},
 * который возвращает ответ типа {@code T} в зависимости от состояния актера.
 *
 * @param <T> тип ответа на вопрос
 */
public interface Question<T> {
    T answeredBy(Actor actor);
}
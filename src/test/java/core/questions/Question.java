package core.questions;

import core.Actor;

public interface Question<T> {
    T answeredBy(Actor actor);
}
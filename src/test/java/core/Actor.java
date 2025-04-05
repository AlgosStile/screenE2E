package core;

import core.interactions.Task;
import core.questions.Question;

import java.util.ArrayList;
import java.util.List;

public class Actor {
    private final String name;
    private final List<Object> abilities = new ArrayList<>();

    private Actor(String name) {
        this.name = name;
    }

    public static Actor named(String name) {
        return new Actor(name);
    }

    public Actor can(Object ability) {
        this.abilities.add(ability);
        return this;
    }

    public <T> T usingAbility(Class<T> abilityType) {
        return abilityType.cast(
                abilities.stream()
                        .filter(abilityType::isInstance)
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("Ability not found: " + abilityType))
        );
    }

    public void attemptsTo(Task... tasks) {
        for (Task task : tasks) {
            task.perform(this);
        }
    }

    public <T> T asks(Question<T> question) {
        return question.answeredBy(this);
    }
}
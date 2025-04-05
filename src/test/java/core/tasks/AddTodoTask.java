package core.tasks;

import core.interactions.Click;
import core.interactions.Enter;
import core.interactions.Task;
import core.ui.TodoPage;

public class AddTodoTask implements Task {
    private final String todoText;

    public AddTodoTask(String todoText) {
        this.todoText = todoText;
    }

    public static AddTodoTask withText(String todoText) {
        return new AddTodoTask(todoText);
    }

    @Override
    public void perform(core.Actor actor) {
        actor.attemptsTo(
                Enter.theText(todoText).into(TodoPage.TODO_INPUT),
                Click.on(TodoPage.ADD_BUTTON)
        );
    }
}
package core.interactions;

import core.Actor;
import core.ui.Target;

/**
 * Задача клика по элементам пагинации. Инкапсулирует базовый клик через композитную задачу,
 * упрощая навигацию между страницами в тестовых сценариях.
 */
public class ClickPagination implements Task {
    private final Target paginationButtons;

    public ClickPagination(Target paginationButtons) {
        this.paginationButtons = paginationButtons;
    }

    @Override
    public void perform(Actor actor) {
        actor.attemptsTo(
                Click.on(paginationButtons)
        );
    }
}




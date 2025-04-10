package core.interactions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;
import core.Actor;
import core.ui.Target;

/**
 * Задача выполнения клика по элементу с ожиданием его видимости (5 секунд).
 * Реализует паттерн Screenplay, поддерживает повторение действия через метод repeat().
 */
public class Click implements Task {
    private final Target target;

    private Click(Target target) {
        this.target = target;
    }

    public static Task on(Target target) {
        return new Click(target);
    }

    @Override
    public void perform(Actor actor) {
        Locator locator = target.resolveFor(actor);
        locator.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE)
                .setTimeout(5000));
        locator.click();
    }
    public RepeatedTask repeat(int times) {
        return new RepeatedTask(this, times);
    }
}
package core.interactions;

import com.microsoft.playwright.options.WaitForSelectorState;
import core.Actor;
import core.ui.Target;
import com.microsoft.playwright.Locator;


/**
 * Задача очистки поля ввода с ожиданием его видимости.
 * Выполняет принудительную очистку (включая защищенные поля)
 * и снимает фокус с элемента после выполнения.
 * Реализует паттерн Screenplay через интерфейс Task.
 */
public class Clear implements Task {
    private final Target target;

    private Clear(Target target) {
        this.target = target;
    }

    public static Clear field(Target target) {
        return new Clear(target);
    }

    @Override
    public void perform(Actor actor) {
        Locator locator = target.resolveFor(actor);

        locator.waitFor(
                new Locator.WaitForOptions()
                        .setState(WaitForSelectorState.VISIBLE)
                        .setTimeout(10000)
        );

        locator.clear(new Locator.ClearOptions().setForce(true));
        locator.evaluate("element => element.blur()");
    }
}

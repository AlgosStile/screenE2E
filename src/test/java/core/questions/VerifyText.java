package core.questions;

import core.Actor;
import core.ui.Target;

/**
 * Служит для проверки соответствия текстового содержимого целевого элемента
 * ожидаемому тексту. Возвращает логическое значение, указывающее на результат проверки.
 */
public class VerifyText implements Question<Boolean> {
    private final Target target;
    private final String expectedText;

    private VerifyText(Target target, String expectedText) {
        this.target = target;
        this.expectedText = expectedText;
    }

    public static VerifyText of(Target target, String expectedText) {
        return new VerifyText(target, expectedText);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String actualText = Text.of(target).answeredBy(actor).trim();

        String cleanActual = actualText.replaceAll("№\\s+\\d+", "").trim();
        String expected = expectedText.trim();

        if (!cleanActual.equals(expected)) {
            throw new AssertionError(
                    String.format("Текст не совпадает! Ожидалось: '%s', Получено: '%s' (оригинальный текст: '%s')",
                            expected, cleanActual, actualText)
            );
        }
        return true;
    }
}
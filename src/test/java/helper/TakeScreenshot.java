package helper;

import core.Actor;
import core.abilities.BrowseTheWeb;
import core.interactions.Task;
import io.qameta.allure.Allure;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Задача для создания снимка экрана текущей веб-страницы.
 * Позволяет сохранить изображение в указанном файле и прикрепить его к отчету Allure.
 */
public class TakeScreenshot implements Task {
    private final String fileName;

    private TakeScreenshot(String fileName) {
        this.fileName = fileName;
    }

    public static TakeScreenshot named(String fileName) {
        return new TakeScreenshot(fileName);
    }

    @Override
    public void perform(Actor actor) {
        try {
            BrowseTheWeb browser = actor.usingAbility(BrowseTheWeb.class);
            byte[] screenshot = browser.getPage().screenshot();

            Path dir = Paths.get("target/screenshots");
            if (!Files.exists(dir)) Files.createDirectories(dir);

            Path filePath = dir.resolve(fileName + ".png");
            Files.write(filePath, screenshot);

            Allure.getLifecycle().addAttachment(
                    fileName,
                    "image/png",
                    "png",
                    screenshot
            );
        } catch (Exception e) {
            throw new RuntimeException("Failed to take screenshot", e);
        }
    }
}
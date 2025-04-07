package helper;

import core.Actor;
import core.abilities.BrowseTheWeb;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class BaseTest {
    protected Actor actor;

    @BeforeEach
    void setUp() {
        actor = Actor.named("Test User")
                .can(BrowseTheWeb.withBrowser());
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        if (actor != null) {
            try {
                if (testInfo.getTestMethod().isPresent()
                        && testInfo.getTestMethod().get().getAnnotation(Test.class) != null) {
                    actor.attemptsTo(
                            TakeScreenshot.named(testInfo.getDisplayName() + "_failure")
                    );
                }
            } finally {
                actor.usingAbility(BrowseTheWeb.class).close();
            }
        }
    }
}

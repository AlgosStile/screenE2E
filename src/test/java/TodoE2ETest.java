import core.Actor;
import core.abilities.BrowseTheWeb;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodoE2ETest {
    private Actor actor;

    @BeforeEach
    void setUp() {
        actor = Actor.named("Test User")
                .can(BrowseTheWeb.withBrowser());
    }

    @AfterEach
    void tearDown() {
        actor.usingAbility(BrowseTheWeb.class).close();
    }

    @Test
    void testItemSuccessfully() {

    }
}
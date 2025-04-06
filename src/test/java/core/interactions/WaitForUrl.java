package core.interactions;

import com.microsoft.playwright.Page;
import core.Actor;
import core.abilities.BrowseTheWeb;

public class WaitForUrl implements Task {
    private final String expectedUrl;

    private WaitForUrl(String expectedUrl) {
        this.expectedUrl = expectedUrl;
    }

    public static WaitForUrl toBe(String url) {
        return new WaitForUrl(url);
    }

    public static Task toContain(String s) {
        return new ToContain(s);
    }

    @Override
    public void perform(Actor actor) {
        Page page = actor.usingAbility(BrowseTheWeb.class).getPage();
        page.waitForURL(url -> url.equals(expectedUrl), new Page.WaitForURLOptions().setTimeout(10000));
    }

    public static class ToContain implements Task {
        private final String urlPart;

        public ToContain(String urlPart) {
            this.urlPart = urlPart;
        }

        @Override
        public void perform(Actor actor) {
            Page page = actor.usingAbility(BrowseTheWeb.class).getPage();
            page.waitForURL(url -> url.contains(urlPart),
                    new Page.WaitForURLOptions().setTimeout(10000));
        }
    }
}
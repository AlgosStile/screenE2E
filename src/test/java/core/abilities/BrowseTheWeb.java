package core.abilities;

import com.microsoft.playwright.*;
import pages.UrlPage;

public class BrowseTheWeb {
    private final Playwright playwright;
    private final Browser browser;
    private final Page page;

    public BrowseTheWeb() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(500));

        page = browser.newPage();
        page.navigate(UrlPage.MAIN_URL);
    }

    public static BrowseTheWeb withBrowser() {
        return new BrowseTheWeb();
    }

    public Page getPage() {
        return page;
    }

    public void close() {
        if (page != null) page.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
package ui.web.browser;

import static com.codeborne.selenide.Selenide.open;

/**
 * <h1>Browser class</h1>
 * The Browser class implements logic of controlling a
 * browser for automated tests execution.
 * <p>
 * In future if it will be needed to have additional
 * browsers or have some specific methods for browsers,
 * then such methods should be stored here.
 *
 *
 *
 * @author  Vytenis Vaišvilas
 * @version 1.0-SNAPSHOT
 * @since   2020-02-28
 */

public class Browser {

    /**
     * This method is used to open a Chrome Browser. This is
     * a the simplest form of a class method, just for opening
     * browser without additional browser parameters.
     * @param url This parameter is defining what link should be
     * open when browser opens.
     */

    public static void openChromeBrowser(String url)
    {

        System.setProperty("webdriver.chrome.driver", "chromedriver");
        System.setProperty("selenide.browser", "chrome");

        open(url);
    }
}

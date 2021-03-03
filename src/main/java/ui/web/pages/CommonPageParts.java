package ui.web.pages;

import org.slf4j.Logger;
import ui.web.objects.dynamic.Button;
import ui.web.objects.dynamic.TextField;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

/**
 * <h1>Common Page Parts class</h1>
 * The Common Page Parts class implements logic of controlling a
 * common page parts in barbora website.
 * <p>
 * This class is used as a parent class while extending to other ui
 * web page objects.
 *
 * @author  Vytenis Vaišvilas
 * @version 1.0-SNAPSHOT
 * @since   2020-03-03
 */

public class CommonPageParts {

    protected Logger LOGGER;

    /**
     * This constructor is used to construct CommonPageParts.
     * Constructor is needed for LOGGER to receive a not null value.
     * For constructor following parameters needed:
     * @param LOGGER This is Logger which is used for logging debug level messages.
     */

    public CommonPageParts(Logger LOGGER)
    {
        this.LOGGER = LOGGER;

        onlyNeededCookies = new Button($(byXpath("//div[@id='CybotCookiebotDialogBodyLevelWrapper']//a[contains(text(),'Tik būtini slapukai')]"))
                ,LOGGER,"Only needed cookies");
                allowAllCookies = new Button($(byXpath("//div[@id='CybotCookiebotDialogBodyLevelWrapper']//a[contains(text(),'Leisti visus slapukus')]"))
                        ,LOGGER,"Allow all cookies");
                login = new Button($(byXpath("//span[contains(text(),'Prisijungti')]"))
                        ,LOGGER,"Log in");
                signUp =  new Button($(byXpath("//div[@class='b-header--links--item b-header--links--register']/button[contains(text(),'Registruotis')]"))
                        ,LOGGER,"Sign up");
                searchButton = new Button($(byXpath("//header//button[@aria-label='Paieška']")),
                        LOGGER,"Search");
        searchField = new TextField($(byXpath("//header//input[contains(@class,'form-control b-search--large')]")),
            LOGGER,"Search");
    }

    public Button onlyNeededCookies,
            allowAllCookies,
            login,
            signUp,
            searchButton;

    public TextField searchField;

    /**
     * This method is used to search for a items.
     * @param itemToSearchFor This is String value of item which should be searched.
     */
    public void searchForItem(String itemToSearchFor)
    {
        searchField.fillTextField(itemToSearchFor);

        searchButton.clickButton();
    }
}

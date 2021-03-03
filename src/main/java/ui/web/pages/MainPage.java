package ui.web.pages;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.LoggerFactory;
import ui.web.objects.dynamic.Button;
import ui.web.objects.dynamic.Selector;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;

/**
 * <h1>Main Page class</h1>
 * The Main Page class implements logic of controlling a
 * main page web objects in barbora website.
 * <p>
 * This class extends CommonPageParts class
 *
 * @author  Vytenis Vaišvilas
 * @version 1.0-SNAPSHOT
 * @since   2020-03-03
 */

public class MainPage extends CommonPageParts{

    /**
     * This constructor is used to construct MainPage without params.
     */

    public MainPage()
    {
        super(LoggerFactory.getLogger(MainPage.class));
    }

   public Selector itemsSort = new Selector($(byTagName("select")),LOGGER,"Items Sort");


    /**
     * This method is used for choosing item.
     * @param selenideElement This SelenideElement which will be chosen.
     * @param itemName This is String which will be used as name of item.
     */
    public void chooseItem(SelenideElement selenideElement, String itemName)
    {
        Button button = new Button(selenideElement,LOGGER,itemName);
        button.clickButton();
        LOGGER.info("Successfully chosen item \"{}\"",itemName);
    }

}

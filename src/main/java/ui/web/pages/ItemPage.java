package ui.web.pages;

import com.codeborne.selenide.Condition;
import org.slf4j.LoggerFactory;
import ui.web.objects.dynamic.Button;
import ui.web.objects.inactive.Paragraph;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


/**
 * <h1>Item Page class</h1>
 * The Item Page class implements logic of controlling a
 * item page web objects in barbora website.
 * <p>
 * This class extends CommonPageParts class
 *
 * @author  Vytenis Vaišvilas
 * @version 1.0-SNAPSHOT
 * @since   2020-03-03
 */
public class ItemPage extends CommonPageParts{

    /**
     * This constructor is used to construct ItemPage without params.
     */
    public ItemPage()
    {
        super(LoggerFactory.getLogger(ItemPage.class));
    }

    public Button toBasket = new Button($(byXpath("//div[@class='b-product-info--price-and-quantity']//button[@aria-label='Į krepšelį']")),
            LOGGER,"To basket"),
            addMoreItem = new Button($(byXpath("//div[@class='b-product-info--price-and-quantity']//button[@aria-label='Didinti kiekį']")),
            LOGGER, "Add One More Item"),
            takeOutItem = new Button($(byXpath("//div[@class='b-product-info--price-and-quantity']//button[@aria-label='Mažinti kiekį']")),
                    LOGGER, "Take out Item");

    public Paragraph itemCount = new Paragraph($(byXpath("//div[@class='b-product-info--price-and-quantity']//input")),LOGGER,"Item Count");

    public void takeOutAllItemsIfItWereAdded()
    {
            while (toBasket.getSelenideElement().is(Condition.not(Condition.visible)))
            {
                takeOutItem.clickButton();
            }
    }

    /**
     * This method is used add items to a basket
     * @param numberOfItems This is int which defines how many items needs to add.
     */
    public void addItems(int numberOfItems)
    {
        takeOutAllItemsIfItWereAdded();

        toBasket.clickButton();
        for (int i = 1; i < numberOfItems; i++)
            addMoreItem.clickButton();

        LOGGER.info("Successfully added {} items",numberOfItems);
    }
}

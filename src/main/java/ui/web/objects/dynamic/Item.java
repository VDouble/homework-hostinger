package ui.web.objects.dynamic;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.web.objects.inactive.Paragraph;

import static com.codeborne.selenide.Selectors.byXpath;

/**
 * <h1>Item class</h1>
 * Item class implements logic of controlling a
 * items in barbora website.
 * <p>
 *
 * @author  Vytenis Vaišvilas
 * @version 1.0-SNAPSHOT
 * @since   2020-03-03
 */
public class Item {

    private Logger LOGGER;

    public Button toBasket, addMoreItem, takeOutItem;

    public Paragraph itemCount;

    private String itemName;

    /**
     * This constructor is used to construct Item.
     * For constructor following parameters needed:
     * @param locator This is SelenideElement which is used for interacting with browser.
     * @param itemName This is String which is used for storing name of Item. (For example: Pizza, Milk)
     */
    public Item(SelenideElement locator, String itemName)
    {
        LOGGER = LoggerFactory.getLogger(Item.class);

        toBasket = new Button(locator.find(byXpath(".//button[@aria-label='Į krepšelį']")),LOGGER,"To basket");
        addMoreItem = new Button(locator.find(byXpath(".//button[@aria-label='Didinti kiekį']")),LOGGER, "Add One More Item");
        takeOutItem = new Button(locator.find(byXpath(".//button[@aria-label='Mažinti kiekį']")), LOGGER, "Take out Item");

        itemCount = new Paragraph(locator.find(byXpath(".//input")),LOGGER, "Item Count");

        this.itemName = itemName;
    }

    /**
     * This method is used to takeout all items if items were added
     */
    public void takeOutAllItemsIfItsSomethingAdded()
    {
        boolean isThereSomethingToTakeOut = false;
        while (toBasket.getSelenideElement().is(Condition.not(Condition.visible)))
        {
            isThereSomethingToTakeOut = true;
            takeOutItem.clickButton();
        }

        if (isThereSomethingToTakeOut)
            LOGGER.info("Successfully take out all item \"{}\" of basket",itemName);
    }
    /**
     * This method is used to add one item
     */
    public void addItem()
    {
        if (toBasket.getSelenideElement().is(Condition.visible))
            toBasket.clickButton();
        else addMoreItem.clickButton();

        LOGGER.info("Successfully added item \"{}\" to basket",itemName);
    }
    /**
     * This method is used to takeout item
     */
    public void takeOutItem()
    {
        takeOutItem.clickButton();
        LOGGER.info("Successfully take out item \"{}\" of basket",itemName);
    }

    /**
     * This method is used add items to a basket
     * @param numberOfItems This is int which defines how many items needs to add.
     */
    public void addItems(int numberOfItems)
    {
        int iterator = 0;

        if (toBasket.getSelenideElement().is(Condition.visible)) {
            toBasket.clickButton();
            iterator++;
        }
        for (int i = iterator; i < numberOfItems; i++)
            addMoreItem.clickButton();

        LOGGER.info("Successfully added {} of item \"{}\"",numberOfItems,itemName);
    }

    /**
     * This method is used takeout items from basket
     * @param numberOfItems This is int which defines how many items needs to takeout.
     */
    public void takeOutItems(int numberOfItems)
    {

        for (int i = 0; i < numberOfItems; i++)
            takeOutItem.clickButton();

        LOGGER.info("Successfully took out {} of item \"{}\"",numberOfItems,itemName);
    }

    /**
     * This method is used to get items count
     * @return int of item count in basket.
     */

    public int getItemCount()
    {
        if (toBasket.getSelenideElement().is(Condition.visible))
            return 0;
        else return Integer.parseInt(itemCount.getValue());
    }

}

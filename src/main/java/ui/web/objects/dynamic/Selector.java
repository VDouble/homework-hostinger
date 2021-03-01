package ui.web.objects.dynamic;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import configurations.TestsProps;
import org.slf4j.Logger;
import java.time.Duration;

/**
 * <h1>Selector</h1>
 * Selectors class implements logic of controlling a
 * selector in web ui.
 * <p>
 * This class was extends UiWebDynamicObject
 *
 * @author  Vytenis Vaišvilas
 * @version 1.0-SNAPSHOT
 * @since   2020-03-01
 */

public class Selector extends UiWebDynamicObject {

    /**
     * This constructor is used to construct Selector.
     * For constructor following parameters needed:
     * @param locator This is SelenideElement which is used for interacting with browser.
     * @param LOGGER This is Logger which is used for logging debug level messages.
     * @param selectorName This is String which is used for storing name of Selector. (For example: Sort)
     */

    public Selector(SelenideElement locator, Logger LOGGER, String selectorName)
    {
        super(locator,LOGGER,"Selector", selectorName);
    }

    /**
     * This method is used to Select option by text
     * @param optionText According this String value option is choose
     */
    public void selectOption(String optionText)
    {
        selectOption(optionText,TestsProps.TIMEOUT);
    }

    /**
     * This method is used to Select option by text
     * @param optionText According this String value option is choose
     * @param timeout This is long value of time in seconds in which test will able select value.
     */
    public void selectOption(String optionText,long timeout)
    {
        locator.shouldBe(Condition.visible, Duration.ofSeconds(timeout))
                .shouldBe(Condition.enabled, Duration.ofSeconds(timeout))
                .selectOption(optionText);
        LOGGER.debug("In less then {} seconds {} \"{}\" is selected option with text \"{}\"",timeout,objectName,elementName,optionText);
    }

    /**
     * This method is used to Select option by integer
     * @param optionNumber According this int value option is choose
     */
    public void selectOption(int optionNumber)
    {
        selectOption(optionNumber,TestsProps.TIMEOUT);
    }


    /**
     * This method is used to Select option by integer
     * @param optionNumber According this int value option is choose
     * @param timeout This is long value of time in seconds in which test will able to select value.
     */
    public void selectOption(int optionNumber,long timeout)
    {
        locator.shouldBe(Condition.visible, Duration.ofSeconds(timeout))
                .shouldBe(Condition.enabled, Duration.ofSeconds(timeout))
                .selectOption(optionNumber);
        LOGGER.debug("In less then {} seconds {} \"{}\" is selected option with text \"{}\"",timeout,objectName,elementName,optionNumber);
    }

    /**
     * This method is used to Select option by value
     * @param optionValue According this String value option is choose
     */
    public void selectOptionByValue(String optionValue)
    {
        selectOption(optionValue,TestsProps.TIMEOUT);
    }


    /**
     * This method is used to Select option by value
     * @param optionValue According this String value option is choose
     * @param timeout This is long value of time in seconds in which test will able to select value.
     */
    public void selectOptionByValue(String optionValue,long timeout)
    {
        locator.shouldBe(Condition.visible, Duration.ofSeconds(timeout))
                .shouldBe(Condition.enabled, Duration.ofSeconds(timeout))
                .selectOptionByValue(optionValue);
        LOGGER.debug("In less then {} seconds {} \"{}\" is selected option with value \"{}\"",timeout,objectName,elementName,optionValue);
    }

}

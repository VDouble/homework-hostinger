package ui.web.objects.dynamic;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import configurations.TestsProps;
import org.slf4j.Logger;

import java.time.Duration;

/**
 * <h1>Button class</h1>
 * Button class implements logic of controlling a
 * buttons in web ui.
 * <p>
 * This class was extends UiWebDynamicObject
 *
 * @author  Vytenis Vaišvilas
 * @version 1.0-SNAPSHOT
 * @since   2020-02-28
 */
public class Button extends UiWebDynamicObject{

    /**
     * This constructor is used to construct Button.
     * For constructor following parameters needed:
     * @param locator This is SelenideElement which is used for interacting with browser.
     * @param LOGGER This is Logger which is used for logging debug level messages.
     * @param buttonName This is String which is used for storing name of Button. (For example: Save, Edit)
     */

    public Button(SelenideElement locator, Logger LOGGER, String buttonName)
    {
        super(locator,LOGGER,"Button", buttonName);
    }

    /**
     * This method is used to click button
     */
    public void clickButton()
    {
        clickButton(TestsProps.TIMEOUT);
    }

    /**
     * This method is used to click button
     * @param timeout This is long value of time in seconds in which test will able to click button.
     */
    public void clickButton(long timeout)
    {
        closeADIfAppear();
        locator.shouldBe(Condition.visible, Duration.ofSeconds(timeout))
                .shouldBe(Condition.enabled, Duration.ofSeconds(timeout))
                .click();
        LOGGER.debug("In less then {} seconds {} \"{}\" is clicked",timeout,objectName,elementName);
    }
}

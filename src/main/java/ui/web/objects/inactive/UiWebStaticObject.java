package ui.web.objects.inactive;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import configurations.TestsProps;
import org.slf4j.Logger;
import java.time.Duration;

/**
 * <h1>UI Web Static Object class</h1>
 * The UI Web Static Object class implements logic of controlling a
 * static web object.
 * <p>
 * This class is used as a parent class while extending to other ui
 * web objects.
 *
 * @author  Vytenis Vaišvilas
 * @version 1.0-SNAPSHOT
 * @since   2020-02-28
 */

public class UiWebStaticObject {

    protected Logger LOGGER;
    protected SelenideElement locator;
    protected String objectName, elementName;

    /**
     * This constructor is used to construct UiWebStaticObject.
     * For constructor following parameters needed:
     * @param locator This is SelenideElement which is used for interacting with browser.
     * @param LOGGER This is Logger which is used for logging debug level messages.
     * @param objectName This is String which is used for storing name of web object. (For example: Button, CheckBox)
     * @param elementName This is String which is used for storing name of object. (For example: Button Save)
     */

    public UiWebStaticObject(SelenideElement locator, Logger LOGGER, String objectName, String elementName) {
        this.LOGGER = LOGGER;
        this.locator = locator;
        this.objectName = objectName;
        this.elementName = elementName;
    }

    /**
     * This method is used for getting Selenide Element.
     * This method can be used if for user in Class some needed method is missing.
     * @return SelenideElement This element was defined in constructor.
     */

    public SelenideElement getSelenideElement()
    {
        return locator;
    }

    /**
     * This method is used to check if element is visible
     */
    public void isVisible()
    {
        locator.is(Condition.visible);
        LOGGER.debug("{} \"{}\" is visible",objectName,elementName);
    }

    /**
     * This method is used to check if element is not visible
     */
    public void isNotVisible()
    {
        locator.is(Condition.not(Condition.visible));
        LOGGER.debug("{} \"{}\" is not visible",objectName,elementName);
    }

    /**
     * This method is used to wait util it's visible.
     * By default it waits until Timeout value expires.
     * Timeout is set in config.properties file.
     */
    public void waitUntilVisible()
    {
        waitUntilVisible(TestsProps.TIMEOUT);
    }

    /**
     * This method is used to wait util it's visible.
     * @param timeout This is long value of time in seconds in which element should be visible.
     */
    public void waitUntilVisible(long timeout)
    {
        locator.shouldBe(Condition.visible, Duration.ofSeconds(timeout));
        LOGGER.debug("In less then {} seconds {} \"{}\" is visible",timeout,objectName,elementName);
    }

    /**
     * This method is used to wait util it's not visible.
     * By default it waits until Timeout value expires.
     * Timeout is set in config.properties file.
     */

    public void waitUntilNotVisible()
    {
        waitUntilNotVisible(TestsProps.TIMEOUT);
    }

    /**
     * This method is used to wait util it's not visible.
     * @param timeout This is long value of time in seconds in which element should be not visible.
     */
    public void waitUntilNotVisible(long timeout)
    {
        locator.shouldBe(Condition.not(Condition.visible), Duration.ofSeconds(timeout));
        LOGGER.debug("In less then {} seconds {} \"{}\" is not visible",timeout,objectName,elementName);
    }


}

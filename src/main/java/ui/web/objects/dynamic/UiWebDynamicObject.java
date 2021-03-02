package ui.web.objects.dynamic;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import configurations.TestsProps;
import org.slf4j.Logger;
import ui.web.objects.inactive.UiWebStaticObject;
import java.time.Duration;

/**
 * <h1>UI Web Dynamic Object class</h1>
 * The UI Web Dynamic Object class implements logic of controlling a
 * dynamic web object.
 * <p>
 * This class is used as a parent class while extending to other ui
 * web objects.
 * This class was extends UiWebStaticObject
 *
 * @author  Vytenis Vaišvilas
 * @version 1.0-SNAPSHOT
 * @since   2020-02-28
 */

public class UiWebDynamicObject extends UiWebStaticObject {


    /**
     * This constructor is used to construct UiWebDynamicObject.
     * For constructor following parameters needed:
     * @param locator This is SelenideElement which is used for interacting with browser.
     * @param LOGGER This is Logger which is used for logging debug level messages.
     * @param objectName This is String which is used for storing name of web object. (For example: Button, CheckBox)
     * @param elementName This is String which is used for storing name of object. (For example: Button Save)
     */

    public UiWebDynamicObject(SelenideElement locator, Logger LOGGER, String objectName, String elementName)
    {
        super(locator,LOGGER,objectName,elementName);
    }

    /**
     * This method is used to check if element is disabled
     */
    public void isDisabled()
    {
        closeADIfAppear();
        locator.shouldBe(Condition.disabled);
        LOGGER.debug("{} \"{}\" is disabled",objectName,elementName);
    }

    /**
     * This method is used to check if element is enabled
     */
    public void isEnabled()
    {
        closeADIfAppear();
        locator.shouldBe(Condition.enabled);
        LOGGER.debug("{} \"{}\" is enabled",objectName,elementName);
    }

    /**
     * This method is used to wait util it's disabled.
     * By default it waits until Timeout value expires.
     * Timeout is set in config.properties file.
     */
    public void waitUntilDisabled()
    {
        waitUntilDisabled(TestsProps.TIMEOUT);
    }

    /**
     * This method is used to wait util it's disabled.
     * @param timeout This is long value of time in seconds in which element should be disabled.
     */
    public void waitUntilDisabled(long timeout)
    {
        closeADIfAppear();
        locator.shouldBe(Condition.disabled, Duration.ofSeconds(timeout));
        LOGGER.debug("In less then {} seconds {} \"{}\" is disabled",timeout,objectName,elementName);
    }

    /**
     * This method is used to wait util it's enabled.
     * By default it waits until Timeout value expires.
     * Timeout is set in config.properties file.
     */

    public void waitUntilEnabled()
    {
        waitUntilNotVisible(TestsProps.TIMEOUT);
    }

    /**
     * This method is used to wait util it's enabled.
     * @param timeout This is long value of time in seconds in which element should be enabled.
     */
    public void waitUntilEnabled(long timeout)
    {
        closeADIfAppear();
        locator.shouldBe(Condition.not(Condition.enabled), Duration.ofSeconds(timeout));
        LOGGER.debug("In less then {} seconds {} \"{}\" is enabled",timeout,objectName,elementName);
    }

}

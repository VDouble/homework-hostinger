package ui.web.objects.dynamic;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import configurations.TestsProps;
import org.slf4j.Logger;
import java.time.Duration;

/**
 * <h1>Text Field</h1>
 * Text Field class implements logic of controlling a
 * text fields in web ui.
 * <p>
 * This class was extends UiWebDynamicObject
 *
 * @author  Vytenis Vaišvilas
 * @version 1.0-SNAPSHOT
 * @since   2020-03-01
 */

public class TextField extends UiWebDynamicObject {

    /**
     * This constructor is used to construct Text Field.
     * For constructor following parameters needed:
     * @param locator This is SelenideElement which is used for interacting with browser.
     * @param LOGGER This is Logger which is used for logging debug level messages.
     * @param textFieldName This is String which is used for storing name of Text Field. (For example: Email, Password)
     */

    public TextField(SelenideElement locator, Logger LOGGER, String textFieldName)
    {
        super(locator,LOGGER,"Text Field", textFieldName);
    }


    /**
     * This method is used to insert text in to Text Field
     * @param text This String value will be filled to Text Field.
     */
    public void fillTextField(String text)
    {
        fillTextField(text,TestsProps.TIMEOUT);
    }

    /**
     * This method is used to insert text in to Text Field
     * @param text This String value will be filled to Text Field.
     * @param timeout This is long value of time in seconds in which test will able to insert text to Text Field.
     */
    public void fillTextField(String text, long timeout)
    {
        locator.shouldBe(Condition.visible, Duration.ofSeconds(timeout))
                .shouldBe(Condition.enabled, Duration.ofSeconds(timeout))
                .setValue(text);
        LOGGER.debug("In less then {} seconds {} \"{}\" filled with value \"{}\"",timeout,objectName,elementName,text);
    }
}

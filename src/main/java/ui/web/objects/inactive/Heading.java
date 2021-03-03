package ui.web.objects.inactive;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;

/**
 * <h1>Heading class</h1>
 * The Heading class implements logic of controlling a
 * Heading web object.
 * <p>
 * This class extends UiWebStaticObject class
 *
 * @author  Vytenis Vaišvilas
 * @version 1.0-SNAPSHOT
 * @since   2020-03-01
 */

public class Heading extends UiWebStaticObject {

    /**
     * This constructor is used to construct Heading.
     * For constructor following parameters needed:
     * @param locator This is SelenideElement which is used for interacting with browser.
     * @param LOGGER This is Logger which is used for logging debug level messages.
     * @param headingName This is String which is used for storing name of object. (For example: Main Heading)
     */

    public Heading(SelenideElement locator, Logger LOGGER, String headingName)
    {
        super(locator, LOGGER, "Heading", headingName);
    }
}

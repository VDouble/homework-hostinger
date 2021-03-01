package ui.web.objects.inactive;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;

/**
 * <h1>Paragraph class</h1>
 * The Paragraph class implements logic of controlling a
 * Paragraph web object.
 * <p>
 * This class extends UiWebStaticObject class
 *
 * @author  Vytenis Vaišvilas
 * @version 1.0-SNAPSHOT
 * @since   2020-03-01
 */

public class Paragraph extends UiWebStaticObject {

    /**
     * This constructor is used to construct UiWebStaticObject.
     * For constructor following parameters needed:
     * @param locator This is SelenideElement which is used for interacting with browser.
     * @param LOGGER This is Logger which is used for logging debug level messages.
     * @param paragraphName This is String which is used for storing name of object. (For example: Main Paragraph)
     */

    public Paragraph(SelenideElement locator, Logger LOGGER, String paragraphName)
    {
        super(locator, LOGGER, "Paragraph", paragraphName);
    }
}

package ui.web.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.web.objects.dynamic.Button;
import ui.web.objects.inactive.Heading;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

/**
 * <h1>Type Of Barbora Selection Page class</h1>
 * Type Of Barbora Selection Page object controls web objects
 * of page where client must choose Barbora type
 * <p>
 * This class contains Logger, Buttons and Heading.
 *
 * @author  Vytenis Vaišvilas
 * @version 1.0-SNAPSHOT
 * @since   2020-03-01
 */

public class TypeOfBarboraSelectionPage {

    private Logger LOGGER = LoggerFactory.getLogger(TypeOfBarboraSelectionPage.class);

    public Button barbora = new Button($(byText("Barbora")),LOGGER,"Barbora"),
            barboraExpress = new Button($(byXpath("//button/span[text()='Barbora express']")),LOGGER,"Barbora Express");

    public Heading followingRegionsHeading =
            new Heading($(byText("Pasirinkite apskritį, kurioje norite apsipirkti:"))
                    ,LOGGER,"Following regions");

    /**
     * This method is used for checking if tests are in Type Of Barbora Selection Page.
     */

    public void checkIfPageIsOpen()
    {
        followingRegionsHeading.isVisible();

        barbora.isVisible();
        barboraExpress.isVisible();

        LOGGER.info("Barbora type selection page is open");
    }
}

package ui.web.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.web.objects.dynamic.Button;
import ui.web.objects.inactive.Heading;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

/**
 * <h1>Region Selection Page class</h1>
 * Region Selection Page object controls web objects
 * of page where client must choose a region.
 * <p>
 * This class contains Logger, Buttons and Heading.
 *
 * @author  Vytenis Vaišvilas
 * @version 1.0-SNAPSHOT
 * @since   2020-03-01
 */

public class RegionSelectionPage {

    private Logger LOGGER = LoggerFactory.getLogger(RegionSelectionPage.class);

    public Button vilniaus = new Button($(byText("Vilniaus")),LOGGER,"Vilniaus"),
    kauno = new Button($(byXpath("//button/span[text()='Kauno']")),LOGGER,"Kauno"),
    klaipedos = new Button($(byText("Klaipėdos")),LOGGER,"Klaipėdos"),
    siauliu = new Button($(byText("Šiaulių")),LOGGER,"Šiaulių"),
    panevezio = new Button($(byText("Panevėžio")),LOGGER,"Panevėžio"),
    alytaus = new Button($(byText("Alytaus")),LOGGER,"Alytaus"),
    marijampoles = new Button($(byText("Marijampolės")),LOGGER,"Marijampolės"),
    utenos = new Button($(byText("Utenos")),LOGGER,"Utenos"),
    telsiu = new Button($(byText("Telšių")),LOGGER,"Telšių"),
    taurages = new Button($(byText("Tauragės")),LOGGER,"Tauragės");

    public Heading followingRegionsHeading =
            new Heading($(byText("Pasirinkite apskritį, kurioje norite apsipirkti:"))
                    ,LOGGER,"Following regions");

    /**
     * This method is used for checking if tests are in Region Selection Page.
     */

    public void checkIfPageIsOpen()
    {
        followingRegionsHeading.waitUntilVisible();

        vilniaus.isVisible();
        kauno.isVisible();
        klaipedos.isVisible();
        siauliu.isVisible();
        panevezio.isVisible();
        alytaus.isVisible();
        marijampoles.isVisible();
        utenos.isVisible();
        telsiu.isVisible();
        taurages.isVisible();

        LOGGER.info("Region Selection Page is open");
    }
}

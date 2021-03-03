import com.codeborne.selenide.Condition;
import configurations.TestsProps;
import org.junit.jupiter.api.*;
import ui.web.browser.Browser;
import ui.web.objects.dynamic.Item;
import ui.web.pages.*;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;


@DisplayName("Cheapest Pizza Tests")
public class CheapestPizzaTests {

    private MainPage mainPage = new MainPage();
    private LoginForm loginForm = new LoginForm();
    private RegionSelectionPage regionSelectionPage = new RegionSelectionPage();
    private TypeOfBarboraSelectionPage typeOfBarboraSelectionPage = new TypeOfBarboraSelectionPage();

    @BeforeAll
    public static void beforeAll()
    {
        Browser.openChromeBrowser(TestsProps.URL);
    }

    @BeforeEach
    public void beforeEach()
    {
        regionSelectionPage.checkIfPageIsOpen();
        regionSelectionPage.kauno.clickButton();

        typeOfBarboraSelectionPage.checkIfPageIsOpen();
        typeOfBarboraSelectionPage.barbora.clickButton();

        if (mainPage.login.getSelenideElement().is(Condition.visible)) {

            mainPage.login.clickButton();

            loginForm.checkIfPageIsOpen();
            loginForm.login(TestsProps.EMAIL, TestsProps.PASSWORD);

            mainPage.allowAllCookies.clickButton();
            mainPage.allowAllCookies.waitUntilNotVisible();
        }
    }


    @Test
    @DisplayName("2 different cheapest pizzas test")
    public void twoCheapestPizzasTest()
    {
        //Arange
        String itemToSearchFor = "pica ",
                sortAccording =  "Kainą (didėj.)";
        Item firstItem = new Item($(byXpath("(//span[contains(text(),'"+itemToSearchFor+"')])[1]/parent::a/parent::div/parent::div")),
                "Cheapest pizza"),
                secondItem = new Item($(byXpath("(//span[contains(text(),'"+itemToSearchFor+"')])[2]/parent::a/parent::div/parent::div"))
                        ,"Second Cheapest pizza");

        //Act
        mainPage.searchForItem(itemToSearchFor);
        mainPage.itemsSort.selectOption(sortAccording);
        firstItem.takeOutAllItemsIfItsSomethingAdded();
        firstItem.addItem();
        int firstItemsAdded = firstItem.getItemCount();

        secondItem.takeOutAllItemsIfItsSomethingAdded();
        secondItem.addItem();
        int secondItemsAdded = firstItem.getItemCount();

        //Assert
        Assertions.assertEquals(1,firstItemsAdded);
        Assertions.assertEquals(1,secondItemsAdded);

        System.out.println("1");
    }

    @Test
    @DisplayName("1 type cheapest but 2 pizzas test")
    public void cheapestPizzaTest()
    {
        //Arange
        String itemToSearchFor = "pica ",
                itemName = "Cheapest pizza",
                sortAccording =  "Kainą (didėj.)";
        Item cheapestItem = new Item($(byXpath("(//span[contains(text(),'"+itemToSearchFor+"')])[1]/parent::a/parent::div/parent::div")),
                itemName);
        int itemsToAdd = 2;

        //Act
        mainPage.searchForItem(itemToSearchFor);
        mainPage.itemsSort.selectOption(sortAccording);
        cheapestItem.takeOutAllItemsIfItsSomethingAdded();
        cheapestItem.addItems(itemsToAdd);
        int itemsAdded = cheapestItem.getItemCount();

        //Assert
        Assertions.assertEquals(itemsToAdd,itemsAdded);
    }

    @AfterEach
    public void afterEach()
    {
        open(TestsProps.URL);
    }

    @AfterAll
    public static void afterAll()
    {
        closeWindow();
    }
}
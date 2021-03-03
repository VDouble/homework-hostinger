# Barbora pizzas test
**Homework for Hostinger**

### Task:
Write an automated test which adds two cheapest pizza's into the basket of [barbora](https://www.barbora.lt)

### What was done:
* Created small framework which easy iterates with browser and logs into console what was done inside test.
* Created 2 tests. One for adding one type of cheapest pizza but 2 units, second for adding 2 different pizzas.
* Tests were made in such way that it would be easy to add more of them or fix them.
* Both tests are not dependent from each other.
* Tests were implemented in AAA (or 3A) tests writing methodology:
```java
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
```

### Project components:
* [Selenide](https://selenide.org) (for iteration with browser)
* [Junit 5](https://junit.org/junit5/)  (for tests execution)
* [Maven](https://maven.apache.org)  (for dependency management)
* [Logback](http://logback.qos.ch)  (for logging what tests does)

### Whats needed to be setup: for the first time:
1. Have a [Chrome](https://www.google.com/chrome/) browser installed.
2. Download [ChromeDriver](https://chromedriver.chromium.org) according your Chrome Browser version.
3. Store Chromedriver in project root folder (near README.md) or change path of chromedriver inside src/main/resource/config.properties file under parameter: CHROMEDRIVER_PATH
4. Under src/main/resource/ directory create new file credentials.properties
5. Inside file credentials.properties add parameter EMAIL with email for barbora website
6. Inside file credentials.properties add parameter PASSWORD with password for barbora website
7. Execute maven command:
```
mvn clean install
```


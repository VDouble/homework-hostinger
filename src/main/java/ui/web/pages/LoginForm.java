package ui.web.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.web.objects.dynamic.Button;
import ui.web.objects.dynamic.TextField;
import ui.web.objects.inactive.Paragraph;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * <h1>Login Form class</h1>
 * Login Form object controls web objects
 * of page where client must enter login credentials.
 * <p>
 * This class contains Logger, Buttons, Paragraph and TextField.
 *
 * @author  Vytenis Vaišvilas
 * @version 1.0-SNAPSHOT
 * @since   2020-03-01
 */

public class LoginForm {

    private Logger LOGGER = LoggerFactory.getLogger(LoginForm.class);

    public Button login = new Button($(byXpath("//button[text()='Prisijungti']")),LOGGER,"Login"),
            signUp = new Button($(byXpath("//a[text()='Registruotis']")),LOGGER,"Sign Up"),
            close = new Button($(byXpath("//div[@class='modal-header']/button[@aria-label = 'Uždaryti']")),LOGGER,"Close"),
            forgotPassword = new Button($(byText("Priminti slaptažodį")),LOGGER,"Forgot Password");

    public TextField email = new TextField($(byId("b-login-email")),LOGGER,"Email"),
            password = new TextField($(byId("b-login-password")),LOGGER,"Password");

    public Paragraph greating = new Paragraph($(byClassName("help-block")),LOGGER,"Greating"),
            capsLock = new Paragraph($(byClassName("b-caps-lock-on")),LOGGER,"Caps Lock on"),
            fieldMustBeFilled = new Paragraph($(byText("Laukas privalo būti užpildytas")),LOGGER, "Field Must Be Filled");

    /**
     * This method is used for checking if tests are in Region Selection Page.
     */
    public void checkIfPageIsOpen()
    {
        greating.isVisible();

        email.isVisible();
        password.isVisible();

        login.isVisible();
        signUp.isVisible();
        close.isVisible();
        forgotPassword.isVisible();

        LOGGER.info("Login form is open");
    }

    /**
     * This method is used for Log In to Barbora system.
     * @param email This is client email which will be entered.
     * @param password This is client password which will be entered.
     */
    public void login(String email, String password)
    {
        this.email.fillTextField(email);
        this.password.fillTextField(password);

        login.clickButton();

        this.email.waitUntilNotVisible();
        this.password.waitUntilNotVisible();
        this.login.waitUntilNotVisible();

        LOGGER.info("Successfully login with user \"{}\"",email);
    }
}

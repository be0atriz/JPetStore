package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.UUID;

public class RegisterPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement userIdField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='repeatedPassword']")
    private WebElement repeatedPasswordField;

    @FindBy(xpath = "//input[@name='account.firstName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@name='account.lastName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@name='account.email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='account.phone']")
    private WebElement phoneField;

    @FindBy(xpath = "//input[@name='account.address1']")
    private WebElement addressField;

    @FindBy(xpath = "//input[@name='account.city']")
    private WebElement cityField;

    @FindBy(xpath = "//input[@name='account.state']")
    private WebElement stateField;

    @FindBy(xpath = "//input[@name='account.zip']")
    private WebElement zipField;

    @FindBy(xpath = "//input[@name='account.country']")
    private WebElement countryField;

    @FindBy(xpath = "//input[@name='newAccount']")
    private WebElement saveAccountButton;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void navigateToRegisterPage() {
        driver.get("https://petstore.octoperf.com/actions/Account.action?newAccountForm=");
    }

    public static String generateRandomUser() {
        return "user_" + UUID.randomUUID().toString().substring(0, 8);
    }

    public void fillRegisterForm() {
        wait.until(ExpectedConditions.elementToBeClickable(userIdField)).clear();
        userIdField.sendKeys(generateRandomUser());

        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).clear();
        passwordField.sendKeys("password123");

        wait.until(ExpectedConditions.elementToBeClickable(repeatedPasswordField)).clear();
        repeatedPasswordField.sendKeys("password123");

        wait.until(ExpectedConditions.elementToBeClickable(firstNameField)).clear();
        firstNameField.sendKeys("Jane");

        wait.until(ExpectedConditions.elementToBeClickable(lastNameField)).clear();
        lastNameField.sendKeys("Doe");

        wait.until(ExpectedConditions.elementToBeClickable(emailField)).clear();
        emailField.sendKeys("jane0doe@gmail.com");

        wait.until(ExpectedConditions.elementToBeClickable(phoneField)).clear();
        phoneField.sendKeys("123456789");

        wait.until(ExpectedConditions.elementToBeClickable(addressField)).clear();
        addressField.sendKeys("Street");

        wait.until(ExpectedConditions.elementToBeClickable(cityField)).clear();
        cityField.sendKeys("City");

        wait.until(ExpectedConditions.elementToBeClickable(stateField)).clear();
        stateField.sendKeys("State");

        wait.until(ExpectedConditions.elementToBeClickable(zipField)).clear();
        zipField.sendKeys("2541-785");

        wait.until(ExpectedConditions.elementToBeClickable(countryField)).clear();
        countryField.sendKeys("Country");
    }

    public void saveAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(saveAccountButton)).click();
    }

    public boolean isRegistrationSuccessful() {
        return driver.getCurrentUrl().contains("https://petstore.octoperf.com/actions/Catalog.action");
    }}
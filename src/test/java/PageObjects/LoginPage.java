
package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement userIdField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='signon']")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPage() {
        driver.get("https://petstore.octoperf.com/actions/Account.action?signonForm=");
    }

    public void login(String username, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(userIdField)).clear();
        userIdField.sendKeys(username);

        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).clear();
        passwordField.sendKeys(password);

        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }

    public boolean isLoginSuccessful() {
        return driver.getCurrentUrl().equals("https://petstore.octoperf.com/actions/Catalog.action");
    }
}
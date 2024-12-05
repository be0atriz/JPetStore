package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private WebDriverWait wait;

    @FindBy(xpath = "//a[@href='/actions/Order.action?newOrderForm=' and @class='Button']")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//input[@name='newOrder' and @type='submit' and @value='Continue']")
    private WebElement submitOrderButton;

    @FindBy(xpath = "//a[@href='/actions/Order.action?newOrder=&confirmed=true' and @class='Button']")
    private WebElement confirmOrderButton;

    @FindBy(xpath = "//ul[@class='messages']")
    private WebElement orderConfirmationMessage;

    public OrderPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void proceedToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton)).click();
    }

    public void submitOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(submitOrderButton)).click();
    }

    public void confirmOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmOrderButton)).click();
    }

    public boolean isOrderConfirmationDisplayed() {
        WebElement confirmationElement = wait.until(ExpectedConditions.visibilityOf(orderConfirmationMessage));
        return confirmationElement.getText().equals("Thank you, your order has been submitted.");
    }
}
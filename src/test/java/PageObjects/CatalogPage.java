package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CatalogPage {
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@name='keyword']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@name='searchProducts' and @type='submit']")
    private WebElement searchButton;

    @FindBy(css = "font[color='BLACK']")
    private WebElement productLink;

    @FindBy(css = ".Button")
    private WebElement addToCartButton;

    public CatalogPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String product) {
        wait.until(ExpectedConditions.elementToBeClickable(searchField)).sendKeys(product);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public void selectProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(productLink)).click();
    }

    public void addProductToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }
}
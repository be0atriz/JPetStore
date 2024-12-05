package jPetStoreBDD.steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import PageObjects.CatalogPage;
import PageObjects.OrderPage;

public class JPetStoreSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private CatalogPage catalogPage;
    private OrderPage orderPage;

    public void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
        // Initialize page objects
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        catalogPage = new CatalogPage(driver);
        orderPage = new OrderPage(driver);
    }

    @Given("I am at the Pet Store Login page")
    public void i_am_at_the_pet_store_login_page() {
        initializeDriver();
        loginPage.navigateToLoginPage();
    }

    @When("I enter a valid username and password")
    public void i_enter_a_valid_username_and_password() {
        loginPage.login("jane0doe", "password123");
    }

    @When("I click on the Login button")
    public void i_click_on_the_login_button() {
        // This is now handled in the login method of LoginPage
    }

    @Then("I should be redirected to the home page")
    public void i_should_be_redirected_to_the_home_page() {
        Assert.assertTrue(loginPage.isLoginSuccessful());
    }

    @Given("I am at the Pet Store Register page")
    public void i_am_at_the_pet_store_register_page() {
        initializeDriver();
        registerPage.navigateToRegisterPage();
    }

    @When("I enter valid user and account")
    public void i_enter_valid_user_and_account() {
        registerPage.fillRegisterForm();
    }

    @When("I click on Save Account")
    public void i_click_on_save_account() {
        registerPage.saveAccount();
    }

    @Then("I should be redirected from Register to the home page")
    public void i_should_be_redirected_from_register_to_home_page() {
        Assert.assertTrue(registerPage.isRegistrationSuccessful());
    }

    @Given("I am able to login using valid credentials")
    public void i_am_able_to_login_using_valid_credentials() {
        initializeDriver();
        loginPage.navigateToLoginPage();
        loginPage.login("meregali", "jiu123");
        Assert.assertTrue(loginPage.isLoginSuccessful());
    }

    @Given("I search a {string} food in the {string} area")
    public void i_search_a_food_in_the_area(String product, String area) {
        catalogPage.searchProduct(product);
    }

    @Given("I add a product to my Cart")
    public void i_add_a_product_to_my_cart() {
        catalogPage.selectProduct();
        catalogPage.addProductToCart();
    }

    @When("I click on Proceed to checkout")
    public void i_click_on_proceed_to_checkout() {
        orderPage.proceedToCheckout();
    }

    @When("I click to submit the order")
    public void i_click_to_submit_the_order() {
        orderPage.submitOrder();
        orderPage.confirmOrder();
    }

    @Then("I should see an order confirmation")
    public void i_should_see_an_order_confirmation() {
        Assert.assertTrue(orderPage.isOrderConfirmationDisplayed());
    }

    @io.cucumber.java.After
    public void fecharBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
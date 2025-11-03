package awesomecucumber;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.WebDriver;

import awesomecucumber.constants.Endpoint;
import awesomecucumber.context.TestContext;
import awesomecucumber.domain.BillingDetails;
import awesomecucumber.domain.Product;
import awesomecucumber.factory.DriverFactory;
import awesomecucumber.pages.CartPage;
import awesomecucumber.pages.CheckoutPage;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartDefinitionTest {
    private final StorePage storePage;
    private final CartPage cartPage;
    private BillingDetails billingDetails;
    private final CheckoutPage checkoutPage;

    public AddToCartDefinitionTest(TestContext context) {
        // Auto-injected by pico
        storePage = new StorePage(context.driver);
        cartPage = new CartPage(context.driver);
        checkoutPage = new CheckoutPage(context.driver);
    }

    @Given("I am on the store Page")
    public void i_am_on_the_store_page() {
        storePage.load(Endpoint.STORE.url);
    }

    @When("I add {product} to the cart")
    public void i_add_to_the_cart(Product product) {
        // StorePage addToCart
        storePage.addToCart(product.getName());

        // Navigate to cart page
        storePage.navigateCartPage();
    }

    @Then("I should see {int} {product} in the cart")
    public void i_should_see_in_the_cart(int quantity, Product product) {

        // Assert quantity
        assertEquals(quantity, cartPage.getProductQuantity());

        // Assert name
        assertEquals(product.getName(), cartPage.getProductName());
    }

    // ============ PLACING an ORDER ===============
    @Given("I'm a guest customer")
    public void iMAGuestCustomer() {
        storePage.load(Endpoint.STORE.url);
    }

    @And("my billing details are")
    // Receiving domain object:
    // TODO: If I wanted to use the same object in other step definition class?
    // STORE IN CONTEXT
    public void myBillingDetailsAre(BillingDetails billingDetails) {
        this.billingDetails = billingDetails;
    }

    @And("I have a product in the cart")
    public void iHaveAProduct() {
        // StorePage addToCart
        storePage.addToCart("Blue Shoes");

        // Navigate to cart page
        storePage.navigateCartPage();
    }

    @And("I'm on the checkout")
    public void iMOnTheCheckout() {
        // Navigate to checkout page
        cartPage.navigateToCheckoutPage();
    }

    @When("I provide billing details")
    public void iProvideBillingDetails() {
        checkoutPage.fillBillingDetails(billingDetails);
    }

    @And("I place an order")
    public void iPlaceAnOrder() {
        checkoutPage.placeOrder();
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        assertEquals("Thank you. Your order has been received.", checkoutPage.getNoticeText());
    }
}

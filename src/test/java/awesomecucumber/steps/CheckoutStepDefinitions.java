package awesomecucumber.steps;

import static org.junit.jupiter.api.Assertions.*;

import awesomecucumber.context.TestContext;
import awesomecucumber.pages.CartPage;
import awesomecucumber.pages.CheckoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutStepDefinitions {
  private final CartPage cartPage;
  private final CheckoutPage checkoutPage;
  private TestContext context;

  public CheckoutStepDefinitions(TestContext context) {
    this.context = context;
    cartPage = new CartPage(context.driver);
    checkoutPage = new CheckoutPage(context.driver);
  }

  @And("I'm on the checkout")
  public void iMOnTheCheckout() {
    // Navigate to checkout page
    cartPage.navigateToCheckoutPage();
  }

  @When("I provide billing details")
  public void iProvideBillingDetails() {
    checkoutPage.fillBillingDetails(context.billingDetails);
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

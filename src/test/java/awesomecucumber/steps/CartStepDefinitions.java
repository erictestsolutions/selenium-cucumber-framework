package awesomecucumber.steps;

import static org.junit.jupiter.api.Assertions.*;

import awesomecucumber.context.TestContext;
import awesomecucumber.domain.Product;
import awesomecucumber.pages.CartPage;
import io.cucumber.java.en.Then;

public class CartStepDefinitions {
  private final CartPage cartPage;

  public CartStepDefinitions(TestContext context) {
    cartPage = new CartPage(context.driver);
  }

  @Then("I should see {int} {product} in the cart")
  public void i_should_see_in_the_cart(int quantity, Product product) {

    // Assert quantity
    assertEquals(quantity, cartPage.getProductQuantity());

    // Assert name
    assertEquals(product.getName(), cartPage.getProductName());
  }

}

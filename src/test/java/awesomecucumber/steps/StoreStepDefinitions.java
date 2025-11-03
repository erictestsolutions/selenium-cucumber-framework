package awesomecucumber.steps;

import awesomecucumber.constants.Endpoint;
import awesomecucumber.context.TestContext;
import awesomecucumber.domain.Product;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StoreStepDefinitions {
  private final StorePage storePage;

  public StoreStepDefinitions(TestContext context) {
    // Auto-injected by pico
    storePage = new StorePage(context.driver);
  }

  @And("I have a product in the cart")
  public void iHaveAProduct() {
    // StorePage addToCart
    storePage.addToCart("Blue Shoes");

    // Navigate to cart page
    storePage.navigateCartPage();
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

}

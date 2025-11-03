package awesomecucumber.steps;

import awesomecucumber.constants.Endpoint;
import awesomecucumber.context.TestContext;
import awesomecucumber.domain.BillingDetails;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CommonStepDefinitions {
  private final StorePage storePage;
  private TestContext context;

  public CommonStepDefinitions(TestContext context) {
    // Auto-injected by pico
    this.context = context;
    storePage = new StorePage(this.context.driver);
  }

  @Given("I'm a guest customer")
  public void iMAGuestCustomer() {
    storePage.load(Endpoint.STORE.url);
  }

  @And("my billing details are")
  public void myBillingDetailsAre(BillingDetails billingDetails) {
    context.billingDetails = billingDetails;
  }

}

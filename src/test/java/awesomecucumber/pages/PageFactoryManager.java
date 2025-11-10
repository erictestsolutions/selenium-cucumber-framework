package awesomecucumber.pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
  private static StorePage storePage;
  private static CartPage cartPage;
  private static CheckoutPage checkoutPage;

  // Locks
  private static final Object lockStore = new Object();
  private static final Object lockCart = new Object();
  private static final Object lockCheckout = new Object();

  public static StorePage getStorePage(WebDriver driver) {
    if (storePage == null) {
      synchronized (lockStore) {
        if (storePage == null) {
          storePage = new StorePage(driver);
        }
      }
    }
    return storePage;
  }

  public static CartPage getCartPage(WebDriver driver) {
    if (cartPage == null) {
      synchronized (lockCart) {
        if (cartPage == null) { // double-checked locking
          cartPage = new CartPage(driver);
        }
      }
    }
    return cartPage;
  }

  public static CheckoutPage getCheckoutPage(WebDriver driver) {
    if (checkoutPage == null) {
      synchronized (lockCheckout) {
        if (checkoutPage == null) {
          checkoutPage = new CheckoutPage(driver);
        }
      }
    }
    return checkoutPage;
  }
}

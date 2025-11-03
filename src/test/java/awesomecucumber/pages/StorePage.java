package awesomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends BasePage {

    // No more driver.findElement, PageFactory from parent will do the folllowing
    // Scans class for all @FindBy annotations
    // Creates proxy objects for each web element (Hence Lazy initialization)
    // Actual element is found only when you actually use the element.
    @FindBy(css = "a[title='View cart']")
    private WebElement viewCartLink;

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(String productName) {
        By addToCartBtn = By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
        // "wait" is available from parent class (BasePage)
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
    }

    public void navigateCartPage() {
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink));
        viewCartLink.click();
    }
}

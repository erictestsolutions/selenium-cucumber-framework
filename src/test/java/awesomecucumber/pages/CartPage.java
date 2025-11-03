package awesomecucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

public class CartPage extends BasePage {
    @FindBy(css = "td[class='product-name']")
    private WebElement productNameFld;

    @FindBy(css = "input[type='number']")
    private WebElement productQuantityFld;

    @FindBy(partialLinkText = "PROCEED TO CHECKOUT")
    private WebElement checkoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return wait.until(ExpectedConditions.visibilityOf(productNameFld)).getText();
    }

    public int getProductQuantity() {
        return Integer
                .parseInt(Objects
                        .requireNonNull(wait
                                .until(ExpectedConditions
                                        .visibilityOf(productQuantityFld))
                                .getAttribute("value")));
    }

    public void navigateToCheckoutPage(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
    }

}

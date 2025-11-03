package awesomecucumber.pages;

import awesomecucumber.domain.BillingDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {

    @FindBy(css = "form[name='checkout']")
    private WebElement form;

    @FindBy(css = ".woocommerce-notice")
    private WebElement noticeText;

    @FindBy(id = "billing_first_name")
    private WebElement firstNameFld;

    @FindBy(id = "billing_last_name")
    private WebElement lastNameFld;

    @FindBy(id = "billing_country")
    private WebElement countrySelect;

    @FindBy(id = "billing_address_1")
    private WebElement addressLine1Fld;

    @FindBy(id = "billing_city")
    private WebElement cityFld;

    @FindBy(id = "billing_state")
    private WebElement stateSelect;

    @FindBy(id = "billing_postcode")
    private WebElement postcodeFld;

    @FindBy(id = "billing_email")
    private WebElement emailFld;


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOf(firstNameFld));
        firstNameFld.clear();
        firstNameFld.sendKeys(firstName);
        return this;
    }

    public CheckoutPage enterLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOf(lastNameFld));
        lastNameFld.clear();
        lastNameFld.sendKeys(lastName);
        return this;
    }

    public CheckoutPage selectCountry(String country) {
        wait.until(ExpectedConditions.elementToBeClickable(countrySelect));
        new Select(countrySelect).selectByVisibleText(country);
        return this;
    }

    public CheckoutPage enterAddressLine1(String addressLine1) {
        wait.until(ExpectedConditions.visibilityOf(addressLine1Fld));
        addressLine1Fld.clear();
        addressLine1Fld.sendKeys(addressLine1);
        return this;
    }

    public CheckoutPage enterCity(String city) {
        wait.until(ExpectedConditions.visibilityOf(cityFld));
        cityFld.clear();
        cityFld.sendKeys(city);
        return this;
    }

    public CheckoutPage selectState(String state) {
        wait.until(ExpectedConditions.elementToBeClickable(stateSelect));
        new Select(stateSelect).selectByVisibleText(state);
        return this;
    }

    public CheckoutPage enterPostcode(String postcode) {
        wait.until(ExpectedConditions.visibilityOf(postcodeFld));
        postcodeFld.clear();
        postcodeFld.sendKeys(postcode);
        return this;
    }

    public CheckoutPage enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailFld));
        emailFld.clear();
        emailFld.sendKeys(email);
        return this;
    }

    // --- Optional: single helper method ---
    public void fillBillingDetails(BillingDetails billingDetails) {
        enterFirstName(billingDetails.getBillingFirstName())
                .enterLastName(billingDetails.getBillingLastName())
                .selectCountry(billingDetails.getBillingCountry())
                .enterAddressLine1(billingDetails.getBillingAddressOne())
                .enterCity(billingDetails.getBillingCity())
                .selectState(billingDetails.getBillingStateName())
                .enterPostcode(billingDetails.getBillingZip())
                .enterEmail(billingDetails.getBillingEmail());
    }

    public void placeOrder() {
        form.submit();
    }

    public String getNoticeText() {
        return wait.until(ExpectedConditions.visibilityOf(noticeText)).getText();
    }
}

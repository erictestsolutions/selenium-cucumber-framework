package awesomecucumber.pages;

import awesomecucumber.utils.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Scans class for all @FindBy annotations
        // Creates proxy objects for each web element (Hence Lazy initialization)
        // Actual element is found only when you actually use the element.
        PageFactory.initElements(driver, this);
    }

    public void load(String endpoint) {
        driver.get(ConfigLoader.getInstance().getBaseUrl() + endpoint);
    }
}

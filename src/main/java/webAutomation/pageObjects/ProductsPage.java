package webAutomation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[contains(text(),'under ₹10K')]/following::span[text()='VIEW ALL'][1]")
    WebElement viewAllButtonForBelow10K;

    public WebElement getViewAllButtonForBelow10K() {
        return viewAllButtonForBelow10K;
    }

}

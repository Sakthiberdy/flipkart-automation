package webAutomation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemViewPage {
    WebDriver driver;

    public ItemViewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//button[text()='ADD TO CART']")
    WebElement addToCartButton;

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

}

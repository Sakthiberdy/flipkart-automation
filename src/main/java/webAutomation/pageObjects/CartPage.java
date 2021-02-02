package webAutomation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy (xpath = "//div[contains(text(),'My Cart')]")
    WebElement myCartText;

    @FindBy (xpath = "//span[text()='Place Order']")
    WebElement placeOrderButton;

    public WebElement getMyCartText() {
        return myCartText;
    }

    public WebElement getItemName(String itemName) {
        return driver.findElement(By.xpath("//a[text()='"+itemName+"']"));
    }

    public WebElement getPlaceOrderButton() {
        return placeOrderButton;
    }

}

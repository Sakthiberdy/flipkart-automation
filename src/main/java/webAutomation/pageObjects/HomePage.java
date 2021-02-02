package webAutomation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//span[text()='Enter Email/Mobile number']/preceding::input[@type='text'][1]")
    WebElement emailorMobileField;

    @FindBy (xpath = "//span[text()='Login']//preceding::button[text()='✕']")
    WebElement closeButton;

    @FindBy (xpath = "//img[@title='Flipkart']")
    WebElement logo;

    @FindBy (xpath = "//span[text()='Cart']")
    WebElement cart;

    public WebElement getEmailorMobileField() {
        return emailorMobileField;
    }

    public String emailorMobileFieldLocator() {
        return "//span[text()='Enter Email/Mobile number']/preceding::input[@type='text'][1]";
    }

    public WebElement getCloseButton() {
        return closeButton;
    }

    public WebElement getLogo() {
        return logo;
    }

    public WebElement getCart() {
        return cart;
    }

    public String newCategoryLocator(String categoryName) {
        return "//div/img[@alt='"+categoryName+"']";
    }

    public WebElement newCategory(String categoryName) {
        return driver.findElement(By.xpath("//div/img[@alt='"+categoryName+"']"));
    }

    public WebElement getMenu(String menuName) {
        return driver.findElement(By.xpath("//span[text()='"+menuName+"']"));
    }

    public WebElement getProduct(String categoryName, String productName) {
        return driver.findElement(By.xpath("//a[@title='"+categoryName+"']/following::a[@title='"+productName+"']"));
    }

}


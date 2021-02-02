package webAutomation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderInfoPage {
    WebDriver driver;

    public OrderInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Enter Email/Mobile number']/preceding::input[@type='text'][1]")
    WebElement emailorMobileField;

    @FindBy(xpath = "//span[text()='Enter Email/Mobile number']/preceding::input[@type='text'][1]/following::span[text()='CONTINUE']")
    WebElement logincontinueButton;

    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordField;

    @FindBy(xpath = "//span[text()='Login']")
    WebElement loginButton;

    @FindBy(xpath = "//div[text()='Add a new address']")
    WebElement addNewAddress;

    @FindBy (name = "name")
    WebElement name;

    @FindBy (name = "phone")
    WebElement phone;

    @FindBy (name = "pincode")
    WebElement pincode;

    @FindBy (name = "addressLine2")
    WebElement locality;

    @FindBy (name = "addressLine1")
    WebElement address;

    @FindBy (xpath = "//button[text()='Save and Deliver Here']")
    WebElement saveAndDeliverHere;

    @FindBy (xpath = "//span[text()='Delivery Address']")
    WebElement deliveryAddressSection;

    @FindBy (xpath = "//span[contains(text(),'Order ')]/following::input[@type='email']")
    WebElement orderConfirmationValue;

    @FindBy (xpath = "//span[contains(text(),'will be sent to')]/following::button[text()='CONTINUE']")
    WebElement purchaseContinueButton;

    @FindBy (xpath = "//div[text()='Net Banking']")
    WebElement netBanking;

    @FindBy (xpath = "//h3[text()='Other Banks']/following::select")
    WebElement otherBanks;

    @FindBy (xpath = "//button[contains(text(),'PAY')]")
    WebElement payButton;


    public WebElement getEmailorMobileField() {
        return emailorMobileField;
    }

    public WebElement getLogincontinueButton() {
        return logincontinueButton;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public String getAddNewAddressLocator() {
        return "//div[text()='Add a new address']";
    }

    public WebElement getAddNewAddress() {
        return addNewAddress;
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getPincode() {
        return pincode;
    }

    public WebElement getLocality() {
        return locality;
    }

    public WebElement getAddress() {
        return address;
    }

    public WebElement getSaveAndDeliverHere() {
        return saveAndDeliverHere;
    }

    public WebElement getDeliveryAddressSection() {
        return deliveryAddressSection;
    }

    public WebElement getOrderConfirmationValue() {
        return orderConfirmationValue;
    }

    public WebElement getPurchaseContinueButton() {
        return purchaseContinueButton;
    }

    public WebElement getNetBanking() {
        return netBanking;
    }

    public WebElement getOtherBanks() {
        return otherBanks;
    }

    public WebElement getPayButton() {
        return payButton;
    }

}



package webAutomation.testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webAutomation.base;
import webAutomation.libraryFiles.ReusableFunctions;
import webAutomation.pageObjects.*;

import java.io.IOException;
import java.util.ArrayList;

public class PurchaseFlow extends base {
    public WebDriver driver;
    public static Logger log = LogManager.getLogger(base.class.getName());


    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");
    }


    @Test
    public void orderFlow() throws IOException, InterruptedException {
        try {
            String url = prop.getProperty("flipkartURL");
            driver.get(url);
            log.info("Navigated to Flipkart Homepage");

            ReusableFunctions rus = new ReusableFunctions();
            HomePage homePage = new HomePage(driver);
            if (rus.verifyElementPresence(driver, homePage.emailorMobileFieldLocator())) {
                homePage.getCloseButton().click();
            }

            if (rus.verifyElementPresence(driver, homePage.newCategoryLocator(prop.getProperty("categoryName")))) {
                homePage.newCategory(prop.getProperty("categoryName")).click();
            }

            Actions actions = new Actions(driver);
            actions.moveToElement(homePage.getMenu(prop.getProperty("menuName"))).perform();
            homePage.getProduct(prop.getProperty("categoryName"), prop.getProperty("productName")).click();

            rus.waitForPageLoads(driver);
            ProductsPage productsPage = new ProductsPage(driver);
            productsPage.getViewAllButtonForBelow10K().click();

            rus.waitForPageLoads(driver);
            SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
            WebDriverWait wait = new WebDriverWait(driver, 3);
            searchResultsPage.getItem(prop.getProperty("itemName")).click();

            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            ItemViewPage itemViewPage = new ItemViewPage(driver);
            itemViewPage.getAddToCartButton().click();

            CartPage cartPage = new CartPage(driver);
            rus.waitForPageLoads(driver);
            wait.until(ExpectedConditions.visibilityOf(cartPage.getMyCartText()));

            driver.close();
            driver.switchTo().window(tabs.get(0));

            wait.until(ExpectedConditions.visibilityOf(homePage.getLogo()));
            homePage.getLogo().click();
            rus.waitForPageLoads(driver);
            wait.until(ExpectedConditions.visibilityOf(homePage.getCart()));
            homePage.getCart().click();

            cartPage.getItemName(prop.getProperty("itemName"));
            cartPage.getPlaceOrderButton().click();

            OrderInfoPage orderInfoPage = new OrderInfoPage(driver);
            orderInfoPage.getEmailorMobileField().sendKeys(prop.getProperty("loginMobileNumber"));
            orderInfoPage.getLogincontinueButton().click();
            orderInfoPage.getPasswordField().sendKeys(prop.getProperty("loginPassword"));
            orderInfoPage.getLoginButton().click();

            wait.until(ExpectedConditions.visibilityOf(orderInfoPage.getDeliveryAddressSection()));

            if (rus.verifyElementPresence(driver, orderInfoPage.getAddNewAddressLocator())) {
                orderInfoPage.getAddNewAddress().click();
            }

            orderInfoPage.getName().sendKeys(prop.getProperty("receiverName"));
            orderInfoPage.getPhone().sendKeys(prop.getProperty("receiverPhone"));
            orderInfoPage.getPincode().sendKeys(prop.getProperty("receiverPinCode"));
            orderInfoPage.getLocality().sendKeys(prop.getProperty("receiverLocality"));
            orderInfoPage.getAddress().sendKeys(prop.getProperty("receiverAddress"));
            orderInfoPage.getSaveAndDeliverHere().click();

            String emailId = orderInfoPage.getOrderConfirmationValue().getAttribute("value");
            if (emailId.isEmpty()) {
                orderInfoPage.getOrderConfirmationValue().sendKeys(prop.getProperty("orderConfEmail"));
            }

            orderInfoPage.getPurchaseContinueButton().click();
            orderInfoPage.getNetBanking().click();
            Select select = new Select(orderInfoPage.getOtherBanks());
            select.selectByVisibleText(prop.getProperty("bankName"));
            orderInfoPage.getPayButton().click();

            rus.waitForPageLoads(driver);
            rus.captureScreenshot("Bank Screen", driver);
        }
        catch (Exception e) {
            e.printStackTrace();
            log.error("Error in method: orderFlow"+e);
            throw e;
        }
    }


    @AfterTest
    public void tearDown() {
        log.info("Closing the driver");
        driver.close();
    }


}

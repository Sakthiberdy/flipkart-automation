package webAutomation.libraryFiles;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webAutomation.base;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

public class ReusableFunctions {
    public static Logger log = LogManager.getLogger(base.class.getName());

    public boolean verifyElementPresence(WebDriver driver, String locator) {
        try {
            List<WebElement> eleList = driver.findElements(By.xpath(locator));
            int count = eleList.size();
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            log.error("Unable to verify element presence: ", e);
            return false;
        }
    }

    public void waitForPageLoads(WebDriver driver) throws InterruptedException {
        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")).equals("complete");
            }
        });
        Thread.sleep(2000);
    }

    public String captureScreenshot(String fileName, WebDriver driver) throws IOException, InterruptedException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"/reports/"+fileName+".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }


}

package ios;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;

public class ScrollAndBackNavigationTest extends base {
    public static void main(String[] args) {
        IOSDriver driver = initialiseDriver();

        driver.findElementByAccessibilityId("Alert Views").click();
        driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Text Entry\"]").click();
        driver.findElementByClassName("XCUIElementTypeOther").sendKeys("hello");
        driver.findElementByAccessibilityId("OK").click();
        driver.navigate().back();

        WebElement element = driver.findElementByAccessibilityId("Switches");
        HashMap params = new HashMap();
        params.put("direction", "up");
        params.put("element", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: swipe", params);
        element.click();
    }
}

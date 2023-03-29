package ios;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class FirstIOSTest extends base {
    public static void main(String[] args) {
        IOSDriver driver = initialiseDriver();

        driver.findElementByAccessibilityId("Alert Views").click();
        driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Text Entry\"]").click();
        driver.findElementByClassName("XCUIElementTypeOther").sendKeys("hello");
        driver.findElementByAccessibilityId("OK").click();
    }
}

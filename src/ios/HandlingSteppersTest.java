package ios;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class HandlingSteppersTest extends base{
    public static void main(String[] args) {
        IOSDriver driver = initialiseDriver();

        WebElement element = driver.findElementByAccessibilityId("Steppers");
        HashMap params = new HashMap();
        params.put("direction", "up");
        driver.executeScript("mobile:swipe", params);
        element.click();

        List<WebElement> increments = driver.findElementsByXPath("//XCUIElementTypeButton[@name=\"Increment\"]");
        increments.get(0).click();
        System.out.println("Default counter set to: " + ((WebElement) driver.findElementsByClassName("XCUIElementTypeStaticText").get(0)).getText());

        increments.get(0).click();
        System.out.println("Default counter set to: " + ((WebElement) driver.findElementsByClassName("XCUIElementTypeStaticText").get(0)).getText());
    }
}

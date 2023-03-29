package ios;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.List;

public class PickerTest extends base {
    public static void main(String[] args) {
        IOSDriver driver = initialiseDriver();

        driver.findElementByAccessibilityId("Picker View").click();
        driver.findElementByAccessibilityId("Red color component value").sendKeys("50");
        WebElement greenElements = driver.findElementByAccessibilityId("Green color component value");

        HashMap<String, Object> params = new HashMap<>();
        params.put("order", "previous");
        params.put("offset", 0.2);
        params.put("element", ((RemoteWebElement) greenElements).getId());
        driver.executeScript("mobile: selectPickerWheelValue", params);

        params.put("order", "next");
        params.put("offset", 0.3);
        params.put("element", ((RemoteWebElement) driver.findElementByAccessibilityId("Blue color component value")).getId());
        driver.executeScript("mobile: selectPickerWheelValue", params);
    }
}

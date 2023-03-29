package android;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import static java.time.Duration.ofSeconds;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class TouchActionsTest extends base {
    public static void main (String[] args){
        try {
            AndroidDriver driver = initialiseDriver();

            TouchAction touchAction = new TouchAction(driver);

            WebElement views = driver.findElementByAndroidUIAutomator("text(\"Views\")");
            touchAction.tap(tapOptions().withElement(element(views))).perform();

            WebElement expandableLists = driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")");
            touchAction.tap(tapOptions().withElement(element(expandableLists))).perform();

            WebElement customAdapter = driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")");
            touchAction.tap(tapOptions().withElement(element(customAdapter))).perform();

            WebElement peopleNames = driver.findElementByAndroidUIAutomator("text(\"People Names\")");
            touchAction.longPress(longPressOptions().withElement(element(peopleNames)).withDuration(ofSeconds(2))).release().perform();

            System.out.println("Is menu displayed? "+driver.findElementByClassName("android.widget.ListView").isDisplayed());

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}

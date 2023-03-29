package android;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class SwipeActionsTest extends base {
    public static void main (String[] args){
        try {
            AndroidDriver driver = initialiseDriver();

            driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
            driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
            driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();

            driver.findElementByXPath("//*[@content-desc='9']").click();

            TouchAction touchAction = new TouchAction(driver);
            WebElement _15 = driver.findElementByXPath("//*[@content-desc='15']");
            WebElement _45 = driver.findElementByXPath("//*[@content-desc='45']");
            touchAction
                    .longPress(longPressOptions().withElement(element(_15)).withDuration(ofSeconds(1)))
                    .moveTo(element(_45))
                    .release()
                    .perform();
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}

package android;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class DragDropActionsTest extends base {
    public static void main (String[] args){
        try {
            AndroidDriver driver = initialiseDriver();

            driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
            driver.findElementByAndroidUIAutomator("text(\"Drag and Drop\")").click();

            TouchAction touchAction = new TouchAction(driver);
            WebElement source = (WebElement) driver.findElementsByClassName("android.view.View").get(0);
            WebElement destination = (WebElement) driver.findElementsByClassName("android.view.View").get(1);
            touchAction
                    .longPress(element(source))
                    .moveTo(element(destination))
                    .release()
                    .perform();
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}

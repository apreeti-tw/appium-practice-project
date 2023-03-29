package android;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class ECommerceToastMessageTest extends base {
    public static void main (String[] args){
        try {
            AndroidDriver driver = initialiseDriver();

            driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))").click();

            WebElement shopButton = driver.findElementById("com.androidsample.generalstore:id/btnLetsShop");
            TouchAction touchAction = new TouchAction(driver);
            touchAction.tap(tapOptions().withElement(element(shopButton))).perform();

            //Print Toast message text
            String toastMessage = driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
            System.out.println(toastMessage);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}

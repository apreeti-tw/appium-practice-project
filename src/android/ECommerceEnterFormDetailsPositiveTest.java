package android;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import org.openqa.selenium.WebElement;


public class ECommerceEnterFormDetailsPositiveTest extends base {
    public static void main (String[] args){
        try {
            AndroidDriver driver = initialiseDriver();

            driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))").click();

            driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Salvo");
            driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();

            WebElement shopButton = driver.findElementById("com.androidsample.generalstore:id/btnLetsShop");
            TouchAction touchAction = new TouchAction(driver);
            touchAction.tap(tapOptions().withElement(element(shopButton))).perform();
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}

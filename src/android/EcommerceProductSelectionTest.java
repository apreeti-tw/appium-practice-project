package android;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class EcommerceProductSelectionTest extends base {
    public static void main (String[] args){
        try {
            AndroidDriver driver = initialiseDriver();
            driver.hideKeyboard();

            driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))").click();

            driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Salvo");
            driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();

            WebElement shopButton = driver.findElementById("com.androidsample.generalstore:id/btnLetsShop");
            TouchAction touchAction = new TouchAction(driver);
            touchAction.tap(tapOptions().withElement(element(shopButton))).perform();

            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"))").click();
            int productCount = driver.findElementsById("com.androidsample.generalstore:id/productName").size();

            for (int i = 0; i < productCount; i++) {
                if (((WebElement) driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i)).getText().equalsIgnoreCase("Jordan 6 Rings")){
                    ((WebElement) driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i)).click();
                    break;
                }
            }

            driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();


        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}

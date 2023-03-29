package android;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class ECommerceCheckoutTest extends base {
    public static void main(String[] args) {
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

            ((WebElement) driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0)).click();
            ((WebElement) driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0)).click();

            driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
            Thread.sleep(2000);

            double totalAmount = 0.0f;
            for (int i = 0; i < driver.findElementsById("com.androidsample.generalstore:id/productPrice").size(); i++) {
                totalAmount+=getAmount((WebElement) driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i));
            }

            double sumAmount = getAmount(driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl"));

           if (sumAmount == totalAmount){
               System.out.println("Test passed");
           }

           //Mobile gestures
           touchAction.tap(tapOptions().withElement(element(driver.findElementByClassName("android.widget.CheckBox")))).perform();
           touchAction.longPress(longPressOptions().withElement(element(driver.findElementById("com.androidsample.generalstore:id/termsButton"))).withDuration(ofSeconds(2))).release().perform();
           touchAction.tap(tapOptions().withElement(element(driver.findElementByXPath("//android.widget.Button[@text=\'CLOSE\']")))).perform();
           touchAction.tap(tapOptions().withElement(element(driver.findElementByClassName("android.widget.Button")))).perform();

           Thread.sleep(5000);
           driver.context("WEBVIEW_com.androidsample.generalstore");
           driver.findElementByName("q").sendKeys("OK Google");
           driver.findElementByName("q").sendKeys(Keys.ENTER);
           driver.pressKey(new KeyEvent(AndroidKey.BACK));
           driver.context("NATIVE_APP");

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

    public static double getAmount(WebElement element){
        return Double.parseDouble(element.getText().substring(1));
    }
}

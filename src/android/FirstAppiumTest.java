package android;

import io.appium.java_client.android.AndroidDriver;

public class  FirstAppiumTest extends base {
    public static void main (String[] args){
        try {
            AndroidDriver driver = initialiseDriver();

            driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
            driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
            driver.findElementById("android:id/checkbox").click();
            driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
            driver.findElementById("android:id/edit").sendKeys("sanpre");
            driver.findElementById("android:id/button1").click();
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}

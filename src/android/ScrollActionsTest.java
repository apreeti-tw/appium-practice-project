package android;

import io.appium.java_client.android.AndroidDriver;

public class ScrollActionsTest extends base {
    public static void main (String[] args){
        try {
            AndroidDriver driver = initialiseDriver();

            driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Progress Bar\"))");
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}

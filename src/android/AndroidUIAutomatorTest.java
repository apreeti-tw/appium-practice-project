package android;

import io.appium.java_client.android.AndroidDriver;

public class AndroidUIAutomatorTest extends base{
    public static void main (String[] args){
        try {
            AndroidDriver driver = initialiseDriver();

            driver.findElementByAndroidUIAutomator("text(\"Views\")").click();

            System.out.println("Number of clickable items in Views: "+driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}

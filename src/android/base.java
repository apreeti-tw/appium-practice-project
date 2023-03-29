package android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class base {
    public static AndroidDriver<AndroidElement> initialiseDriver(){
        AndroidDriver<AndroidElement> driver = null;
        try {
            File filePath = new File("src/android");
            File apkPath = new File(filePath, "APIDemos-debug.apk");

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
            desiredCapabilities.setCapability("appium:platformVersion", "11");
            desiredCapabilities.setCapability("appium:deviceName", "Nexus 6 API 30 2");
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("appium:app", apkPath.getAbsolutePath());
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723"), desiredCapabilities);

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
        return driver;
    }
}

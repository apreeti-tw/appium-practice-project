package ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class base {
    public static IOSDriver initialiseDriver() {
        IOSDriver<IOSElement> driver = null;
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
            desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/apreeti/Desktop/UICatalog.app");

            driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return driver;
    }
}

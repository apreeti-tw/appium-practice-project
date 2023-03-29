package ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class IOSRealDeviceTest {
    public static void main (String[] args) {
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("xcodeOrgId", "iPhone 6");
            desiredCapabilities.setCapability("xcodeSigningId", "iPhone Developer");
            desiredCapabilities.setCapability("udid", "IOS");
            desiredCapabilities.setCapability("updateWDABundleId", "/Users/apreeti/Desktop/UICatalog.app");

            IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

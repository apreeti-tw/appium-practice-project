package ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class SafariBrowserTest {
    @Test
    public void browserTest() {
        try {
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
            dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
            dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);

            driver.get("https://gmail.com");
            driver.findElementById("identifierId").sendKeys("hello");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

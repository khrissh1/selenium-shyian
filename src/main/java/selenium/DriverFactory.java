package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * Created by Khrystyna.Shyian on 31.03.2015.
 */
public class DriverFactory {
    private static final String FIREFOX = "firefox";
    private static final String CHROME = "chrome";

    public static DriverWrapper makeDriver(String driverName) throws Exception {
        WebDriver driver = null;
        if (driverName.equals(FIREFOX)) {
            //driver = new FirefoxDriver();
            driver = new RemoteWebDriver(new URL("http://localhost:9998/wd/hub"), DesiredCapabilities.firefox());

        } else if (driverName.equals(CHROME)) {
            driver = new ChromeDriver();
        } else {
            throw new Exception();
        }
        return new DriverWrapper(driver) ;
    }


}

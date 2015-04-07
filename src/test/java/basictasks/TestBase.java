package basictasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Khrystyna.Shyian on 19.03.2015.
 */
public class TestBase {

    public static WebDriver driver;

    @BeforeTest
    public void beforeTest() throws MalformedURLException {

        //driver = new FirefoxDriver();
        driver = new RemoteWebDriver(new URL("http://localhost:9998/wd/hub"), DesiredCapabilities.firefox());
    }

    @AfterTest
    public void afterTest() {

        driver.close();
        driver.quit();
    }
}

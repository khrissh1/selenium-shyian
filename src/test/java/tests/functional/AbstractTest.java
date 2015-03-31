package tests.functional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import selenium.DriverFactory;
import testlink.TestSteps;
import util.PropertyLoader;

/**
 * Created by Khrystyna.Shyian on 31.03.2015.
 */
public class AbstractTest {

    protected WebDriver driver;
    TestSteps testSteps;

    @BeforeMethod
    public void initEnv() {

        try {
            driver = DriverFactory.makeDriver(PropertyLoader.loadProperty("browser"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        testSteps = new TestSteps(driver);
    }

    @AfterMethod
    public void shutdown() {

        if (driver != null) {
            driver.close();
            driver.quit();

        }
    }
}
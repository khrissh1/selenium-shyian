package tests.functional;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import testlink.TestStep;

/**
 * Created by Khrystyna.Shyian on 20.03.2015.
 */
public class CreateSuiteTest extends TestStep {


    @BeforeSuite
    public void initEnv() {

        driver = new FirefoxDriver();
    }

    @Test
    public void createSuite() {

        Assert.assertTrue(login("admin", "admin"), "Login Failed");
    }

    @AfterSuite
    public void shutdown() {

        if (driver != null) {
            driver.close();
            driver.quit();

        }
    }
}

package tests.functional;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import testlink.TestSteps;

/**
 * Created by Khrystyna.Shyian on 20.03.2015.
 */
public class CreateSuiteTest extends TestSteps {


    @BeforeTest
    public void initEnv() {

        driver = new FirefoxDriver();
    }

    @Test
    public void createSuite() throws InterruptedException {

        Assert.assertTrue(login("admin", "admin"), "Login Failed");
        Assert.assertTrue(createTestSuite(), "Suite creation failed");

    }

    @AfterTest
    public void shutdown() {

        if (driver != null) {
            driver.close();
            driver.quit();

        }
    }
}

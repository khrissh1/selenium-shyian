package tests.functional;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import testlink.TestSteps;

/**
 * Created by Khrystyna.Shyian on 25.03.2015.
 */
public class CreateCaseTest extends TestSteps {

    @BeforeTest
    public void initEnv() {

        driver = new FirefoxDriver();
    }

    @Test
    public void createCase() throws InterruptedException {

        Assert.assertTrue(login("admin", "admin"), "Login Failed");
        Assert.assertTrue(createTestCase(), "Test Case creation failed");

    }

    @AfterTest
    public void shutdown() {

        if (driver != null) {
            driver.close();
            driver.quit();

        }
    }
}

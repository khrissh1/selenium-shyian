package tests.functional;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testlink.TestSteps;

/**
 * Created by Khrystyna.Shyian on 25.03.2015.
 */
public class CreateStepsTest extends TestSteps {

    @BeforeTest
    public void initEnv() {

        driver = new FirefoxDriver();
    }

    @Test
    public void createCase() throws InterruptedException {

        Assert.assertTrue(login("admin", "admin"), "Login Failed");
        Assert.assertTrue(createTestStep(), "Test Step creation failed");

    }

    @AfterTest
    public void shutdown() {

        if (driver != null) {
            driver.close();
            driver.quit();

        }
    }
}

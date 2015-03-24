package tests.functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import testlink.TestStep;

import java.util.List;

/**
 * Created by Khrystyna.Shyian on 20.03.2015.
 */
public class CreateSuiteTest extends TestStep {


    @BeforeSuite
    public void initEnv() {

        driver = new FirefoxDriver();
    }

    @Test
    public void createSuite() throws InterruptedException {

        Assert.assertTrue(login("admin", "admin"), "Login Failed");
        createTestSuite();
        Assert.assertTrue(verifyTestSuite(), "Test Suite Failed To Create");




    }

    @AfterTest(alwaysRun=true)
    public void cleanData() throws InterruptedException {
        deleteTestSuite();

    }

    @AfterSuite
    public void shutdown() {

        if (driver != null) {
            driver.close();
            driver.quit();

        }
    }
}

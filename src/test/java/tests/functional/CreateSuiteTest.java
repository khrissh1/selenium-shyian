package tests.functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import testlink.TestStep;

import java.util.List;

/**
 * Created by Khrystyna.Shyian on 20.03.2015.
 */
public class CreateSuiteTest extends TestStep {


    @BeforeTest
    public void initEnv() {

        driver = new FirefoxDriver();
    }

    @Test
    public void createSuite() throws InterruptedException {

        Assert.assertTrue(login("admin", "admin"), "Login Failed");
        createTestSuite("New Suite 1");
        Assert.assertTrue(verifyTestSuite("New Suite 1"), "Test Suite Failed To Create");




    }

   // @AfterTest(alwaysRun=true)
    public void cleanData() throws InterruptedException {
        deleteTestSuite();

    }

    @AfterTest
    public void shutdown() throws InterruptedException {

        //deleteTestSuite();

       // if (driver != null) {
            System.out.println("TEST");
            driver.close();
            driver.quit();

        //}
    }
}

package tests.functional;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import testlink.TestSteps;
import testlink.models.TestCase;
import testlink.models.TestSuite;

/**
 * Created by Khrystyna.Shyian on 25.03.2015.
 */
public class CreateCaseTest extends TestSteps {

    @BeforeTest
    public void initEnv() {

        driver = new FirefoxDriver();
    }

    @DataProvider
    public Object[][] testCase() {

        TestSuite suite1 = new TestSuite();
        suite1.setName("Suite111");
        suite1.setDetails("Details111");

        TestCase testCase1  = new TestCase();
        testCase1.setName("Case111");
        testCase1.setDetails("Details111");
        testCase1.setPreconditions("Preconditions111");

        TestSuite suite2 = new TestSuite();
        suite2.setName("Suite112");
        suite2.setDetails("Details112");

        TestCase testCase2  = new TestCase();
        testCase2.setName("Case112");
        testCase2.setDetails("Details112");
        testCase2.setPreconditions("Preconditions112");

        return new Object[][]{
                {suite1, testCase1},
                {suite2, testCase2}
        };
    }
    @Test(dataProvider = "testCase")
    public void createCase(TestSuite suite, TestCase testCase) throws InterruptedException {

        Assert.assertTrue(login("admin", "admin"), "Login Failed");
        Assert.assertTrue(createTestCase(suite, testCase), "Test Case creation failed");

    }

    @AfterTest
    public void shutdown() {

        if (driver != null) {
            driver.close();
            driver.quit();

        }
    }
}

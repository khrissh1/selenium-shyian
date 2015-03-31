package tests.functional;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testlink.TestSteps;
import testlink.models.TestCase;
import testlink.models.TestStep;
import testlink.models.TestSuite;

/**
 * Created by Khrystyna.Shyian on 25.03.2015.
 */
public class CreateStepsTest extends TestSteps {

    @BeforeTest
    public void initEnv() {

        driver = new FirefoxDriver();
    }

    @DataProvider
    public Object[][] steps() {

        TestSuite suite1 = new TestSuite();
        suite1.setName("Suite111");
        suite1.setDetails("Details111");

        TestCase testCase1  = new TestCase();
        testCase1.setName("Case111");
        testCase1.setDetails("Details111");
        testCase1.setPreconditions("Preconditions111");

        TestStep steps1  = new TestStep();
        steps1.setStepAction("Action111");
        steps1.setExecutionResult("Results111");
        steps1.setExecution("Manual");

        TestSuite suite2 = new TestSuite();
        suite2.setName("Suite112");
        suite2.setDetails("Details112");

        TestCase testCase2  = new TestCase();
        testCase2.setName("Case112");
        testCase2.setDetails("Details112");
        testCase2.setPreconditions("Preconditions112");

        TestStep steps2  = new TestStep();
        steps2.setStepAction("Action112");
        steps2.setExecutionResult("Results112");
        steps2.setExecution("Manual");


        return new Object[][]{
                {suite1, testCase1, steps1},
                {suite2, testCase2, steps2}
        };
    }

    @Test(dataProvider = "steps")
    public void createSteps(TestSuite suite, TestCase testCase, TestStep steps) throws InterruptedException {

        Assert.assertTrue(login("admin", "admin"), "Login Failed");
        Assert.assertTrue(createTestStep(suite,testCase,steps), "Test Step creation failed");

    }

    @AfterTest
    public void shutdown() {

        if (driver != null) {
            driver.close();
            driver.quit();

        }
    }
}

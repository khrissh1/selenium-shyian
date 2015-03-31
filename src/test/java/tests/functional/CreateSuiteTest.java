package tests.functional;

import org.testng.Assert;
import org.testng.annotations.*;
import testlink.models.TestCase;
import testlink.models.TestStep;
import testlink.models.TestSuite;

/**
 * Created by Khrystyna.Shyian on 20.03.2015.
 */
public class CreateSuiteTest extends AbstractTest {

    @DataProvider
    public Object[][] suite() {

        TestSuite suite1 = new TestSuite();
        suite1.setName("Suite11111");
        suite1.setDetails("Details11111");

        TestSuite suite2 = new TestSuite();
        suite2.setName("Suite11211");
        suite2.setDetails("Details11211");

        return new Object[][]{
                {suite1},
                {suite2}
        };
    }

    @DataProvider
    public Object[][] testCase() {

        TestSuite suite1 = new TestSuite();
        suite1.setName("Suite11111");
        suite1.setDetails("Details11111");

        TestCase testCase1  = new TestCase();
        testCase1.setName("Case111");
        testCase1.setDetails("Details111");
        testCase1.setPreconditions("Preconditions111");

        TestSuite suite2 = new TestSuite();
        suite2.setName("Suite11211");
        suite2.setDetails("Details11211");

        TestCase testCase2  = new TestCase();
        testCase2.setName("Case112");
        testCase2.setDetails("Details112");
        testCase2.setPreconditions("Preconditions112");

        return new Object[][]{
                {suite1, testCase1},
                {suite2, testCase2}
        };
    }

    @DataProvider
    public Object[][] step() {

        TestSuite suite1 = new TestSuite();
        suite1.setName("Suite11111");
        suite1.setDetails("Details11111");

        TestCase testCase1 = new TestCase();
        testCase1.setName("Case111");
        testCase1.setDetails("Details111");
        testCase1.setPreconditions("Preconditions111");

        TestStep steps1 = new TestStep();
        steps1.setStepAction("Action111");
        steps1.setExecutionResult("Results111");
        steps1.setExecution("Manual");

        TestSuite suite2 = new TestSuite();
        suite2.setName("Suite11211");
        suite2.setDetails("Details11211");

        TestCase testCase2 = new TestCase();
        testCase2.setName("Case112");
        testCase2.setDetails("Details112");
        testCase2.setPreconditions("Preconditions112");

        TestStep steps2 = new TestStep();
        steps2.setStepAction("Action112");
        steps2.setExecutionResult("Results112");
        steps2.setExecution("Manual");

        return new Object[][]{
                {suite1, testCase1, steps1},
                {suite2, testCase2, steps2}
        };
    }

    @Test(dataProvider = "suite")
    public void createSuite(TestSuite suite) throws InterruptedException {

        Assert.assertTrue(testSteps.login("admin", "admin"), "Login Failed");
        Assert.assertTrue(testSteps.createTestSuite(suite), "Suite creation failed");
    }

    @Test(dataProvider = "testCase", dependsOnMethods = {"createSuite"})
    public void createCase(TestSuite suite, TestCase testCase) throws InterruptedException {

        Assert.assertTrue(testSteps.login("admin", "admin"), "Login Failed");
        Assert.assertTrue(testSteps.createTestCase(suite, testCase), "Test Case creation failed");
    }

    @Test(dataProvider = "step", dependsOnMethods = {"createCase"})
    public void createSteps(TestSuite suite, TestCase testCase, TestStep steps) throws InterruptedException {

        Assert.assertTrue(testSteps.login("admin", "admin"), "Login Failed");
        Assert.assertTrue(testSteps.createTestStep(suite, testCase, steps), "Test Step creation failed");
    }
}

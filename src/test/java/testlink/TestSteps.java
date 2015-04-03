package testlink;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.DriverWrapper;
import testlink.models.TestCase;
import testlink.models.TestStep;
import testlink.models.TestSuite;
import testlink.pages.HomePage;
import testlink.pages.LoginPage;
import testlink.pages.SpecificationPage;

/**
 * Created by Khrystyna.Shyian on 20.03.2015.
 */
public class TestSteps {

    protected DriverWrapper driver;

    public TestSteps(DriverWrapper driver) {
        this.driver = driver;
    }

    public boolean login(String login, String password) throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();

        return loginPage.login(login, password).isOpened();

    }

    public boolean createTestSuite(TestSuite suite) throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        homePage.selectTestProject(new testlink.models.HomePage());
        SpecificationPage specificationPage = new SpecificationPage(driver);
        specificationPage.open();
        specificationPage.createTestSuite(suite);
        return specificationPage.testSuiteIsCreated(suite);

    }

    public void deleteTestSuite() throws InterruptedException {

        SpecificationPage specificationPage = new SpecificationPage(driver);
        specificationPage.open();
        specificationPage.deleteTestSuite();

    }

    public boolean createTestCase(TestSuite suite, TestCase testCase) throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        homePage.selectTestProject(new testlink.models.HomePage());
        SpecificationPage specificationPage = new SpecificationPage(driver);
        specificationPage.open();
        specificationPage.selectTestSuite(suite);
        specificationPage.createTestCase(testCase);
        return specificationPage.testCaseIsCreated(testCase);
    }

    public boolean createTestStep(TestSuite suite, TestCase testCase, TestStep steps) throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        homePage.selectTestProject(new testlink.models.HomePage());
        SpecificationPage specificationPage = new SpecificationPage(driver);
        specificationPage.open();
        specificationPage.selectTestSuite(suite);
        specificationPage.selectTestCase(testCase);
        specificationPage.createTestStep(steps);
        return specificationPage.testStepIsCreated(steps);

    }

    public boolean uploadFileToTestSuite(TestSuite suite) throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        homePage.selectTestProject(new testlink.models.HomePage());
        SpecificationPage specificationPage = new SpecificationPage(driver);
        specificationPage.open();
        specificationPage.selectTestSuite(suite);
        specificationPage.uploadFileToTestSuite(suite);

        return specificationPage.fileIsUploaded(suite);
    }

}

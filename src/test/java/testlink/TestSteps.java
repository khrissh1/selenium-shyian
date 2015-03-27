package testlink;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    protected WebDriver driver;


    public boolean login(String login, String password) throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();

        return loginPage.login(login,password).isOpened();

    }

    public boolean createTestSuite() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        homePage.selectTestProject();
        SpecificationPage specificationPage = new SpecificationPage(driver);
        specificationPage.open();
        specificationPage.createTestSuite(new TestSuite());
        return specificationPage.testSuiteIsCreated(new TestSuite());

    }

    public void deleteTestSuite() throws InterruptedException {

        SpecificationPage specificationPage = new SpecificationPage(driver);
        specificationPage.open();
        specificationPage.deleteTestSuite();

    }

    public boolean createTestCase() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        homePage.selectTestProject();
        SpecificationPage specificationPage = new SpecificationPage(driver);
        specificationPage.open();
        specificationPage.selectTestSuite(new TestSuite());
        specificationPage.createTestCase(new TestCase());
        return specificationPage.testCaseIsCreated(new TestCase());
    }

    public boolean createTestStep() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        homePage.selectTestProject();
        SpecificationPage specificationPage = new SpecificationPage(driver);
        specificationPage.open();
        specificationPage.selectTestSuite(new TestSuite());
        specificationPage.selectTestCase(new TestCase());
        specificationPage.createTestStep(new TestStep());
        return specificationPage.testStepIsCreated(new TestStep());

    }

}

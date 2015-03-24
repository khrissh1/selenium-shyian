package testlink;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testlink.models.TestSuite;
import testlink.pages.HomePage;
import testlink.pages.LoginPage;

/**
 * Created by Khrystyna.Shyian on 20.03.2015.
 */
public class TestStep {

    protected WebDriver driver;
    private final By headerFrame  = By.name("titlebar");
    private final By workFrame  = By.name("workframe");
    private final By mainFrame  = By.name("mainframe");
    private final By treeframe  = By.name("treeframe");


    public boolean login(String login, String password) {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(login, password);
        switchToHeaderFrame();

        return homePage.isOpen();

    }

    public void createTestSuite() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        homePage.selectTestProject();
        switchToMainFrame();
        homePage.openTestSpecification();

        TestSuite testSuite = new TestSuite(driver);
        switchToWorkFrame();
        testSuite.createTestSuite();

    }

    public void deleteTestSuite() throws InterruptedException {

        TestSuite testSuite = new TestSuite(driver);
        switchToWorkFrame();
        testSuite.deleteTestSuite();

    }
    public boolean verifyTestSuite() {
        TestSuite testSuite = new TestSuite(driver);
        switchToTreeFrame();
        return testSuite.testSuiteIsCreated();
    }




    public void switchToHeaderFrame(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(headerFrame));
    }

    public void switchToMainFrame(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(mainFrame));
    }

    public void switchToWorkFrame(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(mainFrame));
        driver.switchTo().frame(driver.findElement(workFrame));
    }

    public void switchToTreeFrame(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(mainFrame));
        driver.switchTo().frame(driver.findElement(treeframe));
    }


}

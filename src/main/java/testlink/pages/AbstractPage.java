package testlink.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.DriverWrapper;

/**
 * Created by Khrystyna.Shyian on 25.03.2015.
 */
public class AbstractPage {

    protected DriverWrapper driver;

    private static final By headerFrame = By.name("titlebar");
    private static final By mainFrame = By.name("mainframe");
    private static final By treeFrame = By.name("treeframe");
    private static final By workFrame = By.name("workframe");

    public AbstractPage(DriverWrapper driver) {
        this.driver = driver;
    }

    public void switchToHeaderFrame() {

        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(headerFrame));
    }

    public void switchToMainFrame() {

        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(mainFrame));
    }

    public void switchToWorkFrame() {

        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(mainFrame));
        driver.switchTo().frame(driver.findElement(workFrame));
    }

    public void switchToTreeFrame() {

        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(mainFrame));
        driver.switchTo().frame(driver.findElement(treeFrame));
    }

    public void waitUntilElementIsPresent(By element){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));

    }

}

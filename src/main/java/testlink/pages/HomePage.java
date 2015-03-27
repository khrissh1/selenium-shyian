package testlink.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

/**
 * Created by Khrystyna.Shyian on 20.03.2015.
 */
public class HomePage extends AbstractPage {

    private final By version = By.xpath("//div[@class='menu_title']/span[contains(text(),'TestLink')]");
    private final By testProject = By.xpath("//div[@class='menu_bar']/div/form[@name='productForm']/select");

    public HomePage(WebDriver driver) {

        super(driver);
    }

    public boolean isOpened() {

        switchToHeaderFrame();
        waitUntilElementIsPresent(version);
        return driver.findElements(version).size() > 0;
    }

    public void selectTestProject() {

        switchToHeaderFrame();
        Select select = new Select(driver.findElement(testProject));
        select.selectByVisibleText("#.:Test Project 1");
    }
}

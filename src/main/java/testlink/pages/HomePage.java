package testlink.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Khrystyna.Shyian on 20.03.2015.
 */
public class HomePage {
    protected WebDriver driver;
    private final By version = By.xpath("//div[@class='menu_title']/span[contains(text(),'TestLink')]");
    private final By headerFrame  = By.name("titlebar");
    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    public boolean isOpen(){
        driver.switchTo().frame(driver.findElement(headerFrame));
    WebDriverWait  wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(version));
    return driver.findElements(version).size() > 0;
    }
}

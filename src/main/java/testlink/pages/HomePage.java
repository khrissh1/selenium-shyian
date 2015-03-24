package testlink.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

/**
 * Created by Khrystyna.Shyian on 20.03.2015.
 */
public class HomePage {
    protected WebDriver driver;
    private final By version = By.xpath("//div[@class='menu_title']/span[contains(text(),'TestLink')]");
    private final By testProject  = By.xpath("//div[@class='menu_bar']/div/form[@name='productForm']/select");

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    public boolean isOpen(){

    WebDriverWait  wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.presenceOfElementLocated(version));
    return driver.findElements(version).size() > 0;
    }

    public void selectTestProject(){
        Select select = new Select(driver.findElement(testProject));
        select.selectByVisibleText("#.:Test Project 1");
        driver.switchTo().defaultContent();
    }

    public void openTestSpecification() throws InterruptedException {

        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#testspecification_topics>a[href='lib/general/frmWorkArea.php?feature=editTc']")).click();

    }

}

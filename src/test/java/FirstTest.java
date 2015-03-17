import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Khrystyna.Shyian on 13.03.2015.
 */
public class FirstTest {

    public static final By searchField = (By.id("lst-ib"));

    @DataProvider
    public Object[][] keyWords() {
        return new Object[][] {
                new Object[] {"осциллограф", "www.tehencom.com"},
        };
    }

    @Test(dataProvider="keyWords")
    public void firstTest(String keyWord, String url) throws InterruptedException {

        WebDriver driver  = new FirefoxDriver();
        driver.get("https://www.google.com.ua");
        driver.findElement(searchField).clear();
        driver.findElement(searchField).sendKeys(keyWord);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        for (int j=2;j<5;j++) {
            String nextPage = ".//*[@id='nav']/tbody/tr/td[" + j + "]/a/span";
            Thread.sleep(1000);
            driver.findElement(By.xpath(nextPage)).click();

            for (int i = 1; i < 8; i++) {
                //String findLink = ".//*[@id='rso']/div[3]/li[" + i + "]/div[@class=\"rc\"]/div[@class=\"s\"]/div/div[@class=\"f kv _SWb\"]/cite";
                String findLink = ".//*[@id='rso']/div[3]/li[" + i + "]/div/div/div/div[1]/cite";
                Thread.sleep(1000);
                if (driver.findElement(By.xpath(findLink)).getText().contains(url)) {
                    System.out.println("Site found");
                    break;
                }
            }
        }
        driver.quit();
    }
}

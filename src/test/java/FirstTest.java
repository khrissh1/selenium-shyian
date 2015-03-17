import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Khrystyna.Shyian on 13.03.2015.
 */
public class FirstTest {

    public static final By searchField = (By.id("lst-ib"));
    public static boolean urlFound = false;

    public static WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driver = new FirefoxDriver();
    }

    @DataProvider
    public Object[][] keyWords() {
        return new Object[][]{
                new Object[]{"осциллограф", "www.tehencom.com"},
        };
    }
    //@Test(dataProvider = "keyWords")
    public void firstTest(String keyWord, String url) throws InterruptedException {

        driver.get("https://www.google.com.ua");
        driver.findElement(searchField).clear();
        driver.findElement(searchField).sendKeys(keyWord);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        for (int i = 3; i <= 5; i++) {
            Thread.sleep(2000);
            List<WebElement> elementsList = driver.findElements(By.cssSelector("._Rm"));

            for (WebElement option : elementsList) {
                if (option.getText().contains(url)) {
                    urlFound = true;
                    break;
                }
            }
            driver.findElement(By.xpath(".//*[@id='nav']/tbody/tr/td[" + i + "]/a/span")).click();
        }
        Assert.assertTrue(urlFound);
    }

    @Test
    public void findJob(){
        driver.get("http://valvesoftware.com/jobs/job_postings.html");
        WebElement dev = driver.findElement(By.xpath(".//div[contains(text(),'Software Engineer')]"));
        WebElement psy = driver.findElement(By.cssSelector(".job_position_container[id*='psychologist']"));
        Assert.assertTrue(dev.isDisplayed());
        Assert.assertTrue(psy.isDisplayed());

        }

    @AfterTest
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
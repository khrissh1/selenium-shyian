package basictasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Created by Khrystyna.Shyian on 19.03.2015.
 */
public class TestBase {

    public static WebDriver driver;

    @BeforeTest
    public void beforeTest() {

        driver = new FirefoxDriver();
    }

    @AfterTest
    public void afterTest() {

        driver.close();
        driver.quit();
    }
}

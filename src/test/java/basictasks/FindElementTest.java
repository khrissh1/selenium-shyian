package basictasks;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Khrystyna.Shyian on 19.03.2015.
 */
public class FindElementTest extends TestBase {

    @Test(expectedExceptions = NoSuchElementException.class)
    public void findElementWithException1() {

        boolean elementPresent=false;

        driver.get("http://www.amazon.com/");
        WebElement element = driver.findElement(By.cssSelector(".nav-input[class='nav']"));
        elementPresent = true;
        Assert.assertTrue(!elementPresent);

    }


    @Test
    public void findElementNoException() {

        driver.get("http://www.amazon.com/");
        List<WebElement> elementsList  = driver.findElements(By.cssSelector(".nav-input[class='nav']"));
        Assert.assertTrue(elementsList.isEmpty());
    }
}

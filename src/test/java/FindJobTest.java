import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Khrystyna.Shyian on 19.03.2015.
 */
public class FindJobTest extends TestBase {
    @Test
    public void findJob() {

        driver.get("http://valvesoftware.com/jobs/job_postings.html");
        WebElement dev = driver.findElement(By.xpath(".//div[contains(text(),'Software Engineer')]"));
        WebElement psy = driver.findElement(By.cssSelector(".job_position_container[id*='psychologist']"));
        Assert.assertTrue(dev.isDisplayed());
        Assert.assertTrue(psy.isDisplayed());
    }
}

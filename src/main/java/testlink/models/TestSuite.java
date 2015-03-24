package testlink.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Khrystyna.Shyian on 20.03.2015.
 */
public class TestSuite {

    protected WebDriver driver;
    private final By showTestSuiteOperations = By.cssSelector(".clickable[title='Actions']");
    private final By addNewSuite  = By.id("new_testsuite");
    private final By suiteName = By.id("name");
    private final By saveSuiteButton = By.cssSelector("input[name='add_testsuite_button']");
    private final By deleteSuite = By.cssSelector("#delete_testsuite");
    private final By reallyDeleteSuite = By.cssSelector(".workBack>form>input[type='submit']");
    private final By createdSuite = By.xpath(".//li[@class='x-tree-node']/div/a[@class='x-tree-node-anchor']/span/span");


    public TestSuite(WebDriver driver) {

        this.driver = driver;
    }


    public void createTestSuite() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(showTestSuiteOperations).click();
        driver.findElement(addNewSuite).click();
        driver.findElement(suiteName).sendKeys("TestSuit_2");
        driver.findElement(saveSuiteButton).click();
    }

    public boolean testSuiteIsCreated(){

        List <WebElement>  newTestSuite = driver.findElements(createdSuite);
        String bodyText = driver.findElement(By.tagName("body")).getText();
        boolean created = false;
        for(WebElement option : newTestSuite){
            if (option.getText().equals("TestSuit_2")){
                created  = true;
            }
        }

        return created & bodyText.contains("Test Suite created");
    }

    public void deleteTestSuite() throws InterruptedException {
        //Thread.sleep(3000);
        driver.findElement(showTestSuiteOperations).click();
        driver.findElement(deleteSuite).click();
        driver.findElement(reallyDeleteSuite).click();

    }

}



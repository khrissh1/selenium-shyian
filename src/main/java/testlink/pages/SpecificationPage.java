package testlink.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import selenium.DriverWrapper;
import testlink.models.TestCase;
import testlink.models.TestStep;
import testlink.models.TestSuite;

/**
 * Created by Khrystyna.Shyian on 20.03.2015.
 */
public class SpecificationPage extends AbstractPage {

    private static final By specPage = By.cssSelector("#testspecification_topics>a[href='lib/general/frmWorkArea.php?feature=editTc']");

    private static final By action = By.cssSelector(".clickable[title='Actions']");
    private static final By addNewSuite = By.id("new_testsuite");
    private static final By suiteName = By.id("name");
    private static final By saveSuiteButton = By.cssSelector("input[name='add_testsuite_button']");
    private static final By deleteSuite = By.cssSelector("#delete_testsuite");
    private static final By reallyDeleteSuite = By.cssSelector(".workBack>form>input[type='submit']");
    private static final By details = By.cssSelector("#cke_contents_details>iframe[title='Rich text editor, details']");
    private static final By addNewCase = By.id("create_tc");
    private static final By testCaseName = By.id("testcase_name");

    private static final By testCaseDetails = By.cssSelector("#cke_contents_summary>iframe[title='Rich text editor, summary']");
    private static final By testCasePreconditions = By.cssSelector("#cke_contents_preconditions>iframe[title='Rich text editor, preconditions']");
    private static final By createNewCase = By.id("do_create_button_2");
    private static final By createStep = By.xpath(".//*[@id='stepsControls']/div/input");

    private static final By stepAction = By.xpath(".//*[@id='cke_contents_steps']/iframe[@title='Rich text editor, steps']");
    private static final By expectedResults = By.xpath(".//*[@id='cke_contents_expected_results']/iframe[@title='Rich text editor, expected_results']");
    private static final By executionSelector = By.name("exec_type");
    private static final By saveAndExit = By.id("do_update_step_and_exit");
    private static final By stepsTable = By.xpath(".//*[@id='stepsControls']/table[@class='simple']");
    private static final By body = By.tagName("body");

    private static final By uploadFile = By.id("uploadedFile");
    private static final By fileTitle = By.id("fileTitle");
    private static final By uploadButton = By.xpath(".//*[@id='aForm']/input[@value='Upload file']");


    public SpecificationPage(DriverWrapper driver) {
        super(driver);
    }

    public void open() throws InterruptedException {

        switchToMainFrame();
        waitUntilElementIsPresent(specPage);
        driver.findElement(specPage).click();
        LOG.info("Specification page is opening");

    }

    public void createTestSuite(TestSuite suite) throws InterruptedException {

        switchToWorkFrame();
        waitUntilElementIsPresent(action);
        driver.findElement(action).click();
        driver.findElement(addNewSuite).click();
        waitUntilElementIsPresent(suiteName);
        driver.findElement(suiteName).sendKeys(suite.getName());
        driver.findElement(details).sendKeys(suite.getDetails());
        driver.findElement(saveSuiteButton).click();
        LOG.info("Test suite  " + suite.getName() + " is creating");

    }

    public boolean testSuiteIsCreated(TestSuite suite) {

        switchToWorkFrame();
        String bodyText = driver.findElement(body).getText();

        return bodyText.contains(suite.textAfterCreation);
    }

    public void deleteTestSuite() throws InterruptedException {

        driver.findElement(action).click();
        driver.findElement(deleteSuite).click();
        driver.findElement(reallyDeleteSuite).click();

    }

    public void selectTestSuite(TestSuite suite) throws InterruptedException {
        switchToTreeFrame();

        Actions action = new Actions(driver.driver);
        waitUntilElementIsPresent(By.xpath("//li[@class='x-tree-node']/div[contains(@id,'extdd')]/a[@class='x-tree-node-anchor']/span[contains(@id,'extdd')]/span[contains(text(),'"+ suite.getName() + "')]"));
        action.moveToElement(driver.findElement(By.xpath("//li[@class='x-tree-node']/div[contains(@id,'extdd')]/a[@class='x-tree-node-anchor']/span[contains(@id,'extdd')]/span[contains(text(),'"+ suite.getName() + "')]"))).doubleClick().build().perform();
        LOG.info("Test suite  " + suite.getName() + " is selecting");
    }

    public void createTestCase(TestCase testcase) throws InterruptedException {

        switchToWorkFrame();
        driver.findElement(action).click();
        driver.findElement(addNewCase).click();
        driver.findElement(testCaseName).sendKeys(testcase.getName());
        driver.findElement(testCaseDetails).sendKeys(testcase.getDetails());
        driver.findElement(testCasePreconditions).sendKeys(testcase.getPreconditions());
        driver.findElement(createNewCase).click();
        LOG.info("Test case  " + testcase.getName() + " is creating");
    }

    public boolean testCaseIsCreated(TestCase testCase) {

        switchToWorkFrame();
        String bodyText = driver.findElement(body).getText();

        return bodyText.contains(testCase.getName());
    }

    public void selectTestCase(TestCase testCase) throws InterruptedException {

        switchToTreeFrame();
        waitUntilElementIsPresent(By.xpath("//li[@class='x-tree-node']/div[contains(@id,'extdd')]/a[@class='x-tree-node-anchor']/span[contains(text(),'" + testCase.getName() + "')]"));
        driver.findElement(By.xpath("//li[@class='x-tree-node']/div[contains(@id,'extdd')]/a[@class='x-tree-node-anchor']/span[contains(text(),'" + testCase.getName() + "')]")).click();
        LOG.info("Test case  " + testCase.getName() + " is selecting");
    }

    public void createTestStep(TestStep step) throws InterruptedException {

        switchToWorkFrame();
        waitUntilElementIsPresent(createStep);
        driver.findElement(createStep).click();
        waitUntilElementIsPresent(stepAction);
        driver.findElement(stepAction).sendKeys(step.getStepAction());
        driver.findElement(expectedResults).sendKeys(step.getExecutionResult());
        Select select = new Select(driver.findElement(executionSelector));
        select.selectByVisibleText(step.getExecution());
        driver.findElement(saveAndExit).click();
        LOG.info("Test step is creating");
    }

    public boolean testStepIsCreated(TestStep step) throws InterruptedException {

        switchToWorkFrame();
        waitUntilElementIsPresent(stepsTable);
        String bodyText = driver.findElement(stepsTable).getText();

        return bodyText.contains(step.getStepAction());
    }

    public void uploadFileToTestSuite(TestSuite suite){
        switchToWorkFrame();
        driver.findElement(uploadFile).sendKeys(suite.getFilePath());
        driver.findElement(fileTitle).sendKeys(suite.getFileName());
        driver.findElement(uploadButton).click();
        LOG.info("File  " + suite.getFileName() + " is uploading");
    }

    public boolean fileIsUploaded(TestSuite suite) throws InterruptedException {

        switchToWorkFrame();
        String bodyText = driver.findElement(body).getText();

        return bodyText.contains(suite.getFileName());
    }
}

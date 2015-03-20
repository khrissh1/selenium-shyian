package testlink.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Khrystyna.Shyian on 20.03.2015.
 */
public class LoginPage {

    protected WebDriver driver;
    static private final String URL = "http://demo.testlink.org/latest/login.php";
    private final By loginFld = By.id("login");
    private final By passwordFld = By.name("tl_password");
    private final By loginButton = By.name("login_submit");

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    public void open() {

        driver.get(URL);

    }

    public HomePage login(String login, String password) {

        driver.findElement(loginFld).sendKeys(login);
        driver.findElement(passwordFld).sendKeys(password);
        driver.findElement(loginButton).click();
        return new HomePage(driver);

    }
}
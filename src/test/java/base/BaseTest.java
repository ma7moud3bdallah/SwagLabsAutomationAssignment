package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

public class BaseTest {
    //Fields
    protected WebDriver driver;
    protected LoginPage loginPage;

    // Methods
    @BeforeMethod
    public void goLogin(){
        driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.InventoryPage;
import pages.LoginPage;

public class BaseTest {
    // Fields
    protected WebDriver driver;
    protected LoginPage loginPage;

    // Methods
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }
    @AfterMethod
    public void tearDown(){
//        driver.quit();
    }
}

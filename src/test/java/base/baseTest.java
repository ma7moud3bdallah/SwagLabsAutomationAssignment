package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.InventoryPage;
import pages.LoginPage;

public class baseTest {
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
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}

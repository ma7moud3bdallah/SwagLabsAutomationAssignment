package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import pages.InventoryPage;
import pages.LoginPage;

public class baseTest {
    // Fields
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected InventoryPage inventoryPage;

    // Methods
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

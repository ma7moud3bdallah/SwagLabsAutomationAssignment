package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage {
    // Fields
    private WebDriver driver;
    private By inventoryPageTitle = By.className("app_logo");
    private By cartIcon = By.className("shopping_cart_link");
    private By inventoryPageProducts = By.xpath("//div[@class='inventory_list']/div");

    // Constructor
    public InventoryPage(WebDriver driver){
        this.driver = driver;
    }

    // Methods
    public String getInventoryPageTitle(){
        return driver.findElement(inventoryPageTitle).getText();
    }
    public WebElement getCartIcon(){
        return driver.findElement(cartIcon);
    }
    public List<WebElement> getInventoryProducts(){
        return driver.findElements(inventoryPageProducts);
    }
}

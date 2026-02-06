package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    // Fields
    private WebDriver driver;
    private By cartIcon = By.cssSelector("div[id='shopping_cart_container'] > a");
    private By inventoryItems = By.className("inventoryItems");

    // Constructor
    public InventoryPage(WebDriver driver){
        this.driver = driver;
    }

    // Methods
    public void getTitle(){
        driver.getTitle();
    }
    public boolean isCartIconDisplayed(){
        return driver.findElement(cartIcon).isDisplayed();
    }
    public int getProductsCount(){
        return driver.findElements(inventoryItems).size();
    }
}

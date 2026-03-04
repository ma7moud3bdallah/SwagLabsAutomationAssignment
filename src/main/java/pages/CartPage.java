package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartPage {
    // Fields
    private WebDriver driver;
    private By cartItems = By.className("cart_item");
    private By itemsNames = By.className("inventory_item_name");
    private By removeTShirtButton = By.id("remove-sauce-labs-bolt-t-shirt");

    // Constructor
    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    // Methods
    public int getCartItemsNumber(){
        return driver.findElements(cartItems).size();
    }
    public List<WebElement> getCartItemsNames(){
        return driver.findElements(itemsNames);
    }
    public void removeTShirtFromCart(){
        driver.findElement(removeTShirtButton).click();
    }
}

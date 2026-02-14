package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    // Fields
    private WebDriver driver;
    private By cartItems = By.className("cart_item");

    // Constructor
    public CartPage(WebDriver driver){
        this.driver = driver;
    }
    // Methods
    public List<WebElement> getCartItems(){
        return driver.findElements(cartItems);
    }
}

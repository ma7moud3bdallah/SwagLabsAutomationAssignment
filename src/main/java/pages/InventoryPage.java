package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    // Fields
    private WebDriver driver;
    private By inventoryPageTitle = By.className("app_logo");
    private By cartIcon = By.className("shopping_cart_link");
    private By inventoryItems = By.cssSelector("div[class='inventory_list']>div");
    private By linkedinIcon = By.cssSelector("a[data-test='social-linkedin']");
    private By facebookIcon = By.cssSelector("a[data-test='social-facebook']");
    private By twitterIcon = By.cssSelector("a[data-test='social-twitter']");
    private By backpackButton = By.xpath("//div[@class='inventory_item'][1]//button");
    private By tShirtButton = By.xpath("//div[@class='inventory_item'][3]//button");
    private By onesieButton = By.xpath("//div[@class='inventory_item'][5]//button");

    // Constructor
    public InventoryPage(WebDriver driver){
        this.driver = driver;
    }

    // Methods
    public String getInventoryPageTitle(){
        return driver.findElement(inventoryPageTitle).getText();
    }
    public boolean isCartIconDisplayed(){
        return driver.findElement(cartIcon).isDisplayed();
    }
    public int getInventoryProductsNumber(){
        return driver.findElements(inventoryItems).size();
    }
    public void getLinkedinUrl(){
        driver.findElement(linkedinIcon).click();
        for(String windowHandle:driver.getWindowHandles()){
            driver.switchTo().window(windowHandle);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void getFacebookUrl(){
        driver.findElement(facebookIcon).click();
        for(String windowHandle:driver.getWindowHandles()){
            driver.switchTo().window(windowHandle);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void getTwitterUrl(){
        driver.findElement(twitterIcon).click();
        for(String windowHandle:driver.getWindowHandles()){
            driver.switchTo().window(windowHandle);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public CartPage openCart(){
        driver.findElement(cartIcon).click();
        return new CartPage(driver);
    }
    public void backpackAddToCart(){
        driver.findElement(backpackButton).click();
    }
    public void tShirtAddToCart(){
        driver.findElement(tShirtButton).click();
    }
    public void onesieAddToCart(){
        driver.findElement(onesieButton).click();
    }
    public String getTShirtButtonText(){
        return driver.findElement(tShirtButton).getText();
    }
    public String getBackpackButtonText(){
        return driver.findElement(backpackButton).getText();
    }
    public String getOnesieButtonText(){
        return driver.findElement(onesieButton).getText();
    }
}

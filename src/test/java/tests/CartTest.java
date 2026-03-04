package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;

public class CartTest extends BaseTest {
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    @BeforeMethod
    public void userSuccessfulLogin(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        inventoryPage = loginPage.clickLogin();
    }
    @Test(priority = 1)
    public void testCartItems(){
        cartPage = inventoryPage.openCart();
        Assert.assertEquals(cartPage.getCartItemsNumber(),0,"There are items in the cart");
    }
    @Test(priority = 2)
    public void testThreeItemsAdded(){
        inventoryPage.backpackAddToCart();
        inventoryPage.tShirtAddToCart();
        inventoryPage.onesieAddToCart();
        cartPage = inventoryPage.openCart();
        Assert.assertEquals(cartPage.getCartItemsNames().get(0).getText(),"Sauce Labs Backpack");
        Assert.assertEquals(cartPage.getCartItemsNames().get(1).getText(),"Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(cartPage.getCartItemsNames().get(2).getText(),"Sauce Labs Onesie");
    }
    @Test(priority = 3)
    public void testRemoveTShirtFromCart(){
        inventoryPage.backpackAddToCart();
        inventoryPage.tShirtAddToCart();
        inventoryPage.onesieAddToCart();
        cartPage = inventoryPage.openCart();
        cartPage.removeTShirtFromCart();
        driver.navigate().back();
        Assert.assertEquals(inventoryPage.getTShirtButtonText(),"Add to cart","Incorrect button text");
        Assert.assertEquals(inventoryPage.getBackpackButtonText(),"Remove","Incorrect button text");
        Assert.assertEquals(inventoryPage.getOnesieButtonText(),"Remove","Incorrect button text");
    }
}

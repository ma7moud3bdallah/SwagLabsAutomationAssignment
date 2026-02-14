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
    public void successfulLogin(){
        loginPage.setUsernameField("standard_user");
        loginPage.setPasswordField("secret_sauce");
        inventoryPage = loginPage.clickLoginButton();
        cartPage = inventoryPage.clickCartIcon();
    }
    @Test
    public void testCartItem(){
        Assert.assertTrue(cartPage.getCartItems().isEmpty(),"There are items in cart");
    }
}

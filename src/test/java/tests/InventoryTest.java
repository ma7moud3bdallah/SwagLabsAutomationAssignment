package tests;

import base.baseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryPage;

public class InventoryTest extends baseTest {
    @BeforeMethod
    public void successfulLogin(){
        loginPage.setUsernameField("standard_user");
        loginPage.setPasswordField("secret_sauce");
        inventoryPage = loginPage.clickLoginButton();
    }
    @Test
    public void testPageTitle(){
        Assert.assertEquals(inventoryPage.getInventoryPageTitle(),"Swag Labs","Page title is incorrect");
    }
    @Test
    public void testCartIconDisplayed(){
        Assert.assertTrue(inventoryPage.getCartIcon().isDisplayed(),"Cart icon is not displayed");
    }
    @Test
    public void testInventoryPageProducts(){
        Assert.assertEquals(inventoryPage.getInventoryProducts().size(),6,"Products displayed is incorrect");
    }
}

package tests;

import base.baseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryPage;

public class InventoryTest extends baseTest {
    @BeforeMethod
    public void testSuccessfulLogin(){
        loginPage.setUsernameField("standard_user");
        loginPage.setPasswordField("secret_sauce");
    }
    @Test
    public void testPageTitle(){
        InventoryPage inventoryPage = loginPage.clickLoginButton();
        Assert.assertTrue(inventoryPage.getInventoryPageTitle().equals("Swag Labs"),"Page title is incorrect");
    }
    @Test
    public void testCartIconDisplayed(){
        InventoryPage inventoryPage = loginPage.clickLoginButton();
        Assert.assertTrue(inventoryPage.isCartIconDisplayed(),"Cart icon is not displayed");
    }
}

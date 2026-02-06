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
        loginPage.clickLoginButton();
    }

    @Test
    public void testTitle(){
        Assert.assertTrue(driver.getTitle().equals("Swag Labs"),"Page title is incorrect");
    }
    @Test
    public void testCartIconDisplayed(){
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertTrue(inventoryPage.isCartIconDisplayed(),"Cart icon is not displayed");
    }
    @Test
    public void verifyProductsCount(){
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getProductsCount(),6,"Products displayed is incorrect");
    }
}

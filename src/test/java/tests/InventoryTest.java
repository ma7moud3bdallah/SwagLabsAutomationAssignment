package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryPage;

public class InventoryTest extends BaseTest {
    private InventoryPage inventoryPage;
    @BeforeMethod
    public void userSuccessfulLogin(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        inventoryPage = loginPage.clickLogin();
    }
    @Test
    public void testPageTitle(){
        Assert.assertEquals(inventoryPage.getInventoryPageTitle(),"Swag Labs","Incorrect page title");
    }
    @Test
    public void testCartIcon(){
        Assert.assertTrue(inventoryPage.isCartIconDisplayed(),"Cart icon is not displayed");
    }
    @Test
    public void testNumberOfProducts(){
        Assert.assertEquals(inventoryPage.getInventoryProductsNumber(),6,"Products displayed is not 6");
    }
    @Test
    public void testLinkedinUrl(){
        inventoryPage.getLinkedinUrl();
        Assert.assertTrue(driver.getCurrentUrl().contains("linkedin"),"LinkedIn did not open correctly");
    }
    @Test
    public void testFacebookUrl(){
        inventoryPage.getFacebookUrl();
        Assert.assertTrue(driver.getCurrentUrl().contains("facebook"),"Facebook did not open correctly");
    }
    @Test
    public void testTwitterUrl(){
        inventoryPage.getTwitterUrl();
        Assert.assertTrue(driver.getCurrentUrl().contains("x.com"),"Twitter did not open correctly");
    }
}

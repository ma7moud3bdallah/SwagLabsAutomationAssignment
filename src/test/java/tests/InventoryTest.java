package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryPage;

public class InventoryTest extends BaseTest {
    private InventoryPage inventoryPage;
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
    @Test
    public void testLinkedinICon(){
        inventoryPage.clickLinkedinIcon();
        for(String handle:driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("linkedin"),"LinkedIn did not open correctly");
    }
    @Test
    public void testFacebookIcon(){
        inventoryPage.clickFacebookIcon();
        for(String handle:driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("facebook"),"Facebook did not open correctly");
    }
    @Test
    public void testTwitterIcon(){
        inventoryPage.clickTwitterIcon();
        for(String handle:driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("x.com"),"Twitter did not open correctly");
    }
}

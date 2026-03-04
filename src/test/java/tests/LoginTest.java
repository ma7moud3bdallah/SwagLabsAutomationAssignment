package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(priority = 1)
    public void testSuccessfulLogin(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"),"User not redirected to the Inventory page");
    }
    @Test(priority = 2)
    public void testInvalidLogin(){
        loginPage.setUsername("mahmoud123");
        loginPage.setPassword("123456");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"),"User can login with invalid username and password");
    }
    @Test(priority = 3)
    public void testWithoutPassword(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.getErrorMessage().contains("Password is required"),"User can login without password");
    }
}

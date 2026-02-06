package tests;

import base.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends baseTest {
    @Test(priority = 1)
    public void testSuccessfulLogin(){
        loginPage.setUsernameField("standard_user");
        loginPage.setPasswordField("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"),"Not redirected to Inventory page");
    }
    @Test(priority = 2)
    public void testInvalidLogin(){
        loginPage.setUsernameField("mahmoud_117");
        loginPage.setPasswordField("123456");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match any user in this service"),"User can login with any username and password");
    }
    @Test(priority = 3)
    public void testLoginWithoutPassword(){
        loginPage.setUsernameField("standard_user");
        loginPage.setPasswordField("");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.getErrorMessage().contains("Password is required"),"User can login without password");
    }
}

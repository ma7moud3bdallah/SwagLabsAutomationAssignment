package tests;

import base.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends baseTest {
    @Test
    public void testSuccessfulLogin(){
        loginPage.setUsernameField("standard_user");
        loginPage.setPasswordField("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"),"User was not successfully navigated to inventory page");
    }
    @Test
    public void testInvalidLogin(){
        loginPage.setUsernameField("standard.user");
        loginPage.setPasswordField("secret.sauce");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.getErrorMessage().contains("do not match"),"User was able to login with invalid credentials");
    }
    @Test
    public void testLoginWithoutPassword(){
        loginPage.setUsernameField("standard_user");
        loginPage.setPasswordField("");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.getErrorMessage().contains("Password is required"),"User was able to login without password");
    }
}

package tests;

import base.baseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InventoryTest extends baseTest {
    @BeforeMethod
    public void testSuccessfulLogin(){
        loginPage.setUsernameField("standard_user");
        loginPage.setPasswordField("secret_sauce");
        loginPage.clickLoginButton();
    }
    @Test
    public void testPageTitle(){

    }
}

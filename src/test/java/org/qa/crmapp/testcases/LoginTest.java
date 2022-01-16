package org.qa.crmapp.testcases;

import org.qa.crmapp.base.Base;
import org.qa.crmapp.pages.HomePage;
import org.qa.crmapp.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends Base {
    LoginPage loginPage;
    HomePage homePage;

    public LoginTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initializeDriver();
        loginPage = new LoginPage();
    }

    @Test
    public void loginTest() {
        homePage = loginPage.login(properties.getProperty("email"), properties.getProperty("password"));
        Assert.assertEquals(homePage.getUserName(), properties.getProperty("name"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

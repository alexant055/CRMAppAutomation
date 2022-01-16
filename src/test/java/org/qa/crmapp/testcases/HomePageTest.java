package org.qa.crmapp.testcases;

import org.qa.crmapp.base.Base;
import org.qa.crmapp.pages.ContactsPage;
import org.qa.crmapp.pages.HomePage;
import org.qa.crmapp.pages.LoginPage;
import org.qa.crmapp.utils.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends Base {
    HomePage homePage;
    ContactsPage contactsPage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initializeDriver();
        // TestUtil.switchToFrame();
        homePage = new LoginPage().login(properties.getProperty("email"), properties.getProperty("password"));
    }

    @Test
    public void clickContactsButton() {
        contactsPage = homePage.clickContacts();
        Assert.assertEquals(contactsPage.getContactsText(), "Create New Contact");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

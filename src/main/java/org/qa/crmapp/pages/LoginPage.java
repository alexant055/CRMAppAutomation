package org.qa.crmapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qa.crmapp.base.Base;

public class LoginPage extends Base {

    @FindBy(xpath = "//input[@name='email']")
    WebElement email;
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;
    @FindBy(xpath = "//div[contains(text(), 'Login') and contains(@class, 'submit') ]")
    WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public HomePage login(String userEmail, String pwd) {
        email.sendKeys(userEmail);
        password.sendKeys(pwd);
        loginButton.click();
        return new HomePage();
    }
}

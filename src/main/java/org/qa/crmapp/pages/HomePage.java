package org.qa.crmapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qa.crmapp.base.Base;

public class HomePage extends Base {

    @FindBy(className = "user-display")
    WebElement userName;
    @FindBy(className = "menu-item-wrapper")
    WebElement mainNav;
    @FindBy(xpath = "//span[contains(text(),'Contacts')]//parent::a//following-sibling::button")
    WebElement addContact;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String getUserName() {
        return userName.getText();
    }

    public ContactsPage clickContacts() {
        new Actions(driver).moveToElement(mainNav).perform();
        addContact.click();
        return new ContactsPage();
    }
}

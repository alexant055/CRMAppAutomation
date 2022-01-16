package org.qa.crmapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qa.crmapp.base.Base;

public class ContactsPage extends Base {

    @FindBy(xpath = "//div[contains(@class, 'ui loader')]")
    WebElement contactText;

    public ContactsPage() {
        PageFactory.initElements(driver, this);
    }

    public String getContactsText() {
        return contactText.getText();
    }
}

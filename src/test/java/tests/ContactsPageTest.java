package tests;

import config.BaseTest;
import helpers.TopMenuItem;
import model.Contact;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ContactsPage;
import pages.LoginPage;
import pages.MainPage;

public class ContactsPageTest extends BaseTest {


    @Test
    @Parameters("browser")
    public  void testGetDataFromContactList(@Optional("chrome") String browser) throws InterruptedException{
        MainPage mainPage = new MainPage(getDriver());
        LoginPage loginPage = mainPage.openTopMenu(TopMenuItem.LOGIN.toString());

        loginPage.fillEmailField("karina_marsel@mail.ru")
                .fillPasswordField("Marsel2003$")
                .clickByLoginButton();
        ContactsPage contactsPage = new ContactsPage(getDriver());
        Contact expectedContact = new Contact();
expectedContact.setName("Ivan");
expectedContact.setLastName("Ivanov");
expectedContact.setPhone("1234123456");
expectedContact.setEmail("abc.hkl@uigu.com");
expectedContact.setAddress("678 Green str");
expectedContact.setDescription("description");


boolean result = contactsPage.getDataFromContactList(expectedContact);
        Assert.assertTrue(result);
    }
}

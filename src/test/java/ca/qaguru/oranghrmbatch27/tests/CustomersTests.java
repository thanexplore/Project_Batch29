package ca.qaguru.oranghrmbatch27.tests;

import ca.qaguru.oranghrmbatch27.library.TestBase;
import ca.qaguru.oranghrmbatch27.pages.CustomersPage;
import ca.qaguru.oranghrmbatch27.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CustomersTests extends TestBase{

    @Test
    public void addNewCustomer()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123",true,null);
        CustomersPage customersPage = new CustomersPage(driver);
        customersPage.navigateToCustomer();
        Boolean status = customersPage.addCustomer("Anoop Joseph","Flexible pouch manufacturer");
        Assert.assertTrue(status);
    }

    @Test
    public void verifyNoOfRecords()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123",true,null);
        CustomersPage customersPage = new CustomersPage(driver);
        customersPage.navigateToCustomer();
        Assert.assertEquals(customersPage.getNumberOfRecords(),customersPage.getActualNumberOfRecords());
    }

    @Test
    public void verifyNoOfRecordsAfterAddingCustomer()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123",true,null);
        CustomersPage customersPage = new CustomersPage(driver);
        customersPage.navigateToCustomer();
        int DisplayedNumber1 = customersPage.getNumberOfRecords();
        customersPage.addCustomer("Deepu Joseph","Web developer");
        int DisplayedNumber2 = customersPage.getNumberOfRecords();
        Assert.assertEquals(DisplayedNumber2,DisplayedNumber1+1);
    }

    @Test
    public void verifyMandatoryFields()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123",true,null);
        CustomersPage customersPage = new CustomersPage(driver);
        customersPage.navigateToCustomer();
        String message = customersPage.mandatoryFields("Only description");
        Assert.assertEquals(message,"Required");
    }

    @Test
    public void editAddedRecord()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123",true,null);
        CustomersPage customersPage = new CustomersPage(driver);
        customersPage.navigateToCustomer();
        customersPage.addCustomer("Anoop","Testing ui");
        customersPage.editRecord("Anoop");
    }

    @Test
    public void deleteAddedRecord()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123",true,null);
        CustomersPage customersPage = new CustomersPage(driver);
        customersPage.navigateToCustomer();
        customersPage.addCustomer("Donald", "test");
        Boolean status = customersPage.deleteRecord("Donald");
        Assert.assertTrue(status);
    }




















}

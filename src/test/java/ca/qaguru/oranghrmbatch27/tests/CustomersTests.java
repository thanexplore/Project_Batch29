package ca.qaguru.oranghrmbatch27.tests;

import ca.qaguru.oranghrmbatch27.library.TestBase;
import ca.qaguru.oranghrmbatch27.pages.CustomersPage;
import ca.qaguru.oranghrmbatch27.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomersTests extends TestBase {

    String userName = "Admin";
    String password = "admin123";
    //BATCH29-10
    @Test
    public void addNewCustomer()
    {
        String name = "Vincent Gomas";
        String description = "Erp Data Analyst";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userName,password,true,null);
        CustomersPage customersPage = new CustomersPage(driver);
        customersPage.navigateToCustomer();
        Boolean status = customersPage.addCustomer(name,description);
        Assert.assertTrue(status);
    }

    //BATCH29-13
    @Test
    public void verifyNoOfRecords()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userName,password,true,null);
        CustomersPage customersPage = new CustomersPage(driver);
        customersPage.navigateToCustomer();
        Assert.assertEquals(customersPage.getNumberOfRecords(),customersPage.getActualNumberOfRecords());
    }

    //BATCH29-14
    @Test
    public void verifyNoOfRecordsAfterAddingCustomer()
    {
        String name = "Anthony";
        String description = "Developer";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userName,password,true,null);
        CustomersPage customersPage = new CustomersPage(driver);
        customersPage.navigateToCustomer();
        int DisplayedNumber1 = customersPage.getNumberOfRecords();
        customersPage.addCustomer(name,description);
        int DisplayedNumber2 = customersPage.getNumberOfRecords();
        Assert.assertEquals(DisplayedNumber2,DisplayedNumber1+1);
    }

    //BATCH29-15
    @Test
    public void verifyMandatoryFields()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userName,password,true,null);
        CustomersPage customersPage = new CustomersPage(driver);
        customersPage.navigateToCustomer();
        String message = customersPage.mandatoryFields("Only description entered");
        Assert.assertEquals(message,"Required");
    }

    //BATCH29-17
    @Test
    public void deleteAddedRecord()
    {
        String name = "Donald ";
        String description = "Business";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userName,password,true,null);
        CustomersPage customersPage = new CustomersPage(driver);
        customersPage.navigateToCustomer();
        customersPage.addCustomer(name, description);
        Boolean status = customersPage.deleteRecord("Donald");
        Assert.assertTrue(status);
    }
}


package ca.qaguru.oranghrmbatch27.tests;

import ca.qaguru.oranghrmbatch27.library.TestBase;
import ca.qaguru.oranghrmbatch27.pages.HeaderPage;
import ca.qaguru.oranghrmbatch27.pages.LanguagesPage;
import ca.qaguru.oranghrmbatch27.pages.LoginPage;
import ca.qaguru.oranghrmbatch27.pages.MenuOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LanguagesTests extends TestBase {

    @BeforeMethod
    public void Login(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
    }

    @Test
    public void headerLanguages() {
        //Login();
        //LoginPage loginPage = new LoginPage(driver);
        //loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.LANGUAGES);
        LanguagesPage languagesPage = new LanguagesPage(driver);
        languagesPage.CheckLanguageTitle();

    }

    @Test
    public void headerAddLanguages() {
        //Login();
        //LoginPage loginPage = new LoginPage(driver);
       // loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.LANGUAGES);
        LanguagesPage languagesPage = new LanguagesPage(driver);
        languagesPage.addLanguage();

    }

    @Test
    public void mandatoryEnabled() {
        //Login();
        //LoginPage loginPage = new LoginPage(driver);
        //loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.LANGUAGES);
        LanguagesPage languagesPage = new LanguagesPage(driver);
        languagesPage.isMandatory("");
    }

    @Test
    public void addLanguages() {
        //Login();
        //LoginPage loginPage = new LoginPage(driver);
        //loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        LanguagesPage languagesPage = new LanguagesPage(driver);
        headerPage.selectMenu(MenuOptions.LANGUAGES);
        String strNoOfRecordsBeforeAdding=languagesPage.checkRecordMessage();
        languagesPage.saveNewLanguage("abc");
        String strNoOfRecordsAfterAdding=languagesPage.checkRecordMessage();
        System.out.println(strNoOfRecordsBeforeAdding + " before adding");
        System.out.println(strNoOfRecordsAfterAdding + " after adding");

        Assert.assertNotEquals(strNoOfRecordsBeforeAdding,strNoOfRecordsAfterAdding);
    }

}
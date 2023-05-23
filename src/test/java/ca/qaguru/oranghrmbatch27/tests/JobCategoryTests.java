package ca.qaguru.oranghrmbatch27.tests;

import ca.qaguru.oranghrmbatch27.library.TestBase;
import ca.qaguru.oranghrmbatch27.pages.HeaderPage;
import ca.qaguru.oranghrmbatch27.pages.JobCategoriesPage;
import ca.qaguru.oranghrmbatch27.pages.LoginPage;
import ca.qaguru.oranghrmbatch27.pages.MenuOptions;
import org.testng.annotations.Test;

public class JobCategoryTests extends TestBase {


    @Test
    public void headerJobCategory() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.JOB_CATEGORIES);
        JobCategoriesPage jobCategoriesPage = new JobCategoriesPage(driver);
        jobCategoriesPage.header();
    }

    @Test
    public void headerAddJobCategory() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.JOB_CATEGORIES);
        JobCategoriesPage jobCategoriesPage = new JobCategoriesPage(driver);
        jobCategoriesPage.addJobCategoryheader();

    }
    @Test
    public void mandatoryEnabled() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.JOB_CATEGORIES);
        JobCategoriesPage jobCategoriesPage = new JobCategoriesPage(driver);
        jobCategoriesPage.isMandatory("");
    }
    @Test
    public void addNewCategory() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.JOB_CATEGORIES);
        JobCategoriesPage jobCategoriesPage = new JobCategoriesPage(driver);
        jobCategoriesPage.saveNewJobCategory("Finance Analyst");
    }

}
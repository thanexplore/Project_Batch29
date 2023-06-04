package ca.qaguru.oranghrmbatch27.tests;

import ca.qaguru.oranghrmbatch27.library.TestBase;
import ca.qaguru.oranghrmbatch27.pages.HeaderPage;
import ca.qaguru.oranghrmbatch27.pages.JobCategoriesPage;
import ca.qaguru.oranghrmbatch27.pages.LoginPage;
import ca.qaguru.oranghrmbatch27.pages.MenuOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JobCategoryTests extends TestBase {


    public static final String FINANCE_ANALYST = "Finance";
    public static final String USERNAME = "Admin";
    public static final String PASSWORD = "admin123";

    @Test
    public void headerJobCategory() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(USERNAME, PASSWORD, true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.JOB_CATEGORIES);
        JobCategoriesPage jobCategoriesPage = new JobCategoriesPage(driver);
        Assert.assertEquals(jobCategoriesPage.header(), "Job Categories");
    }

    @Test
    public void headerAddJobCategory() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(USERNAME, PASSWORD, true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.JOB_CATEGORIES);
        JobCategoriesPage jobCategoriesPage = new JobCategoriesPage(driver);
        Assert.assertEquals(jobCategoriesPage.addJobCategoryheader(), "Add Job Category");
    }

    @Test
    public void mandatoryEnabled() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(USERNAME, PASSWORD, true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.JOB_CATEGORIES);
        JobCategoriesPage jobCategoriesPage = new JobCategoriesPage(driver);
        Assert.assertTrue(jobCategoriesPage.isMandatory());
    }

    @Test
    public void addNewCategory() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(USERNAME, PASSWORD, true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.JOB_CATEGORIES);
        JobCategoriesPage jobCategoriesPage = new JobCategoriesPage(driver);
        jobCategoriesPage.saveNewJobCategory(FINANCE_ANALYST);
        Assert.assertTrue(jobCategoriesPage.isJobCategoryAdded(FINANCE_ANALYST));
    }

}
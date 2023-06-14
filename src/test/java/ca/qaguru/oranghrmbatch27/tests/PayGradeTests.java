package ca.qaguru.oranghrmbatch27.tests;

import ca.qaguru.oranghrmbatch27.library.TestBase;
import ca.qaguru.oranghrmbatch27.pages.LoginPage;
import ca.qaguru.oranghrmbatch27.pages.PayGradePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PayGradeTests extends TestBase {

    String username = "Admin";
    String password = "admin123";
    String alphabetPayGradeName = "Grade";
    String numericPayGradeName = "123";
    String alphaNumericPayGradeName = "Grade321";
    String alphaNumericWithSpacePayGradeName = "Grade 123";

    @Test(priority = 0)
    public void savePayGradeAlphabetOnly() {
        navigateToPayGrade(true);
        savePayGradeSuccessfully(alphabetPayGradeName);
        deleteRecord(alphabetPayGradeName);
    }

    @Test(priority = 1)
    public void savePayGradeNumericOnly() {
        navigateToPayGrade(true);
        savePayGradeSuccessfully(numericPayGradeName);
        deleteRecord(numericPayGradeName);
    }

    @Test(priority = 3)
    public void savePayGradeAlphaNumericOnly() {
        navigateToPayGrade(true);
        savePayGradeSuccessfully(alphaNumericPayGradeName);
        deleteRecord(alphaNumericPayGradeName);
    }

    @Test(priority = 2)
    public void savePayGradeAlphaNumericWithSpace() {
        navigateToPayGrade(true);
        savePayGradeSuccessfully(alphaNumericWithSpacePayGradeName);
        deleteRecord(alphaNumericWithSpacePayGradeName);
    }

    @Test(priority = 4)
    public void checkNameFieldIsMandatory() {
        navigateToPayGrade(true);
        navigateToAddPayGrade();
        PayGradePage payGradePage = new PayGradePage(driver);
        String errorMessage = payGradePage.checkPayGradeNameFieldIsMandatory();
        Assert.assertEquals(errorMessage, "Required");
    }

    @Test(priority = 5)
    public void ensureCancelButtonWorking() {
        navigateToPayGrade(true);
        PayGradePage payGradePage = new PayGradePage(driver);
        payGradePage.clickPayGrade();
        int currentTotalNoOfRecords = payGradePage.totalNoOfPayGrades();
        payGradePage.clickPayGradeAddButton();
        payGradePage.setPayGrade(alphabetPayGradeName);
        payGradePage.cancelButton();
        int newTotalNoOfRecords = payGradePage.totalNoOfPayGrades();
        Assert.assertEquals(currentTotalNoOfRecords, newTotalNoOfRecords);
    }

    private void deleteRecord(String name) {
        PayGradePage payGradePage = new PayGradePage(driver);
        payGradePage.clickPayGrade();
        int existingTotalNoOfRecords = payGradePage.totalNoOfPayGrades();
        payGradePage.deleteButton(name);
        int afterRecordDeleted = payGradePage.totalNoOfPayGrades();
        Assert.assertEquals(existingTotalNoOfRecords, afterRecordDeleted + 1);
    }

    private void savePayGradeSuccessfully(String name) {
        PayGradePage payGradePage = new PayGradePage(driver);
        int recordCountBeforeSave = payGradePage.totalNoOfPayGrades();
        navigateToAddPayGrade();
        payGradePage.setPayGrade(name);
        payGradePage.savePayGrade();
        payGradePage.clickPayGrade();
        int recordCountAfterSave = payGradePage.totalNoOfPayGrades();
        Assert.assertEquals(recordCountAfterSave, recordCountBeforeSave + 1);
    }

    private void navigateToAddPayGrade() {
        PayGradePage payGradePage = new PayGradePage(driver);
        payGradePage.clickPayGradeAddButton();
    }

    private void navigateToPayGrade(boolean isLoginRequired) {
        if (isLoginRequired == true) {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(username, password, true, null);
        }
        PayGradePage payGradePage = new PayGradePage(driver);
        payGradePage.clickPayGrade();
    }
}

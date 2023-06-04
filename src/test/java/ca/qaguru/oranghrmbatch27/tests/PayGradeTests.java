package ca.qaguru.oranghrmbatch27.tests;

import ca.qaguru.oranghrmbatch27.library.TestBase;
import ca.qaguru.oranghrmbatch27.pages.LoginPage;
import ca.qaguru.oranghrmbatch27.pages.PayGradePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PayGradeTests extends TestBase {

    String username="Admin";
    String password="admin123";
    String alphabetPayGradeName="Grade";
    String numericPayGradeName="123";
    String alphaNumericPayGradeName="Grade123";
    String alphaNumericWithSpacePayGradeName="Grade 123";

    @Test
    public void savePayGradeAlphabetOnly(){
        savePayGradeSuccessfully(alphabetPayGradeName);
    }

    @Test
    public void savePayGradeNumericOnly(){
        savePayGradeSuccessfully(numericPayGradeName);
    }

    @Test
    public void savePayGradeAlphaNumericOnly(){
        savePayGradeSuccessfully(alphaNumericPayGradeName);
    }

    @Test
    public void savePayGradeAlphaNumericWithSpace(){
        savePayGradeSuccessfully(alphaNumericWithSpacePayGradeName);
    }

    @Test
    public void checkNameFieldIsMandatory(){
        navigateToPayGrade();
        PayGradePage payGradePage=new PayGradePage(driver);
       String errorMessage=payGradePage.checkPayGradeNameFieldIsMandatory();
        Assert.assertEquals(errorMessage,"Required");
    }

    private void savePayGradeSuccessfully(String name){
        navigateToPayGrade();
        PayGradePage payGradePage=new PayGradePage(driver);
        payGradePage.savePayGrade(name);
        //String successMessage = payGradePage.savePayGrade(name);
        //System.out.println("XXXXXXXXXXXX : " + successMessage);
    }

    private void navigateToPayGrade(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(username,password,true,null);
        PayGradePage payGradePage=new PayGradePage(driver);
        payGradePage.clickPayGradeAddButton();
    }
}

package ca.qaguru.oranghrmbatch27.pages;

import ca.qaguru.oranghrmbatch27.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends PageBase {

    private String usernameFieldName = "username";
    private String passwordFieldName = "password";
    private String loginButtonClass = "orangehrm-login-button";
    private String ErrorMsgClass = "oxd-alert-content-text";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password, boolean validCredentials, String expErrMsg){
        setText(By.name(usernameFieldName), username);
        setText(By.name(passwordFieldName),password);
        click(By.className(loginButtonClass));

        HeaderPage headerPage = new HeaderPage(driver);
        if(validCredentials){
            Assert.assertTrue(headerPage.isMenuVisible());
        }else {
            Assert.assertFalse(headerPage.isMenuVisible());
            Assert.assertEquals(getText(By.className(ErrorMsgClass)),expErrMsg, "Incorrect Error Message");
        }
    }

}

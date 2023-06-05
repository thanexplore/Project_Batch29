package ca.qaguru.oranghrmbatch27.pages;

import ca.qaguru.oranghrmbatch27.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PayGradePage extends PageBase {

    public  PayGradePage(WebDriver _driver){
        super(_driver);
        PageFactory.initElements(_driver, this);
    }
    private String adminMenuPath="//span[text()=\"Admin\"]";
    private String jobTopMenuPath="//span[normalize-space()=\"Job\"]";
    private String payGradeDropDownMenuPath="//a[text()=\"Pay Grades\"]";
    private String addButtonPath="//button[normalize-space()=\"Add\"]";
    private String payGradeNameTextboxPath="//div[@class=\"oxd-form-row\"]//input";
    private  String saveButtonPath="//button[normalize-space()=\"Save\"]";
    private  String requiredFieldPath="//div[@class=\"oxd-form-row\"]//span";

    private String successMessagePath="//div[@class=\"oxd-toast-content oxd-toast-content--success\"]";

   public void clickPayGradeAddButton(){
        click(By.xpath(adminMenuPath));
        click(By.xpath(jobTopMenuPath));
        click(By.xpath(payGradeDropDownMenuPath));
        click(By.xpath(addButtonPath));
    }

    public Boolean savePayGrade(String payGradeName){
       setText(By.xpath(payGradeNameTextboxPath),payGradeName);
       click(By.xpath(saveButtonPath));
       return isElementVisible(By.xpath(successMessagePath));
      }

    public String checkPayGradeNameFieldIsMandatory(){
        click(By.xpath(saveButtonPath));
        isElementVisible(By.xpath(requiredFieldPath));
        return getText(By.xpath(requiredFieldPath));
    }
}

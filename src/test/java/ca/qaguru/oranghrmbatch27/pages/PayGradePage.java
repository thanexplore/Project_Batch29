package ca.qaguru.oranghrmbatch27.pages;

import ca.qaguru.oranghrmbatch27.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PayGradePage extends PageBase {

    public PayGradePage(WebDriver _driver) {
        super(_driver);
        PageFactory.initElements(_driver, this);
    }

    private String adminMenuPath = "//span[text()=\"Admin\"]";
    private String jobTopMenuPath = "//span[normalize-space()=\"Job\"]";
    private String payGradeDropDownMenuPath = "//a[text()=\"Pay Grades\"]";
    private String addButtonPath = "//button[normalize-space()=\"Add\"]";
    private String payGradeNameTextboxPath = "//div[@class=\"oxd-form-row\"]//input";
    private String saveButtonPath = "//button[normalize-space()=\"Save\"]";
    private String requiredFieldPath = "//div[@class=\"oxd-form-row\"]//span";
    private String successMessagePath = "//div[@class=\"oxd-toast-content oxd-toast-content--success\"]";
    private String cancelButtonXpath = "//button[normalize-space()=\"Cancel\"]";
    private String noOfRecordsXpath = "//div[@class=\"orangehrm-horizontal-padding orangehrm-vertical-padding\"]//span";
    private String yesDeleteButtonXpath = "//div[@class=\"orangehrm-modal-footer\"]//button[2]";
    private String xpathSuccessMessage = "//div[@class=\"oxd-toast oxd-toast--success oxd-toast-container--toast\"]";

    private String editButtonXpath="//i[@class=\"oxd-icon bi-pencil-fill\"]";

    @FindBy(xpath = "//div[@class=\"oxd-table-body\"] //div[@class=\"oxd-table-cell oxd-padding-cell\"][2]")
    List<WebElement> listOfRecordNames;

    @FindBy(xpath = "//i[@class=\"oxd-icon bi-trash\"]")
    List<WebElement> delete;

    public void clickPayGrade() {
        click(By.xpath(adminMenuPath));
        click(By.xpath(jobTopMenuPath));
        click(By.xpath(payGradeDropDownMenuPath));
    }

    public void clickPayGradeAddButton() {
        click(By.xpath(addButtonPath));
    }

    public void setPayGrade(String payGradeName) {
        setText(By.xpath(payGradeNameTextboxPath), payGradeName);
    }

    public Boolean savePayGrade() {
        click(By.xpath(saveButtonPath));
        return isElementVisible(By.xpath(successMessagePath));
    }

    public String checkPayGradeNameFieldIsMandatory() {
        click(By.xpath(saveButtonPath));
        isElementVisible(By.xpath(requiredFieldPath));
        return getText(By.xpath(requiredFieldPath));
    }

    public void cancelButton() {
        click(By.xpath(cancelButtonXpath));
    }

    public int totalNoOfPayGrades() {
        Boolean isNoOFRecordsVisible = isElementVisible(By.xpath(noOfRecordsXpath));
        if (isNoOFRecordsVisible == Boolean.TRUE) {
            String noOfRecordsValue = getText(By.xpath(noOfRecordsXpath));
            return noOfRecords(noOfRecordsValue);
        }
        return 0;
    }

    public boolean deleteButton(String name) {
        isElementVisible(By.xpath(editButtonXpath));
        for (int i = 0; i < listOfRecordNames.size(); i++) {
            if (listOfRecordNames.get(i).getText().equalsIgnoreCase(name)) {
                delete.get(i).click();
            }
        }
        click(By.xpath(yesDeleteButtonXpath));
        return isElementVisible(By.xpath(xpathSuccessMessage));
    }
}

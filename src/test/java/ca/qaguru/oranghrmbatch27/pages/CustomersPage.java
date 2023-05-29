package ca.qaguru.oranghrmbatch27.pages;

import ca.qaguru.oranghrmbatch27.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.regex.Pattern;

public class CustomersPage extends PageBase {

    WebDriver driver;

    public CustomersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private String xpathTime = "//span[text()=\"Time\"]";
    private String xpathProjectInfo = "//span[normalize-space()='Project Info']";
    private String xpathCustomers = "//a[text()=\"Customers\"]";
    private String xpathAddButton = "//button[normalize-space()='Add']";
    private String xpathNoOfRecords = "//div[@class=\"orangehrm-horizontal-padding orangehrm-vertical-padding\"]/span";
    private String xpathNameCell = "//div[@class=\"oxd-form-row\"]//input";
    private String xpathDescriptionCell = "//div[@class=\"oxd-form-row\"]//textarea";
    private String xpathSaveButton = "//button[@type=\"submit\"]";
    private String xpathRequiredMessage = "//div[@class=\"oxd-form-row\"]//span";
    private String xpathYesDeleteButton = "//div[@class=\"orangehrm-modal-footer\"]//button[2]";
    private String xpathSuccessMessage = "//div[@class=\"oxd-toast oxd-toast--success oxd-toast-container--toast\"]";

    @FindBy(xpath = "//div[@class=\"oxd-table-card\"]")
    List<WebElement> lines;

    @FindBy(xpath = "//div[@class=\"oxd-table-body\"] //div[@class=\"oxd-table-cell oxd-padding-cell\"][2]")
    List<WebElement> listOfRecordNames;

    @FindBy(xpath = "//i[@class=\"oxd-icon bi-pencil-fill\"]")
    List<WebElement> edits;

    @FindBy(xpath = "//textarea[@placeholder=\"Type description here\"]")
    WebElement editDescription;

    @FindBy(xpath = "//i[@class=\"oxd-icon bi-trash\"]")
    List<WebElement> delete;


    public void navigateToCustomer() {
        click(By.xpath(xpathTime));
        click(By.xpath(xpathProjectInfo));
        click(By.xpath(xpathCustomers));
    }

    public boolean addCustomer(String name, String description) {
        click(By.xpath(xpathAddButton));
        setText(By.xpath(xpathNameCell), name);
        setText(By.xpath(xpathDescriptionCell), description);
        click(By.xpath(xpathSaveButton));
        return isElementVisible(By.xpath(xpathSuccessMessage));

    }

    public String mandatoryFields(String description) {
        click(By.xpath(xpathAddButton));
        setText(By.xpath(xpathDescriptionCell), description);
        click(By.xpath(xpathSaveButton));
        isElementVisible(By.xpath(xpathRequiredMessage));
        return getText(By.xpath(xpathRequiredMessage));
    }

    public int getNumberOfRecords() {
        isElementVisible(By.xpath(xpathNoOfRecords));
        String Records = getText(By.xpath(xpathNoOfRecords));
        int NoOfRecords = noOfRecords(Records);
        return NoOfRecords;
    }

    public int getActualNumberOfRecords() {
        int ActualNoOfRecords = lines.size();
        //System.out.println(ActualNoOfRecords);
        return ActualNoOfRecords;
    }

    public boolean deleteRecord(String name) {
        isElementVisible(By.xpath("//i[@class=\"oxd-icon bi-pencil-fill\"]"));
        for (int i = 0; i < listOfRecordNames.size(); i++) {
            if (listOfRecordNames.get(i).getText().equalsIgnoreCase(name)) {
                delete.get(i).click();
            }
        }
        click(By.xpath(xpathYesDeleteButton));
        return isElementVisible(By.xpath(xpathSuccessMessage));
    }
}


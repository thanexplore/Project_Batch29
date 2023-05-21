package ca.qaguru.oranghrmbatch27.pages;

import ca.qaguru.oranghrmbatch27.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.regex.Pattern;

public class CustomersPage extends PageBase {

    WebDriver driver;
    public CustomersPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    private String Time = "//span[text()=\"Time\"]";
    private String ProjectInfo = "//span[normalize-space()='Project Info']";
    private String Customers = "//a[text()=\"Customers\"]";
    private String Add = "//button[normalize-space()='Add']";
    private String NoOfRecords = "//div[@class=\"orangehrm-horizontal-padding orangehrm-vertical-padding\"]/span";
    private String Name = "//div[@class=\"oxd-form-row\"]//input";
    private String Description = "//div[@class=\"oxd-form-row\"]//textarea";
    private String Save = "//button[@type=\"submit\"]";
    private String Required = "//div[@class=\"oxd-form-row\"]//span";
    private String YesDelete = "//div[@class=\"orangehrm-modal-footer\"]//button[2]";
    private String SuccessMessage = "//div[@class=\"oxd-toast oxd-toast--success oxd-toast-container--toast\"]";
    @FindBy(xpath = "//div[@class=\"oxd-table-card\"]")
    List<WebElement> lines;

    @FindBy(xpath ="//div[@class=\"oxd-table-body\"] //div[@class=\"oxd-table-cell oxd-padding-cell\"][2]")
    List<WebElement> listOfRecordNames;

    @FindBy(xpath = "//i[@class=\"oxd-icon bi-pencil-fill\"]")
    List<WebElement> edits;

    @FindBy(xpath="//textarea[@placeholder=\"Type description here\"]")
    WebElement editDescription;

    @FindBy(xpath="//i[@class=\"oxd-icon bi-trash\"]")
    List<WebElement> delete;



    public void navigateToCustomer()
    {
        click(By.xpath(Time));
        click(By.xpath(ProjectInfo));
        click(By.xpath(Customers));
    }

    public boolean addCustomer(String name, String description)
    {
        click(By.xpath(Add));
        setText(By.xpath(Name),name);
        setText(By.xpath(Description),description);
        click(By.xpath(Save));
        return isElementVisible(By.xpath(SuccessMessage));

    }

    public String mandatoryFields(String description)
    {
        click(By.xpath(Add));
        setText(By.xpath(Description),"Testinggggggg");
        click(By.xpath(Save));
        isElementVisible(By.xpath(Required));
        return driver.findElement(By.xpath(Required)).getText();

    }
    public int getNumberOfRecords()
    {
        sleep(3000);
        isElementVisible(By.xpath(NoOfRecords));
        String Records = driver.findElement(By.xpath(NoOfRecords)).getText();
        String name = Records.split(Pattern.quote(")"))[0].split(Pattern.quote("("))[1].trim();
        int NoOfRecords = Integer.parseInt(name);
        System.out.println(NoOfRecords);
        return NoOfRecords;
    }

    public int getActualNumberOfRecords()
    {
       int ActualNoOfRecords = lines.size();
       System.out.println(ActualNoOfRecords);
       return ActualNoOfRecords;
    }
    public boolean deleteRecord(String name)
    {
        isElementVisible(By.xpath("//i[@class=\"oxd-icon bi-pencil-fill\"]"));
        for(int i=0;i<listOfRecordNames.size();i++)
        {
            if(listOfRecordNames.get(i).getText().equalsIgnoreCase(name))
            {
                delete.get(i).click();
            }
        }
        click(By.xpath(YesDelete));
        return isElementVisible(By.xpath(SuccessMessage));
    }


}

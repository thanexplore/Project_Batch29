package ca.qaguru.oranghrmbatch27.pages;

import ca.qaguru.oranghrmbatch27.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class JobCategoriesPage extends PageBase {
    WebDriver driver;
    private final String addJobCategoryBtn = "//button[text()=' Add ']";
    private final String categoryNameTxtField = "//label[text()='Name']/following::input";
    private final String categorySaveBtn = "//button[text()=' Save ']";
    private final String categoryCancelBtn = "//button[text()=' Cancel ']";
    private final String categoryExistMsg = "//div[@class='oxd-form-row']/div";
    private final String categoryHeader = "//h6[text()='Job Categories']";
    private final String addJobCategoryHeader = "//h6[text()='Add Job Category']";
    private final String listOfJobCategories = ".oxd-table-body";
    private final String jobCategories = "//div[@class='oxd-table-body']/div[@class='oxd-table-card']";

    @FindBy(xpath = jobCategories)
    private List<WebElement> listJobCategories;

    public JobCategoriesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public String header() {
        isElementVisible(By.xpath(categoryHeader));
        return getText(By.xpath(categoryHeader));
    }

    public String addJobCategoryheader() {
        click(By.xpath(addJobCategoryBtn));
        isElementVisible(By.xpath(addJobCategoryHeader));
        return getText(By.xpath(addJobCategoryHeader));
    }

    public boolean isMandatory() {
        click(By.xpath(addJobCategoryBtn));
        setText(By.xpath(categoryNameTxtField), "");
        click(By.xpath(categorySaveBtn));
        if (getText(By.xpath(categoryExistMsg)).contains("Required")) {
            return true;
        }
        return false;
    }

    public void saveNewJobCategory(String categoryName) {
        click(By.xpath(addJobCategoryBtn));
        setText(By.xpath(categoryNameTxtField), categoryName);
        if (getText(By.xpath(categoryExistMsg)).contains("Already exists")) {
            click(By.xpath(categoryCancelBtn));
        } else {
            click(By.xpath(categorySaveBtn));
        }
    }

    public boolean isJobCategoryAdded(String categoryName) {
        isElementVisible(By.cssSelector(listOfJobCategories));
        for (WebElement category : listJobCategories) {
            String categoryText = category.getText();
            if (categoryName.equalsIgnoreCase(categoryText)) {
                return true;
            }
        }
        return false;
    }
}







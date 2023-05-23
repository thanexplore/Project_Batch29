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
    private final String categories = "//div[@class='oxd-table-body']/div[@class='oxd-table-card']";
    @FindBy(xpath = categories)
    private List<WebElement> listCategory;

    public JobCategoriesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void header() {
        String header = getText(By.xpath(categoryHeader));
        Assert.assertEquals(header, "Job Categories");
    }

    public void addJobCategoryheader() {
        click(By.xpath(addJobCategoryBtn));
        String header = getText(By.xpath(addJobCategoryHeader));
        Assert.assertEquals(header, "Add Job Category");
    }

    public void isMandatory(String categoryName) {
        click(By.xpath(addJobCategoryBtn));
        setText(By.xpath(categoryNameTxtField), categoryName);
        click(By.xpath(categorySaveBtn));
        if (getText(By.xpath(categoryExistMsg)).contains("Required")) {
            System.out.println("Mandatory field enabled");
        }
    }

    public void saveNewJobCategory(String categoryName) {
        click(By.xpath(addJobCategoryBtn));
        setText(By.xpath(categoryNameTxtField), categoryName);
        if (getText(By.xpath(categoryExistMsg)).contains("Already exists")) {
            click(By.xpath(categoryCancelBtn));
        } else {
            click(By.xpath(categorySaveBtn));
        }
        isElementVisible(By.cssSelector(listOfJobCategories));
        Boolean textCategorypresent = false;
        for (WebElement category : listCategory) {
            String categoryText = category.getText();
            //System.out.println(categoryText);
            if (categoryName.equalsIgnoreCase(categoryText)) {
                textCategorypresent = true;
            }
        }
        Assert.assertTrue(textCategorypresent);
        System.out.println("\n");
        System.out.println(categoryName + " is added successfully");
        System.out.println("\n");
    }


}




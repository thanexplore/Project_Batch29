package ca.qaguru.oranghrmbatch27.pages;

import ca.qaguru.oranghrmbatch27.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

import java.util.List;

public class LanguagesPage extends PageBase {

    WebDriver driver;

    @FindBy(xpath = LanguagesXpath.languages)
    private List<WebElement> listLanguages;

    public LanguagesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    /**
     * Function to verify if the "Language" title is displayed in the selected page
     */
    public void CheckLanguageTitle() {
        String header = getText(By.xpath(LanguagesXpath.languageHeader));
        Assert.assertEquals(header, "Languages");
    }

    /**
     * Function to verify if the "Add Language" title is displayed when the Add button is clicked
     */
    public void addLanguage() {
        click(By.xpath(LanguagesXpath.addLanguageButton));
        String header = getText(By.xpath(LanguagesXpath.addLanguageHeader));
        Assert.assertEquals(header, "Add Language");
    }

    public void isMandatory(String languageName) {
        click(By.xpath(LanguagesXpath.addLanguageButton));
        setText(By.xpath(LanguagesXpath.languageTextField), languageName);
        click(By.xpath(LanguagesXpath.saveLanguageButton));
        if (getText(By.xpath(LanguagesXpath.languageExistMsg)).contains("Required")) {
            System.out.println("Mandatory field enabled");
        }
    }

    public void saveNewLanguage(String languageName) {
        click(By.xpath(LanguagesXpath.addLanguageButton));
        setText(By.xpath(LanguagesXpath.languageTextField), languageName);
        if (getText(By.xpath(LanguagesXpath.languageExistMsg)).contains("Already exists")) {
            click(By.xpath(LanguagesXpath.cancelLanguageButton));
           System.out.println("Entry already available in the table");

        } else {
            click(By.xpath(LanguagesXpath.saveLanguageButton));

            isElementVisible(By.cssSelector(LanguagesXpath.listOfLanguages));

            Boolean textLanguagepresent = false;
            for (WebElement language : listLanguages) {
                String languageText = language.getText();
               // System.out.println(languageText);
                if (languageName.equalsIgnoreCase(languageText)) {
                    textLanguagepresent = true;
                }
            }
            Assert.assertTrue(textLanguagepresent);
            System.out.println(languageName + " is added successfully");
        }

    }

    public String checkRecordMessage() {
        isElementVisible(By.xpath(LanguagesXpath.numberOfRecordstxt));
        String strRecordNumberMessage = getText(By.xpath(LanguagesXpath.numberOfRecordstxt));
       // System.out.println(strRecordNumberMessage);
        return (strRecordNumberMessage);
    }



}



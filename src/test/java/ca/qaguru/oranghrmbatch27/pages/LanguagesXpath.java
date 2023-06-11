package ca.qaguru.oranghrmbatch27.pages;

public class LanguagesXpath {
    public static final String addLanguageButton = "//button[text()=' Add ']";
    public static final String languageTextField = "//label[text()='Name']/following::input";
    public static final String saveLanguageButton = "//button[text()=' Save ']";

    public static  final String cancelLanguageButton = "//button[text()=' Cancel ']";

    public static final String languageExistMsg = "//div[@class='oxd-form-row']/div";
    public static final String languageHeader = "//h6[text()='Languages']";
    public static final String addLanguageHeader = "//h6[text()='Add Language']";
    public static final String listOfLanguages = ".oxd-table-body";
    public static final String languages = "//div[@class='oxd-table-body']/div[@class='oxd-table-card']";
    public static final String numberOfRecordstxt = "//span[@class='oxd-text oxd-text--span']";
    public static final String deleteRecord = "//i[@class='oxd-icon bi-trash']";

}

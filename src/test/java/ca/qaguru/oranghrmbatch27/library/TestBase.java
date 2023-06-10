package ca.qaguru.oranghrmbatch27.library;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

public abstract class TestBase {
    protected WebDriver driver;
    //protected  ChromeDriver driver;
    protected String browser;
    protected final String BASE_URL = "https://opensource-demo.orangehrmlive.com";

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        beforeMethod("chrome");
    }

   // @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(@Optional("chrome") String browser) {
        this.browser = browser;
        System.out.println("Browser : " + browser);
        getDriver();
    }

    private void getDriver() {
        switch (browser.toLowerCase()) {
            case "chrome":
                //ChromeOptions options = new ChromeOptions();
                //options.addArguments("--remote-allow-origins=*");
                // driver = new ChromeDriver(options);
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                //driver = new SafariDriver();
                break;
            default:
                //driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }
    // @AfterMethod
    // public void afterMethod(){
    //driver.quit();
    // }

    @AfterSuite
    public void afterSuite() {

        driver.quit();
    }
}

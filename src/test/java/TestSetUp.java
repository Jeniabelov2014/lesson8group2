package test.java;

import main.java.PO.CoursePage;
import main.java.PO.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestSetUp {
    static WebDriver driver;
    static WebDriverWait wait;
    static WebElement preloader;
    static HomePage homePage;
    static CoursePage coursesPage;

    @BeforeMethod
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        coursesPage = new CoursePage(driver);
    }

    @AfterMethod
    public static void tearDown(ITestResult result) {
        driver.quit();
    }

}

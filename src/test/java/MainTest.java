package test.java;

import main.java.PO.CoursePage;
import main.java.PO.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;
import static org.testng.Assert.assertFalse;

public class MainTest {
    static WebDriver driver;
    static WebDriverWait wait;
    static WebElement preloader;
    static HomePage homePage;
    static CoursePage coursePage;

    @BeforeMethod
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        coursePage = new CoursePage(driver);
    }

    @Test(dataProvider = "providerEveningCourses")
    public static void mainTest(String courseName) throws InterruptedException {
        homePage.isShown()
                .openEveningCourses().openCourses(courseName);
                /*.selectLanguage(lang);
                .clicLogo()
                .openCourses("C++");*/
        coursePage.clickPay();
        assertTrue(coursePage.checkIfLocationIsSelected("Берестейская"));
        assertFalse(coursePage.checkIfLocationIsSelected("Позняки"));
        assertFalse(coursePage.checkIfLocationIsSelected("ВДНХ"));
    }

    @Test
    public static void checkEveningCourses() {
        assertTrue(homePage.isShown().openEveningCourses().isPresent());
    }


    @Test
    public static void mainTest() {
        homePage.isShown();
        List<String> expected = new ArrayList<String>();
        expected.add("RU");
        expected.add("UA");
        expected.add("EN");
        //for(String el: expected){
        //System.out.println(el);
        //}
        //for(int i = 0; i<expected.size(); i++){
        //System.out.println(expected.get(i));
        //}
        //List<Integer> list = new ArrayList<Integer>(); - обвертка для интеджеров(примитивов)
        //String expected[] = {"RU","UA","EN"};
        boolean isPresent = true;
        List<WebElement> elements = driver.findElements(By.xpath("(//ul[@class='lang'])[1]/li/a"));
        for (WebElement el : elements) {
            String text = el.getText();
            if (!expected.contains(text)) {
                isPresent = false;
            }
        }
        assertTrue(isPresent);
    }

    @AfterMethod
    public static void mainTest(ITestResult iTestResult) {

        driver.quit();
    }

    @DataProvider
    public Object[][] providerEveningCourses() {
        return new Object[][]{
                {"Тестирование"},
                {"Frontend development"},
                {"JS development"},
                {"Веб-дизайн"},
                {"PHP"},
                {"Программирование под IOS"},
                {"Программирование под Android"},
                {"Java programming"},
                {"Python"},
                {"Data Science/Machine Learning"},
                {"C# /.NET development"},
                {"C++"},
                {"Game Development"},
                {"DEVOPS"},
                {"Digital Marketing"},
                {"Управление персоналом"},
                {"Управление проектами"},
                {"Менеджмент"},
                {"Кибербезопасность"},
                {"Mobile development"},
                {"Видеомонтаж"},
                {"Cisco"},
                {"Go development"}

        };
    }

    @DataProvider
    public Object[][] provider() {
        return new Object[][]{
                {"ru-RU"},
                {"en-GB"},
                {"uk"}
        };
    }
}

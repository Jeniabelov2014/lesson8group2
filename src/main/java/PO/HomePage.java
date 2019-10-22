package main.java.PO;

import main.java.Utils.PropertyLoader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    public Logger logger = LogManager.getLogger(this.getClass());

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public HomePage isShown() {
        /*logger.trace("Trace log");
        logger.debug("Debag log lkjakljldsjalskjdalsdhada \n ashgdkajshgdjahgskdjhags \n");
        logger.info("Info log");
        logger.warn("Warn log");
        logger.error("Error log");
        logger.fatal("Fatal log");*/

        driver.get(PropertyLoader.loadProperty("url"));
        this.waitSpinner();
        logger.info("Home page is shown");
        return this;
    }

    public HomePage selectLanguage(String lang) {
        logger.info("Select language '" + lang + "'");
        WebElement ruLanguage = driver.findElement(By.xpath("(//a[@hreflang='" + lang + "'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(ruLanguage));
        ruLanguage.click();
        System.out.println("Ru language button clicked");
        this.waitSpinner();
        System.out.println("Spinner is loaded");
        return this;
    }

    public HomePage clicLogo() {
        WebElement logo = driver.findElement(By.xpath("//img[@alt='ITEA']"));
        wait.until(ExpectedConditions.visibilityOf(logo));
        logo.click();
        System.out.println("Logo clicked");
        this.waitSpinner();
        return this;
    }

    public HomePage openCourses(String courseName) {
        WebElement javaCourses = driver.findElement(By.xpath("//h2[contains(text(), '" + courseName + "')]/..")); //h3[contains(text(), '" + courseName + "')]/../img
        wait.until(ExpectedConditions.elementToBeClickable(javaCourses));
        javaCourses.click();
        this.waitSpinner();
        return this;
    }

    public HomePage openEveningCourses() {
        String locator = "//nav[@class='menu-main-menu-container']//a[.='Вечерние курсы']";
        WebElement eveningCourseBtn = driver.findElement(By.xpath(locator));
        wait.until(ExpectedConditions.visibilityOf(eveningCourseBtn));
        wait.until(ExpectedConditions.elementToBeClickable(eveningCourseBtn));
        eveningCourseBtn.click();
        logger.info("Click on Evening Courses button");
        WebElement courseBtn = driver.findElement(By.xpath(locator + "/..//a[.='Курсы']"));
        wait.until(ExpectedConditions.visibilityOf(courseBtn));
        wait.until(ExpectedConditions.elementToBeClickable(courseBtn));
        courseBtn.click();
        logger.info("Click on Courses button in dropdown");
        this.waitSpinner();
        logger.info("Evening Course page is shown");
        logger.info("All evening courses is shown");
        return this;
    }
}

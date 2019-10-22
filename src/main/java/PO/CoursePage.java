package main.java.PO;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CoursePage extends BasePage {

    public Logger logger = LogManager.getLogger(this.getClass());

    public CoursePage(WebDriver driver) {
        super(driver);
    }

    public CoursePage clickPay() {
        WebElement payBtn = driver.findElement(By.xpath("//button[@name='roadFull_payOnce']"));
        wait.until(ExpectedConditions.elementToBeClickable(payBtn));
        payBtn.click();
        this.waitSpinner();
        return this;
    }

    public boolean checkIfLocationIsSelected(String location) {
        By element = By.xpath("//input[@id=//div[contains(text(), '" + location + "')]/../@for]");
        WebElement webLocation = driver.findElement(element);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        logger.info("Checked location '"+ location +"'");
        return webLocation.isSelected();
    }
}

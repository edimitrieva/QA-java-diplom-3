package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseClass {
    WebDriver driver;

    public BaseClass(WebDriver driver) {
        this.driver = driver;
    }

    //ожидание, что элемент видим
    public void waitForVisibilityElement(By element) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
package pageObject;

import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.core.StringEndsWith.endsWith;

public class PrivateCabinet extends BaseClass {
    //Текст-описание в личном кабинете
    private By textPrivateCabinet = By.cssSelector("p.Account_text__fZAIn.text.text_type_main-default");
    //кнопка Выйти
    private By logout = By.xpath("//nav[@class='Account_nav__Lgali']//li[3]/button");

    public PrivateCabinet(WebDriver driver) {
        super(driver);
    }

    //проверка, что находимся в личном кабинете
    @Step("Check that private cabinet page is opened")
    public void checkOpenPrivateCabinet() {
        waitForVisibilityElement(textPrivateCabinet);
        String url = driver.getCurrentUrl();
        MatcherAssert.assertThat(url, endsWith("/account/profile"));
        Assert.assertEquals("В этом разделе вы можете изменить свои персональные данные", driver.findElement(textPrivateCabinet).getText());
    }

    //проверка выхода
    @Step("Click button Logout")
    public void clickLogOut() {
        waitForVisibilityElement(logout);
        driver.findElement(logout).click();
    }
}

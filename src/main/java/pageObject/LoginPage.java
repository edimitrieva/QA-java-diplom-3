package pageObject;

import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.core.StringEndsWith.endsWith;

public class LoginPage extends BaseClass {
    //Поле ввода почты пользователя
    private By emailSelector = By.xpath("//form[@class='Auth_form__3qKeq mb-20']/fieldset[1]//input");
    //Поле ввода пароля
    private By passwordSelector = By.xpath("//form[@class='Auth_form__3qKeq mb-20']/fieldset[2]//input");
    //Кнопка Войти
    private By loginSelector = By.xpath("//form[@class='Auth_form__3qKeq mb-20']//button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //заполняем поля в форме регистрации и нажимаем на кнопку Зарегистрироваться
    @Step("Login user")
    public void loginUser(String email, String password){
        driver.findElement(emailSelector).sendKeys(email);
        driver.findElement(passwordSelector).sendKeys(password);

        driver.findElement(loginSelector).click();
    }

    //проверка что открыта страница логина
    @Step("Check that login page is opened")
    public void checkOpenLoginPage(){
        waitForVisibilityElement(emailSelector);
        String url = driver.getCurrentUrl();
        MatcherAssert.assertThat(url, endsWith("/login"));
    }

}

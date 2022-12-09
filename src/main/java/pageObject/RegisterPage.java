package pageObject;

import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.core.StringEndsWith.endsWith;

public class RegisterPage extends BaseClass {
    //Поле ввода имени пользователя
    private By nameSelector = By.xpath("//form[@class='Auth_form__3qKeq mb-20']/fieldset[1]//input");
    //Поле ввода почты пользователя
    private By emailSelector = By.xpath("//form[@class='Auth_form__3qKeq mb-20']/fieldset[2]//input");
    //Поле ввода пароля
    private By passwordSelector = By.xpath("//form[@class='Auth_form__3qKeq mb-20']/fieldset[3]//input");
    //Кнопка Зарегистрироваться
    private By registerSelector = By.xpath("//form[@class='Auth_form__3qKeq mb-20']//button");
    //Ошибка ввода пароля
    private By errorPassword = By.className("input__error");
    //Кнопка Войти
    private By login = By.cssSelector("a.Auth_link__1fOlj");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    //заполняем поля в форме регистрации и нажимаем на кнопку Зарегистрироваться
    @Step("Register user")
    public void registerUser(String name, String email, String password) {
        waitForVisibilityElement(nameSelector);
        driver.findElement(nameSelector).sendKeys(name);
        driver.findElement(emailSelector).sendKeys(email);
        driver.findElement(passwordSelector).sendKeys(password);
        System.out.println("Register user " + email);

        driver.findElement(registerSelector).click();
    }

    //проверяем ошибку ввода пароля
    @Step("Check that password is wrong")
    public void checkErrorPassword() {
        waitForVisibilityElement(errorPassword);
        String url = driver.getCurrentUrl();
        MatcherAssert.assertThat(url, endsWith("/register"));
        Assert.assertEquals("Некорректный пароль", driver.findElement(errorPassword).getText());
    }

    //проверка что открылась страница логина
    @Step("Check that login page is opened")
    public void checkUserRegister() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(passwordSelector));
        String url = driver.getCurrentUrl();
        MatcherAssert.assertThat(url, endsWith("/login"));
    }

    //Нажимаем на ссылку Войти
    @Step("Click link Login on page")
    public void clickLogin() {
        waitForVisibilityElement(login);
        driver.findElement(login).click();
    }
}

import API.UserClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import pageObject.Header;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.RegisterPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static constants.Constants.*;

@DisplayName("Login")
public class LoginUserTest extends BaseTest {
    LoginPage onjLoginPage;
    MainPage objMainPage;

    @Before
    public void setUp() {
        UserClient userClient = new UserClient();
        userClient.registerUser(userEmail, userPassword, userName);
        System.out.println("Зарегистрирован пользователь " + userEmail);

        objMainPage = new MainPage(driver);
        onjLoginPage = new LoginPage(driver);
    }

    //вход пользователь с главной страницы
    @Test
    @DisplayName("Login user")
    @Description("Login user when we click on button Login on main page")
    public void loginUserByButtonLogin() {
        driver.get(URL);

        objMainPage.clickButtonLogin();
        onjLoginPage.loginUser(userEmail, userPassword);
        objMainPage.checkAuthUserSuccess();
        objMainPage.checkOpenMainPage();
    }

    //вход пользователь через кнопку Личный кабинет
    @Test
    @DisplayName("Login user in header")
    @Description("Login user when we click on button Private cabinet on header")
    public void loginUserByButtonPrivateCabinet() {
        Header objHeader = new Header(driver);
        driver.get(URL);

        objHeader.clickButtonPrivateCabinet();
        onjLoginPage.loginUser(userEmail, userPassword);
        objMainPage.checkAuthUserSuccess();
        objMainPage.checkOpenMainPage();
    }

    //вход через форму регистрации
    @Test
    @DisplayName("Login user on register page")
    @Description("Login user when we click on button Login on register page")
    public void loginUserByButtonLoginOnRegisterPage() {
        RegisterPage objRegisterPage = new RegisterPage(driver);
        driver.get(URL + "/register");

        objRegisterPage.clickLogin();
        onjLoginPage.loginUser(userEmail, userPassword);
        objMainPage.checkAuthUserSuccess();
        objMainPage.checkOpenMainPage();
    }

    //вход через форму восстановления пароля
    @Test
    @DisplayName("Login user on forgot password page")
    @Description("Login user when we click on button Login on forgot password page")
    public void loginUserByButtonLoginOnForgotPasswordPage() {
        RegisterPage objRegisterPage = new RegisterPage(driver);
        driver.get(URL + "/forgot-password");
        objRegisterPage.clickLogin();
        onjLoginPage.loginUser(userEmail, userPassword);
        objMainPage.checkAuthUserSuccess();
        objMainPage.checkOpenMainPage();
    }

    @After
    public void teardown() {
        driver.quit();
        UserClient userClient = new UserClient();
        userClient.deleteUser(userEmail, userPassword);
    }
}

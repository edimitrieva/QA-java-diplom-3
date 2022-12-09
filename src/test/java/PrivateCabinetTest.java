import API.UserClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import pageObject.Header;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.PrivateCabinet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static constants.Constants.*;

@DisplayName("Private cabinet")
public class PrivateCabinetTest extends BaseTest {
    Header objHeader;
    LoginPage objLogin;

    @Before
    public void setUp() {
        UserClient userClient = new UserClient();
        userClient.registerUser(userEmail, userPassword, userName);
        System.out.println("Зарегистрирован пользователь " + userEmail);
        objHeader = new Header(driver);
        objLogin = new LoginPage(driver);
        driver.get(URL);

        objHeader.clickButtonPrivateCabinet();
        objLogin.loginUser(userEmail, userPassword);
    }

    //Переход в личный кабинет
    @Test
    @DisplayName("Go to private cabinet")
    @Description("Go to private cabinet from main page")
    public void checkGotoPrivateCabinet() {
        PrivateCabinet objPrivateCabinet = new PrivateCabinet(driver);

        objHeader.clickButtonPrivateCabinet();
        objPrivateCabinet.checkOpenPrivateCabinet();
    }

    //переход из личного кабинета в конструктор после нажатия на ссылку Конструктор в заголовке
    @Test
    @DisplayName("Go to constructor")
    @Description("Go to constructor from private cabinet")
    public void checkClickConstructorFromPrivateCabinet() {
        MainPage objMainPage = new MainPage(driver);

        objHeader.clickButtonPrivateCabinet();
        objHeader.clickButtonConstructor();
        objMainPage.checkOpenMainPage();
    }

    //переход из личного кабинета в конструктор после нажатия на ссылку Stellar Burger в заголовке
    @Test
    @DisplayName("Go to main page")
    @Description("Click to logo Stellar Burger. Go to main page from private cabinet.")
    public void checkClickStellarBurgerFromPrivateCabinet() {
        MainPage objMainPage = new MainPage(driver);

        objHeader.clickButtonPrivateCabinet();
        objHeader.clickButtonStellarBurger();
        objMainPage.checkOpenMainPage();
    }

    //выход из аккаунта
    @Test
    @DisplayName("Log out")
    @Description("Log out on private cabinet page")
    public void logOut() {
        PrivateCabinet objPrivateCabinet = new PrivateCabinet(driver);
        LoginPage objLogin = new LoginPage(driver);

        objHeader.clickButtonPrivateCabinet();
        objPrivateCabinet.clickLogOut();
        objLogin.checkOpenLoginPage();
    }

    @After
    public void teardown() {
        driver.quit();
        UserClient userClient = new UserClient();
        userClient.deleteUser(userEmail, userPassword);
    }
}

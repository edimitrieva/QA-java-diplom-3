import API.UserClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import pageObject.RegisterPage;
import org.junit.After;
import org.junit.Test;

import static constants.Constants.*;

@DisplayName("Register")
public class RegisterUserTest extends BaseTest {
    //Проверка успешной регистрации пользователя
    @DisplayName("Register User")
    @Description("Register user is success")
    @Test
    public void checkRegisterUserSuccess() {
        RegisterPage objRegister = new RegisterPage(driver);
        driver.get(URL + "/register");

        objRegister.registerUser(userName, userEmail, userPassword);
        objRegister.checkUserRegister();

        //удаление пользователя
        UserClient userClient = new UserClient();
        userClient.deleteUser(userEmail, userPassword);
    }

    //проверка ошибки при вводе некорректного паролля
    @Test
    @DisplayName("Register User with wrong password")
    @Description("Register user. Check error about wrong password")
    public void checkRegisterWrongPassword() {
        RegisterPage objRegister = new RegisterPage(driver);
        driver.get(URL + "/register");

        objRegister.registerUser(userName, userEmail, "12345");
        objRegister.checkErrorPassword();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

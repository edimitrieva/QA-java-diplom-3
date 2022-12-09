import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import pageObject.MainPage;
import org.junit.After;
import org.junit.Test;

import static constants.Constants.*;

@DisplayName("Constructor")
public class ConstructorTest extends BaseTest{

    //проверка переключения на вкладку Соус
    @Test
    @DisplayName("Active tab sauces")
    @Description("Check that active tab sauce")
    public void checkActiveTabSauces() throws InterruptedException {
        MainPage objMainPage = new MainPage(driver);
        driver.get(URL);

        objMainPage.clickTabSauces();
        objMainPage.checkActiveTabSauce();
    }

    //проверка переключения на вкладку Начинки
    @Test
    @DisplayName("Active tab fillings")
    @Description("Check that active tab fillings")
    public void checkActiveTabFillings() throws InterruptedException {
        MainPage objMainPage = new MainPage(driver);
        driver.get(URL);

        objMainPage.clickTabFillings();
        objMainPage.checkActiveTabFilling();
    }


    //проверка переключения на вкладку Булки
    @Test
    @DisplayName("Active tab buns")
    @Description("Check that active tab buns")
    public void checkActiveTabBuns() throws InterruptedException {
        MainPage objMainPage = new MainPage(driver);
        driver.get(URL);

        objMainPage.clickTabFillings();
        objMainPage.clickTabBuns();
        objMainPage.checkActiveTabBuns();
    }


    @After
    public void teardown(){
        driver.quit();
    }
}

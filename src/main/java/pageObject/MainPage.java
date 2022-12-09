package pageObject;

import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static constants.Constants.URL;
import static java.lang.Thread.sleep;
import static org.hamcrest.core.StringContains.containsString;

public class MainPage extends BaseClass {
    //Кнопка Войти в аккаунт
    private By login = By.cssSelector("button.button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_large__G21Vg");
    //Заголовок
    private By title = By.cssSelector("h1.text.text_type_main-large.mb-5.mt-10");
    //Меню Булки
    private By buns = By.xpath("//section[@class='BurgerIngredients_ingredients__1N8v2']/div[1]/div[1]");
    //Меню Соусы
    private By sauces = By.xpath("//section[@class='BurgerIngredients_ingredients__1N8v2']/div[1]/div[2]");
    //Меню Начинки
    private By fillings = By.xpath("//section[@class='BurgerIngredients_ingredients__1N8v2']/div[1]/div[3]");
    //Класс активной вкладки
    String activeTabClass = "tab_tab_type_current__2BEPc";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    //нажатие на кнопку Войти в аккаунт
    @Step("Click button Login on main page")
    public void clickButtonLogin() {
        waitForVisibilityElement(login);
        driver.findElement(login).click();
    }

    //проверика, что пользователь авторизован
    @Step("Check that user logged in success")
    public void checkAuthUserSuccess() {
        waitForVisibilityElement(login);
        Assert.assertEquals("Оформить заказ", driver.findElement(login).getText());
    }

    //проверика, что находимся на главной странице
    @Step("Check that main page is opened")
    public void checkOpenMainPage() {
        waitForVisibilityElement(title);
        String url = driver.getCurrentUrl();
        Assert.assertEquals(URL + "/", url);
        Assert.assertEquals("Соберите бургер", driver.findElement(title).getText());
    }

    //нажатие на кнопку Булки
    @Step("Click tab Buns")
    public void clickTabBuns() throws InterruptedException {
        waitForVisibilityElement(buns);
        driver.findElement(buns).click();
        sleep(3000);
    }

    //нажатие на кнопку Соусы
    @Step("Click tab Sauces")
    public void clickTabSauces() throws InterruptedException {
        waitForVisibilityElement(sauces);
        driver.findElement(sauces).click();
        sleep(3000);

    }

    //нажатие на кнопку Начинки
    @Step("Click tab Fillings")
    public void clickTabFillings() throws InterruptedException {
        waitForVisibilityElement(fillings);
        driver.findElement(fillings).click();
        sleep(3000);

    }

    //Ожидание, что в классе появился атрибут, который говорит об активности вкладки
    void waitForAttributeContains(By element) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.attributeContains(element, "class", activeTabClass));
    }

    //проверка что выбрана вкладка Соус
    @Step("Check that tab Souces is active")
    public void checkActiveTabSauce() {
        waitForAttributeContains(sauces);
        MatcherAssert.assertThat(driver.findElement(sauces).getAttribute("class"), containsString(activeTabClass));
    }

    //проверка что выбрана  вкладка Булки
    @Step("Check that tab Buns is active")
    public void checkActiveTabBuns() {
        waitForAttributeContains(buns);
        MatcherAssert.assertThat(driver.findElement(buns).getAttribute("class"), containsString(activeTabClass));
    }

    //проверка что выбрана вкладка Начинки
    @Step("Check that tab Filling is active")
    public void checkActiveTabFilling() {
        waitForAttributeContains(fillings);
        MatcherAssert.assertThat(driver.findElement(fillings).getAttribute("class"), containsString(activeTabClass));
    }
}

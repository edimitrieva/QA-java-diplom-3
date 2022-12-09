package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends BaseClass {
    //Кнопка Личный кабинет
    private By privateCabinet = By.cssSelector("nav.AppHeader_header__nav__g5hnF > a");
    //Кнопка Конструктор
    private By buttonConstructor = By.xpath("//nav[@class='AppHeader_header__nav__g5hnF']//li[1]/a");
    //Кнопка Stellar Burger
    private By buttonStellarBurger = By.xpath("//nav[@class='AppHeader_header__nav__g5hnF']/div/a");

    public Header(WebDriver driver) {
        super(driver);
    }

    //нажатие на кнопку Личный кабинет
    @Step("Click button Private cabinet on header")
    public void clickButtonPrivateCabinet() {
        waitForVisibilityElement(privateCabinet);
        driver.findElement(privateCabinet).click();
    }

    //нажатие на кнопку Конструктор
    @Step("Click button Constructor on header")
    public void clickButtonConstructor() {
        waitForVisibilityElement(buttonConstructor);
        driver.findElement(buttonConstructor).click();
    }

    //нажатие на кнопку Stellar Burger
    @Step("Click button Stellar Burger on header")
    public void clickButtonStellarBurger() {
        waitForVisibilityElement(buttonStellarBurger);
        driver.findElement(buttonStellarBurger).click();
    }
}

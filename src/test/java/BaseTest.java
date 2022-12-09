import API.UserClient;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static constants.Constants.userEmail;
import static constants.Constants.userPassword;

//Базовый класс настройки браузера
public class BaseTest {
    WebDriver driver;

    @Before
    public void StartBrowser(){
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        /*
        //Настройки для запуска теста в Яндекс.Браузере
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        options.setBinary("C:\\Users\\1\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\new_browser.exe");
        */
        driver = new ChromeDriver(options);
    }


}

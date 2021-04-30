package factory;

import enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {


    protected static RemoteWebDriver driver = null;

    protected static void createDriver() {

        String browserType = System.getProperty("browserType").toUpperCase();
        System.out.println(browserType);
        BrowserType browser = BrowserType.valueOf(browserType);

        if (driver == null) {
            switch (browser) {
                case CHROME:
                    ChromeOptions chrome = new ChromeOptions();
                    WebDriverManager.chromedriver().setup();
                    chrome.addArguments("--disable-notifications");
                    driver = new ChromeDriver(chrome);
                    break;
                case IE:
                    //...
                    break;
                case FIREFOX:
                    //...
                    break;
                default:
                    //...
                    break;
            }
        }
        else
        {
            ChromeOptions chrome = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            chrome.addArguments("--disable-notifications");
            driver = new ChromeDriver(chrome);
        }

        driver.manage().window().maximize();
    }

    protected static RemoteWebDriver getDriver() {
        return driver;
    }
}

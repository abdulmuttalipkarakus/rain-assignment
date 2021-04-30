package scenario.page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import scenario.base.BasePage;

public class AccountsPage extends BasePage {

    public AccountsPage(RemoteWebDriver driver) {

        super(driver);
    }

    public boolean isCryptoExist(String crypto) {

        String xpath = "(//*[contains(text(), '" + crypto + "')])[1]";
        return isElementExist(By.xpath(xpath));
    }
}

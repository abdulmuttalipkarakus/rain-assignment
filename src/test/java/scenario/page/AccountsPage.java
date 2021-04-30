package scenario.page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import scenario.base.BasePage;

public class AccountsPage extends BasePage {

    private static final By BUY_FIAT_AMOUNT_INPUT = By.id("buy_fiat_amount");
    private static final By SELL_FIAT_AMOUNT_INPUT = By.id("sell_fiat_amount");
    private static final By CONTINUE_BUTTON = By.cssSelector("[value='Continue']");
    private static final By CONFIRM_BUTTON = By.cssSelector("[value='Confirm']");
    private static final By SUBMIT_BUTTON = By.cssSelector("[value='Submit']");
    private static final By BOUGHT_BITCOIN_TEXT = By.xpath("//*[text()='Bought Bitcoin']");

    public AccountsPage(RemoteWebDriver driver) {

        super(driver);
    }

    public boolean isCryptoExist(String crypto) {

        String xpath = "(//*[contains(text(), '" + crypto + "')])[1]";
        return isElementExist(By.xpath(xpath));
    }
}

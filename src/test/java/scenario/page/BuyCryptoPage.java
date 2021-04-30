package scenario.page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import scenario.base.BasePage;

public class BuyCryptoPage extends BasePage {

    private static final By BUY_FIAT_AMOUNT_INPUT = By.id("buy_fiat_amount");
    private static final By CONTINUE_BUTTON = By.cssSelector("[value='Continue']");
    private static final By CONFIRM_BUTTON = By.cssSelector("[value='Confirm']");
    private static final By SUBMIT_BUTTON = By.cssSelector("[value='Submit']");
    private static final By BOUGHT_BITCOIN_TEXT = By.xpath("//*[text()='Bought Bitcoin']");

    public BuyCryptoPage(RemoteWebDriver driver) {

        super(driver);
    }

    public BuyCryptoPage typeBuyAmount(String amount) {

        fillInputField(BUY_FIAT_AMOUNT_INPUT, amount, false);
        return this;
    }

    public BuyCryptoPage clickContinueButton() {

        clickElement(CONTINUE_BUTTON);
        return this;
    }

    public BuyCryptoPage clickConfirmButton() {

        clickElement(CONFIRM_BUTTON);
        return this;
    }

    public BuyCryptoPage clickSubmitButton() {

        if (isElementExist(SUBMIT_BUTTON))
        clickElement(SUBMIT_BUTTON);
        return this;
    }

    public boolean isBoughtBitcoinTextExist() {

        return isElementExist(BOUGHT_BITCOIN_TEXT);
    }
}

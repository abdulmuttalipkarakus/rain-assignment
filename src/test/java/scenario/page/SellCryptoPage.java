package scenario.page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import scenario.base.BasePage;

public class SellCryptoPage extends BasePage {

    private static final By SELL_FIAT_AMOUNT_INPUT = By.id("sell_fiat_amount");
    private static final By CONTINUE_BUTTON = By.cssSelector("[value='Continue']");
    private static final By CONFIRM_BUTTON = By.cssSelector("[value='Confirm']");
    private static final By SUBMIT_BUTTON = By.cssSelector("[value='Submit']");
    private static final By SOLD_BITCOIN_TEXT = By.xpath("//*[text()='Sold Bitcoin']");

    public SellCryptoPage(RemoteWebDriver driver) {

        super(driver);
    }

    public SellCryptoPage typeSellAmount(String amount) {

        fillInputField(SELL_FIAT_AMOUNT_INPUT, amount, false);
        return this;
    }

    public SellCryptoPage clickContinueButton() {

        clickElement(CONTINUE_BUTTON);
        return this;
    }

    public SellCryptoPage clickConfirmButton() {

        clickElement(CONFIRM_BUTTON);
        return this;
    }

    public SellCryptoPage clickSubmitButton() {

        if (isElementExist(SUBMIT_BUTTON))
        clickElement(SUBMIT_BUTTON);
        return this;
    }

    public boolean isSoldBitcoinTextExist() {

        return isElementExist(SOLD_BITCOIN_TEXT);
    }
}

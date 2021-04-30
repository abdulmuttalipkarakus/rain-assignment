package scenario.page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import scenario.base.BasePage;

public class MainPage extends BasePage {

    private static final By SIGN_IN_BUTTON = By.xpath("(//*[text()='Sign in'])[1]");
    private static final By USER_PROFILE_BUTTON = By.cssSelector("[class*=brokerage-header-profile-link]");
    private static final By SIGN_OUT_BUTTON = By.xpath("(//*[text()='Sign out'])[2]");
    private static final By BUY_BUTTON = By.xpath("//*[text()='Buy']");
    private static final By SELL_BUTTON = By.xpath("//*[text()='Sell']");
    private static final By ACCOUNTS_BUTTON = By.xpath("//*[text()='Accounts']");

    public MainPage(RemoteWebDriver driver) {

        super(driver);
    }

    public SignUpInPage clickSignInButton() {

        clickElement(SIGN_IN_BUTTON);
        return new SignUpInPage(driver);
    }

    public MainPage clickUserProfileButton() {

        hoverElement(USER_PROFILE_BUTTON);
        return this;
    }

    public BuyCryptoPage clickBuyButton() {

        clickElement(BUY_BUTTON);
        return new BuyCryptoPage(driver);
    }

    public SellCryptoPage clickSellButton() {

        clickElement(SELL_BUTTON);
        return new SellCryptoPage(driver);
    }

    public SellCryptoPage clickAccountsButton() {

        clickElement(ACCOUNTS_BUTTON);
        return new SellCryptoPage(driver);
    }

    public MainPage clickSignOutButton() {

        clickElement(SIGN_OUT_BUTTON);
        return this;
    }

    public boolean isSignInButtonExist() {

        return isElementExist(SIGN_IN_BUTTON);
    }

    public boolean isUserProfileExist() {

        return isElementExist(USER_PROFILE_BUTTON);
    }

    public MainPage waitUntilGivenTime(int second) throws InterruptedException {

        Thread.sleep(second * 1000L);
        return this;
    }
}

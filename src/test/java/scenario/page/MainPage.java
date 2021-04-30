package scenario.page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import scenario.base.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainPage extends BasePage {

    private static final By GIRIS_YAP_BUTTON = By.className("btnSignIn");
    private static final By USER_MENU_DROPDOWN = By.cssSelector("[class*=user]");
    private static final By COSMETIC_AND_PERSONAL_CARE_BUTTON = By.cssSelector(".catMenuItem > [title='Kozmetik & Kişisel Bakım']");
    private static final By PERFUME_AND_DEODORANT_BUTTON = By.cssSelector(".mainCat > [title='Parfüm & Deodorant']");
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

    public MainPage switchToTab(int tabIndex) {

        switchTab(tabIndex);
        return this;
    }

    public String getn11UserName() {

        return getTextOfElement(USER_MENU_DROPDOWN);
    }

    public MainPage waitUntilGivenTime(int second) throws InterruptedException {

        Thread.sleep(second * 1000L);
        return this;
    }

    public String getUrlFromText(String text, int index) {

        List<String> urls = new ArrayList<>();

        String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
        Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
        Matcher urlMatcher = pattern.matcher(text);

        while (urlMatcher.find()) {

            urls.add(text.substring(urlMatcher.start(0), urlMatcher.end(0)));
        }

        return urls.get(index);
    }
}

package scenario.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import scenario.base.BaseTest;
import scenario.page.AccountsPage;
import scenario.page.MainPage;

import java.util.Arrays;
import static key.Keys.*;

public class AccountsTest extends BaseTest {

    private static MainPage mainPage;
    private static AccountsPage accountsPage;

    @BeforeClass
    public void before() {

        mainPage = new MainPage(getDriver());
        accountsPage = new AccountsPage(getDriver());

       mainPage.clickAccountsButton();
    }

    @Test(description = "Check all crypto kind exist")
    public void checkCryptoTest() {

        Arrays.asList(BTC_ACCOUNT, ETH_ACCOUNT, LTC_ACCOUNT, XRP_ACCOUNT, BHD_ACCOUNT, USD_ACCOUNT
        ).forEach(crypto -> Assert.assertTrue(accountsPage.isCryptoExist(crypto)));
    }
}

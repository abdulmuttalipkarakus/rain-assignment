package scenario.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import scenario.base.BaseTest;
import scenario.page.AccountsPage;
import scenario.page.MainPage;

import java.util.Arrays;

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

        Arrays.asList("BTC Account", "ETH Account", "LTC Account", "XRP Account", "BHD Account", "USD Account"
        ).forEach(crypto -> Assert.assertTrue(accountsPage.isCryptoExist(crypto)));
    }
}

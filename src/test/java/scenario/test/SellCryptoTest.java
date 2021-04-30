package scenario.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import scenario.base.BaseTest;
import scenario.page.MainPage;
import scenario.page.SellCryptoPage;

public class SellCryptoTest extends BaseTest {

    private static MainPage mainPage;
    private static SellCryptoPage sellCryptoPage;

    @BeforeClass
    public void before() {

        mainPage = new MainPage(getDriver());
        sellCryptoPage = new SellCryptoPage(getDriver());

        mainPage.clickSellButton();
    }

    @Test(priority = 1, description = "Sell crypto process")
    public void sellCryptoTest() {

        sellCryptoPage.typeSellAmount("15")
                .clickContinueButton()
                .clickConfirmButton()
                .clickSubmitButton();

        Assert.assertTrue(sellCryptoPage.isSoldBitcoinTextExist());
    }
}

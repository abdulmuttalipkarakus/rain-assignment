package scenario.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import scenario.base.BaseTest;
import scenario.page.BuyCryptoPage;
import scenario.page.MainPage;

public class BuyCryptoTest extends BaseTest {

    private static MainPage mainPage;
    private static BuyCryptoPage buyCryptoPage;

    @BeforeClass
    public void before() {

        mainPage = new MainPage(getDriver());
        buyCryptoPage = new BuyCryptoPage(getDriver());

        mainPage.clickBuyButton();
    }

    @Test(description = "Buy crypto process")
    public void buyCryptoTest() {

        buyCryptoPage.typeBuyAmount("15")
                .clickContinueButton()
                .clickConfirmButton()
                .clickSubmitButton();

        Assert.assertTrue(buyCryptoPage.isBoughtBitcoinTextExist());
    }
}

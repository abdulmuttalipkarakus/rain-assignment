package scenario.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import scenario.base.BaseTest;
import scenario.page.MainPage;

public class UserProfileTest extends BaseTest {

    private static MainPage mainPage;

    @BeforeClass
    public void before() {

        mainPage = new MainPage(getDriver());
    }

    @Test(description = "Check sign out process")
    public void signOutTest() {

        mainPage.clickUserProfileButton()
                .clickSignOutButton();

        Assert.assertTrue(mainPage.isSignInButtonExist());
    }
}

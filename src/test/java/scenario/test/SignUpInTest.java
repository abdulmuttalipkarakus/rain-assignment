package scenario.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import scenario.base.BaseTest;
import scenario.page.SignUpInPage;
import scenario.page.MainPage;

import javax.mail.Message;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static key.Keys.*;

public class SignUpInTest extends BaseTest {

    private static MainPage mainPage;
    private static SignUpInPage signUpPage;

    @BeforeClass
    public void before() {

        mainPage = new MainPage(getDriver());
        signUpPage = new SignUpInPage(getDriver());
    }

    @Test(description = "Check sign up process")
    public void signUpTest() throws Exception {

        final String SUBJECT = "Verify E-mail";
        final String FROM = "Rain Support <support@rain.bh>";
        final String USER_EMAIL = config.getUserEmail();
        final String USER_APP_PASSWORD = config.getUserEmailPassword();
        String emailVerificationLink = null;

        signUpPage.typeFirstName(config.getRainUserFirstName())
                .typeLastName(config.getRainUserLastName())
                .typeSignUpEmail(rainEmail)
                .typeSignUpPassword(config.getRainUserPassword());

        mainPage.waitUntilGivenTime(3);
        signUpPage.clickSubmitButton();

        Date nowTime = Calendar.getInstance().getTime();
        mainPage.waitUntilGivenTime(15);

        Message[] messages = javaMailApi.getInboxMessages(USER_EMAIL, USER_APP_PASSWORD);
        boolean isMessageExist = false;
        System.out.println(Arrays.toString(messages));

        for (Message message : messages) {

            if (SUBJECT.equalsIgnoreCase(message.getSubject()) && message.getSentDate().after(nowTime)) {

                List text = javaMailApi.getTextFromMessage(message);
                System.out.println("mail links -> " + text);
                System.out.println("verification link -> " + text.get(0).toString());
                emailVerificationLink = text.get(0).toString();
                Assert.assertEquals((message.getFrom()[0]).toString(), FROM);

                isMessageExist = true;
            }
        }

        Assert.assertTrue(isMessageExist);

        getDriver().get(emailVerificationLink);

        signUpPage.selectCounty(UNITED_STATED)
                .typePhoneNumber(config.getUserPhoneNumber())
                .clickSubmitButton();

        mainPage.waitUntilGivenTime(3);
        String mobileVerificationCode = readMessage.getSMS().split(": ")[1];
        System.out.println(mobileVerificationCode);

        signUpPage.typeMobileVerCode(mobileVerificationCode)
                .clickContinueButton()
                .selectResidency(BAHRAIN)
                .selectNationality(BAHRAIN)
                .clickContinueButton()
                .clickContinueButton();

        for (int i = 0; i < 15; i++) {

            if (signUpPage.isProvideLaterButtonExist()) {

                signUpPage.clickProvideLaterButton()
                        .clickProvideLaterButton();
            } else break;
        }

        Assert.assertTrue(mainPage.isUserProfileExist());
    }

    @Test(description = "Check sign in process")
    public void signInTest() {

        mainPage.clickSignInButton()
                .typeSignInEmail(config.getRainUser2Email())
                .typeSignInPassword(config.getRainUser2Password())
                .clickSignInButton();

        Assert.assertTrue(mainPage.isUserProfileExist());
    }
}

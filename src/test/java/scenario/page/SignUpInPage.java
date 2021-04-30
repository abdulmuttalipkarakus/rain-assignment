package scenario.page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import scenario.base.BasePage;

public class SignUpInPage extends BasePage {

    private static final By FIRST_NAME_INPUT = By.id("first-name");
    private static final By LAST_NAME_INPUT = By.id("last-name");
    private static final By SIGN_UP_EMAIL_INPUT = By.id("email");
    private static final By SIGN_UP_PASSWORD_INPUT = By.id("password");
    private static final By SUBMIT_BUTTON = By.cssSelector("[type='submit']");
    private static final By COUNTRY_LIST = By.cssSelector("[aria-autocomplete='list']");
    private static final By COUNTRY_LIST_BOX = By.cssSelector("[role='listbox']");
    private static final By PHONE_NUMBER_INPUT = By.id("phone-number");
    private static final By MOBILE_VER_CODE_INPUT = By.id("verification-code");
    private static final By CONTINUE_BUTTON = By.xpath("//*[text()='Continue']");
    private static final By RESIDENCY_COUNTRY_LIST = By.xpath("(//*[@aria-autocomplete='list'])[1]");
    private static final By NATIONALITY_COUNTRY_LIST = By.xpath("(//*[@aria-autocomplete='list'])[2]");
    private static final By SIGN_IN_EMAIL_INPUT = By.cssSelector("[type='email']");
    private static final By SIGN_IN_PASSWORD_INPUT = By.cssSelector("[type='password']");
    private static final By SIGN_IN_BUTTON = By.xpath("//*[text()='Sign in']");
    private static final By PROVIDE_LATER_BUTTON = By.xpath("(//*[contains(text(), 'later')])[1]");

    public SignUpInPage(RemoteWebDriver driver) {

        super(driver);
    }

    public SignUpInPage typeFirstName(String firstName) {

        fillInputField(FIRST_NAME_INPUT, firstName, false);
        return this;
    }

    public SignUpInPage typeLastName(String lastName) {

        fillInputField(LAST_NAME_INPUT, lastName, false);
        return this;
    }

    public SignUpInPage typeSignUpEmail(String email) {

        fillInputField(SIGN_UP_EMAIL_INPUT, email, false);
        return this;
    }

    public SignUpInPage typeSignUpPassword(String password) {

        fillInputField(SIGN_UP_PASSWORD_INPUT, password, false);
        return this;
    }

    public SignUpInPage typeSignInEmail(String email) {

        fillInputField(SIGN_IN_EMAIL_INPUT, email, false);
        return this;
    }

    public SignUpInPage typeSignInPassword(String password) {

        fillInputField(SIGN_IN_PASSWORD_INPUT, password, false);
        return this;
    }

    public SignUpInPage clickSubmitButton() {

        clickElement(SUBMIT_BUTTON);
        return this;
    }

    public SignUpInPage clickContinueButton() {

        clickElement(CONTINUE_BUTTON);
        return this;
    }

    public SignUpInPage clickProvideLaterButton() {

        clickElement(PROVIDE_LATER_BUTTON);
        return this;
    }

    public boolean isProvideLaterButtonExist() {

        return isElementExist(PROVIDE_LATER_BUTTON);
    }

    public SignUpInPage selectCounty(String country) {

        clickElement(COUNTRY_LIST);
        fillInputField(COUNTRY_LIST, country, false);
        String xpath = "//*[text()='" + country + "']";
        clickElement(By.xpath(xpath));
        return this;
    }

    public SignUpInPage typePhoneNumber(String phoneNumber) {

        fillInputField(PHONE_NUMBER_INPUT, phoneNumber, false);
        return this;
    }

    public SignUpInPage typeMobileVerCode(String code) {

        fillInputField(MOBILE_VER_CODE_INPUT, code, false);
        return this;
    }

    public SignUpInPage selectResidency(String country) {

        clickElement(RESIDENCY_COUNTRY_LIST);
        fillInputField(RESIDENCY_COUNTRY_LIST, country, false);
        String xpath = "//*[text()='" + country + "']";
        clickElement(By.xpath(xpath));
        return this;
    }

    public SignUpInPage selectNationality(String country) {

        clickElement(NATIONALITY_COUNTRY_LIST);
        fillInputField(NATIONALITY_COUNTRY_LIST, country, false);
        String xpath = "//*[text()='" + country + "']";
        clickElement(By.xpath(xpath));
        return this;
    }

    public SignUpInPage clickSignInButton() {

        clickElement(SIGN_IN_BUTTON);
        return new SignUpInPage(driver);
    }
}

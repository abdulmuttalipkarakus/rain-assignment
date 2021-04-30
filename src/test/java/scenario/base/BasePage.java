package scenario.base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    protected static final int DEFAULT_WAIT = 10;
    protected RemoteWebDriver driver;
    protected WebDriverWait wait;

    public BasePage(RemoteWebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, DEFAULT_WAIT);
    }

    protected WebElement findElement(By by, int... index) {

        waitUntilElementAppears(by);
        return index.length == 0
                ? driver.findElement(by)
                : driver.findElements(by).get(index[0]);
    }

    protected List<WebElement> findElements(By by) {

        return driver.findElements(by);
    }

    protected void clickElement(By by, int... index) {

        waitUntilElementClickable(by);

        WebElement element = index.length == 0
                ? findElement(by)
                : findElement(by, index[0]);

        highlightElement(element);
        element.click();
    }

    protected void fillInputField(By by, String text, boolean pressEnter) {

        waitUntilElementClickable(by);
        WebElement element = findElement(by);

        highlightElement(element);
        clearElementField(by);
        element.sendKeys(text);

        if (pressEnter) element.sendKeys(Keys.ENTER);
    }

    protected void clearElementField(By by) {

        WebElement element = findElement(by);
        element.click();
        element.clear();
    }

    protected void waitUntilElementAppears(By by) { wait.until(ExpectedConditions.visibilityOfElementLocated(by)); }

    protected void waitUntilElementClickable(By by) {
        wait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    protected boolean isElementExist(By by) {

        try {

            waitUntilElementAppears(by);
            return findElements(by).size() == 1;
        } catch (TimeoutException e) {

            return false;
        }
    }

    protected void highlightElement(WebElement element) {

        JavascriptExecutor js = driver;
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
                "color: red; border: 1px dashed red;");
    }

    protected void hoverElement(By by) {

        WebElement element = findElement(by);
        new Actions(driver).moveToElement(element).perform();
    }
}

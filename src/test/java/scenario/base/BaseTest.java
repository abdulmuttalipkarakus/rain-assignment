package scenario.base;

import api.JavaMailApi;
import api.ReadMessage;
import factory.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import util.Configuration;

import java.util.logging.Logger;

public class BaseTest extends DriverFactory {

    protected static final Configuration config = Configuration.getInstance();
    protected static Logger logger = Logger.getLogger(BaseTest.class.getName());
    protected static JavaMailApi javaMailApi = JavaMailApi.getInstance();
    protected static ReadMessage readMessage = ReadMessage.getInstance();
    private String generatedString = RandomStringUtils.random(5, true, true);
    protected static String rainEmail;

    @BeforeSuite(alwaysRun = true)
    public void setUp(ITestContext context) {

        String suiteName = context.getCurrentXmlTest().getSuite().getName();
        logger.info("BeforeSuite is started for " + suiteName);

        rainEmail = config.getRainUserEmail().split("@")[0] + "+" + generatedString + "@" + config.getRainUserEmail().split("@")[1];

        System.out.println("rainEmail-> " + rainEmail);
        createDriver();

        if (suiteName.equalsIgnoreCase("SignUp Test Suite")) getDriver().get(config.getRainSignUpBaseUrl());
        else   getDriver().get(config.getRainBaseUrl());
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(ITestContext context) {

//        getDriver().quit();
    }
}

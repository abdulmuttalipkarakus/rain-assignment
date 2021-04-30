package listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.logging.Logger;

public class TestListener implements ITestListener {

    private static Logger logger = Logger.getLogger(TestListener.class.getName());

    @Override
    public void onTestStart(ITestResult iTestResult) {
        logger.info(getTestMethodName(iTestResult) + " is started.");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logger.info("Test result is SUCCESS" + "\n============================");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logger.info("Test result is FAILURE" + "\n============================");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logger.info("Test result is SKIPPED" + "\n============================");
    }

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
}

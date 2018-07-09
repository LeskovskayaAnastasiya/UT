package app.listeners;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.util.Arrays;
import java.util.logging.Logger;

public class LoggerTestListenerAdapter extends TestListenerAdapter {

    private static Logger logger = Logger.getLogger("InfoLogging");

    @Override
    public void onTestFailure(ITestResult tr) {
        logger.warning("Test " + tr.getName()  + " with parameters " + Arrays.toString(tr.getParameters()) +  " - FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        logger.info("Test " + tr.getName()  + " with parameters " + Arrays.toString(tr.getParameters()) +  " - SKIPPED");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        logger.info("Test " + tr.getName() + " with parameters " + Arrays.toString(tr.getParameters()) + " - SUCCEED");
    }
}


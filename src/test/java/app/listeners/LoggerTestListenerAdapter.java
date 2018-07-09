package app.listeners;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.util.logging.Logger;

public class LoggerTestListenerAdapter extends TestListenerAdapter {

    private static Logger logger = Logger.getLogger("InfoLogging");

    @Override
    public void onTestFailure(ITestResult tr) {
        logger.warning(tr.getName() + " - FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        logger.info(tr.getName() + " - SKIPPED");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        logger.info(tr.getName() + " - SUCCEED");
    }
}


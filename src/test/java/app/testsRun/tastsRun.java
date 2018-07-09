package app.testsRun;

import app.listeners.LoggerTestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;
import java.util.List;

public class tastsRun {
    public static void main(String[] args) {
        LoggerTestListenerAdapter triangleMethodsTestsLogger = new LoggerTestListenerAdapter();
        TestNG testNg = new TestNG();
        XmlSuite customSuite = new XmlSuite();
        customSuite.setName("CustomSiute");
        customSuite.setParallel(XmlSuite.ParallelMode.METHODS);
        customSuite.setThreadCount(4);
        List<String> files = new ArrayList();
        files.addAll(new ArrayList<String>() {
            {
                this.add("appClientModule/com/epam/tat/unittest/testrunners/CalculatorMethodsTestingParallel.xml");
            }
        });
        customSuite.setSuiteFiles(files);
        List<XmlSuite> suites = new ArrayList();
        suites.add(customSuite);
        testNg.setXmlSuites(suites);
        testNg.addListener(triangleMethodsTestsLogger);
        testNg.run();
    }
}

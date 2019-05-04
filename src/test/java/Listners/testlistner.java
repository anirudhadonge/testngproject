package Listners;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class testlistner implements ITestListener,IReporter,IInvokedMethodListener,ISuiteListener   {
	String log4jConfPath = System.getProperty("user.dir")+"/log4j.properties";
	String extentReportHtmlReport = System.getProperty("user.dir")+"/extenthtmlReport.html";
	private static Logger log = Logger.getLogger(testlistner.class);
	ExtentReports extentReport ;
	ExtentTest extentTest;
	LogStatus logStatus;
	public testlistner() {
		PropertyConfigurator.configure(log4jConfPath);
		extentReport = new ExtentReports(extentReportHtmlReport, true);
		extentReport.addSystemInfo("OS", "Windows 10");
		
	}

	@Override
	public void onFinish(ITestContext testscenario) {

		
	}

	@Override
	public void onStart(ITestContext testContext) {
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		log.info("testname");
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		extentTest.log(LogStatus.FAIL, arg0.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {

		extentTest.log(LogStatus.SKIP, arg0.getThrowable());
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		log.info("testname");
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		extentTest.log(LogStatus.PASS, arg0.getThrowable());
		
	}

	@Override
	public void generateReport(List<XmlSuite> arg0, List<ISuite> arg1, String arg2) {

		
	}

	@Override
	public void afterInvocation(IInvokedMethod testContext, ITestResult testResult) {

		//extentTest.getTest().e

		
	}

	@Override
	public void beforeInvocation(IInvokedMethod testContext, ITestResult arg1) {
		extentTest = extentReport.startTest(testContext.getTestMethod().getMethodName());
		
	}

	@Override
	public void onFinish(ISuite arg0) {
		log.info("This method is invoked after the execution is done");
		//extentReport.close();
		//extentReport.flush();
	}

	@Override
	public void onStart(ISuite arg0) {
		log.info("This method is invoked before the suite is getting executed");

		
	}

}

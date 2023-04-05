package com.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
	ExtentReports reports;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = reports.createTest(methodName);
		Reporter.log(methodName + "-----> TestScript Execution Started");

	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+" -----> Passed");
		Reporter.log("TestScript Execution is successfull", true);
	}

	public void onTestFailure(ITestResult result) {
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		String filePath="./errorshots/" + result.getMethod().getMethodName()
				+ LocalDateTime.now().toString().replace(':', '-') + ".jpeg";
		File dest = new File(filePath);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL, methodName+" ----->Failed");
		test.addScreenCaptureFromPath(dest.getAbsolutePath()); 
		Reporter.log("TestScript Execution is Failed", true);
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+" ----->Skipped");
		Reporter.log("TestScript Execution is Skipped", true);

	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReports/report.html");
		htmlReport.config().setDocumentTitle("HRM Html Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("HRM");
		reports = new ExtentReports();
		reports.attachReporter(htmlReport);
		reports.setSystemInfo("Base_Browser", "chrome");
		reports.setSystemInfo("OS", "Windows");
		reports.setSystemInfo("Base_url", "http://rmgtestingserver/domain/HRM_System/");
		reports.setSystemInfo("Reporter Name", "Sindhu");

	}

	public void onFinish(ITestContext context) {
		reports.flush();
	}

}

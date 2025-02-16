package utilities;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {
	
	
	private static ExtentReports extent;
    private static ExtentTest test;
    private static ExtentSparkReporter sparkReporter;
    
    String repName;
    
    public void onStart(ITestContext testContext) {
    	
    	
    	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    	
    	repName = "Test-Report-" +timeStamp + ".html";
    	
    	sparkReporter = new ExtentSparkReporter(".\\report\\"+ repName);
    	
    	
    	sparkReporter.config().setDocumentTitle("Opencart Automation Test Report");
        sparkReporter.config().setReportName("opencart Functional Test Execution Report");
        sparkReporter.config().setTheme(Theme.DARK);
        
        
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "opencart");
        extent.setSystemInfo("Module", "Admin");
        extent.setSystemInfo("Sub Module", "Customer");
        extent.setSystemInfo("user name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");
        
        //getting browser name and operating system dynamically from xml file
        String os = testContext.getCurrentXmlTest().getParameter("os");
        extent.setSystemInfo("Operating System", os);
        
        String browser = testContext.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("Browser",browser);
        
        List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
        if(!includedGroups.isEmpty()) {
        	extent.setSystemInfo("Groups", includedGroups.toString());
        }
        }

    public void onTestSuccess(ITestResult result) {
    	
    	test = extent.createTest(result.getTestClass().getName());
    	test.assignCategory(result.getMethod().getGroups());
       test.log(Status.PASS, result.getName()+"got successfully executed");
    }

    public void onTestFailure(ITestResult result) {
    	test = extent.createTest(result.getTestClass().getName());
    	test.assignCategory(result.getMethod().getGroups());
       test.log(Status.FAIL, result.getName()+"got failed");
       test.log(Status.INFO, result.getThrowable().getMessage());
       
       try {
    	   String imgPath = new BaseClass().captureScreen(result.getName());
    	   test.addScreenCaptureFromPath(imgPath);
       }catch(IOException e) {
    	   e.printStackTrace();
       }
    }

    public void onTestSkipped(ITestResult result) {
    	test = extent.createTest(result.getTestClass().getName());
    	test.assignCategory(result.getMethod().getGroups());
       test.log(Status.PASS, result.getName()+"test case skipped");
       test.log(Status.INFO, result.getThrowable().getMessage());
    }

    public void onFinish(ITestContext testContext) {
        extent.flush();
        
        String pathOfExtentReport = System.getProperty("user.dir")+"\\report\\"+repName;
        File extentReport = new File(pathOfExtentReport);
        
        try {
     	   Desktop.getDesktop().browse(extentReport.toURI());
        }catch(IOException e) {
     	   e.printStackTrace();
        }
        System.out.println("Extent Report Generated");
    }

}


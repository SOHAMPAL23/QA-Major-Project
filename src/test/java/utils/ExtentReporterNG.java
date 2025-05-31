package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ExtentReporterNG implements IReporter {
    private ExtentReports extent;
    private static WebDriver driver;

    public static void startDriver(WebDriver d) {
    	driver=d;
    }

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
      
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(outputDirectory + "/ExtentReport.html");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setDocumentTitle("Automation Test Report");
        sparkReporter.config().setReportName("Test Report");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

       
        extent.setSystemInfo("Tester", "Kshitiz Dhooria");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Browser", "Chrome");

       
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();

            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();
                buildTestNodes(context.getPassedTests(), Status.PASS);
                buildTestNodes(context.getFailedTests(), Status.FAIL);
                buildTestNodes(context.getSkippedTests(), Status.SKIP);
            }
        }
        extent.flush(); 
    }

    private void buildTestNodes(IResultMap tests, Status status) {
        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                ExtentTest test = extent.createTest(result.getMethod().getMethodName());

                for (String group : result.getMethod().getGroups()) {
                    test.assignCategory(group);
                }

                test.getModel().setStartTime(getTime(result.getStartMillis()));
                test.getModel().setEndTime(getTime(result.getEndMillis()));

                if (result.getThrowable() != null) {
                    test.log(status, result.getThrowable());

                   
                    if (status == Status.FAIL) {
                        String screenshotPath = captureScreenshot(result.getMethod().getMethodName());
                        
                        test.addScreenCaptureFromPath(screenshotPath);
                        

                    }
                } else {
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                }
            }
        }
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }


    private String captureScreenshot(String screenshotName) {
        String filePath = System.getProperty("user.dir") + "/screenshots/" + screenshotName + ".png";

        try {
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            File directory = new File(System.getProperty("user.dir") + "/screenshots/");
            if (!directory.exists()) {
                directory.mkdir();
            }

            FileHandler.copy(source, new File(filePath));
            System.out.println("Screenshot saved: " + filePath);

        } catch (IOException e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }

        return filePath;
    }
}
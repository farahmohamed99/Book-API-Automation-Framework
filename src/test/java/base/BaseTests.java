package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.restassured.RestAssured;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.PropsFile;

import java.lang.reflect.Method;


public class BaseTests {

    public static ExtentHtmlReporter report;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite
    public void beforeSuite() {
        report = new ExtentHtmlReporter(PropsFile.getPropValue(PropsFile.Paths.extentReport));
        extent = new ExtentReports();
        extent.attachReporter(report);
    }

    @BeforeMethod
    public void beforeMethod(Method testMethod) {
        RestAssured.baseURI = PropsFile.getPropValue(PropsFile.URLs.baseUrl);
        test = extent.createTest(testMethod.getName());
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail("test failed !!");
        } else {
            test.pass("test Passed !!");
        }
    }

    @AfterClass
    public void afterClass() {
        extent.flush();
    }
}

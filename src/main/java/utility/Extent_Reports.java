package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.TestBase;

public class Extent_Reports extends TestBase
{
	static ExtentReports report;
	public static ExtentReports getReportInstance()
	{
		if(report==null)
		{
			String reportName = new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\csank\\eclipse-workspace\\Selenium_Framework_projectFirst\\Extent Reports"+reportName+".html");
			report = new ExtentReports();
			report.attachReporter(htmlReporter);
			report.setSystemInfo("OS", "Windows");
			report.setSystemInfo("Environment", "SIT");
			report.setSystemInfo("Build", "102.02.02.123");
			report.setSystemInfo("Browser", "chrome");
			htmlReporter.config().setDocumentTitle("UI Testing Documents");
			htmlReporter.config().setReportName("UI Test Report");
			
		}
		return report;
		
	}

}

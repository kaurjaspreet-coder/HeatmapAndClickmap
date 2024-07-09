package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	public ExtentReports getExtentReports() {
		String path= System.getProperty("user.dir")+"//reports//index.html"; 
	ExtentSparkReporter reporter= new ExtentSparkReporter(path);
	reporter.config().setDocumentTitle("HandC");
	reporter.config().setReportName("HandC Automation");
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Jaspreet Kaur");
	return extent;
	}

}

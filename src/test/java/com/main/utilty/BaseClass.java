package com.main.utilty;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.common.pkg.CommonFunction;

public class BaseClass extends CommonFunction {
	
	String sTestCaseName;
	
	@BeforeSuite
	public void startReport() throws Exception {
		
		Logz.message("--------- Call Data Property File ----------", true);
		propertyfunction(file);
		propertyfunction(writeDataFile);
		propertyfunction(orfile);
		
		String filename = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		//String extentReportFile = System.getProperty("user.dir") + "/results/TestExtentReport" + "_"  + ".html";
		String extentReportFile = System.getProperty("user.dir") + "/results/" + browserType()  + ".html";
		htmlReporter = new ExtentHtmlReporter(extentReportFile);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("Host Name", "Dummy");
		extent.setSystemInfo("Environment", "Automation Testing");
		extent.setSystemInfo("User Name", "Shashank Bansal");

		htmlReporter.config().setDocumentTitle("Dummy - Automation Status");
		htmlReporter.config().setReportName("Automation Report");

		htmlReporter.config().setTheme(Theme.STANDARD);

	}

	@BeforeClass
	public void setupApplication() throws Exception {

		switch (browserType()) {

		case "Web - Chrome":
			environment(webChrome(), "----------- Chrome Browser Session Started ---------", getChromeKey(),
					getChromeExePath());
			break;

		case "Web - Firefox":
			environment(webFirefox(), "----------- Firefox Browser Session Started ---------", getGeckoKey(),
					getGeckoPath());
			break;

		case "Mobile Web - Android - Chrome":
			environment(mobileWebAndroidChrome(),
					"-------- Mobile Web Android - Chrome Browser Session Started -----------", getChromeKey(),
					getChromeExePath());
			break;

		case "Mobile Web - IOS - Chrome":
			environment(mobileWebIOSChrome(), "-------- Mobile Web IOS - Chrome Browser Session Started -----------",
					getChromeKey(), getChromeExePath());
			break;

		case "Android":
			environment(androidPlatform(), "------------ Android App - Session Started --------------", "null", "null");
			break;

		case "API - GET Method":
			environment(apiMethod(), "------------ API GET Method - Session Started --------------", "null", "null");
			break;

		default:

			Logz.message("No Execution");

		}

	}

	@AfterMethod
	public void takeScreenshot() throws Exception {
		
		switch (browserType()) {

		case "All Platform":
			extent.flush();
			break;

		case "API - GET Method":
			extent.flush();
			break;

		default:

			sTestCaseName = this.toString();
			sTestCaseName = getTestCaseName(this.toString());
			getClassName();
			String className = propoutput.getProperty("ClassName");
			Logz.message("Class Name " + className);
			Thread.sleep(3000);
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File dest = new File(System.getProperty("user.dir") + "/Screenshots/" + className + ".png");
			FileUtils.copyFile(file, dest);
			extent.flush();
			driver.quit();

		}
		
		
		

	}
}

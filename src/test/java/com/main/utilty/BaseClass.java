package com.main.utilty;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.common.pkg.CommonFunction;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends CommonFunction {

	@BeforeSuite
	public void startReport() throws Exception {

		Logz.message("--------- Call Data Property File ----------", true);
		propertyfunction(file);
		propertyfunction(writeDataFile);
		propertyfunction(orfile);

		Logz.message("-------------- Calling Extent Report Set Up Function ---------");
		extentReportSetUp();

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
			extentReportFlush();
			break;

		case "API - GET Method":
			extentReportFlush();
			break;

		default:
			extentReprotFinish();

		}

	}
}

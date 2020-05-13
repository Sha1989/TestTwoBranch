package com.common.pkg;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.main.utilty.Logz;

import io.appium.java_client.android.AndroidDriver;
import io.restassured.RestAssured;

public class CommonFunction extends PropertyData {

	String sTestCaseName;

	public void environment(String platform, String message, String key, String value) throws Exception {
		Logz.message(message, true);

		if (platform.equalsIgnoreCase("Web - Chrome")) {

			System.setProperty(key, value);
			driver = new ChromeDriver();
			urlPass();

		} else if (platform.equalsIgnoreCase("Web - Firefox")) {

			System.setProperty(key, value);
			driver = new FirefoxDriver();
			urlPass();

		} else if (platform.equalsIgnoreCase("Mobile Web - Android - Chrome")) {

			System.setProperty(key, value);
			Map<String, String> mobileEmulation = new HashMap<>();
			mobileEmulation.put("deviceName", "Nexus 5");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			driver = new ChromeDriver(chromeOptions);
			urlPass();

		} else if (platform.equalsIgnoreCase("Mobile Web - IOS - Chrome")) {

			System.setProperty(key, value);
			Map<String, String> mobileEmulation = new HashMap<>();
			mobileEmulation.put("deviceName", "iPhone X");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			driver = new ChromeDriver(chromeOptions);
			urlPass();

		} else if (platform.equalsIgnoreCase("Android")) {

			launchAndroid();

		} else if (platform.equalsIgnoreCase("API - GET Method")) {

			RestAssured.baseURI = baseUrlGetApi();

		}
	}

	@SuppressWarnings("rawtypes")
	public void launchAndroid() throws Exception {

		dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("deviceName", "OnePlus 6");
		dc.setCapability("platformVersion", "10.0");
		dc.setCapability("appiumVersion", "1.13.0");
		dc.setCapability("appPackage", "***********");
		dc.setCapability("appActivity", "**********");
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);

	}

	public void allEnvironment() throws Exception {

//		environment(webChrome(), "----------- Chrome Browser Session Started ---------", getChromeKey(),
//				getChromeExePath());

		environment(webFirefox(), "----------- Firefox Browser Session Started ---------", getGeckoKey(),
				getGeckoPath());

		environment(mobileWebAndroidChrome(), "--------- Mobile Web - Chrome Browser Session Started ----------",
				getChromeKey(), getChromeExePath());

		environment(mobileWebIOSChrome(), "-------- Mobile Web IOS - Chrome Browser Session Started -----------",
				getChromeKey(), getChromeExePath());

		environment(androidPlatform(), "------------ Android App - Session Started --------------", "null", "null");

		environment(apiMethod(), "------------ API GET Method - Session Started --------------", "null", "null");

	}

	public void urlPass() throws Exception {

		Logz.message("--------- Passing URL --------", true);
		driver.get(urlData());

	}

	public static String getTestCaseName(String sTestCase) throws Exception {
		String value = sTestCase;
		try {
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");
			value = value.substring(posi + 1);
			return value;
		} catch (Exception e) {
			Logz.error("Class Utils | Method getTestCaseName | Exception desc : " + e.getMessage());
			throw (e);
		}
	}

	public static void extentReportSetUp() throws Exception {

		String filename = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		// String extentReportFile = System.getProperty("user.dir") +
		// "/results/TestExtentReport" + "_" + ".html";
		String extentReportFile = System.getProperty("user.dir") + "/results/" + browserType() + ".html";
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

	public void extentReprotFinish() throws Exception {

		screenshotSetUp();
		extentReportFlush();
		quit();

	}

	public void screenshotSetUp() throws Exception {

		sTestCaseName = this.toString();
		sTestCaseName = getTestCaseName(this.toString());
		getClassName();
		String className = propoutput.getProperty("ClassName");
		Logz.message("Class Name " + className);
		Thread.sleep(3000);
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "/Screenshots/" + className + ".png");
		FileUtils.copyFile(file, dest);
	}

	public void quit() throws Exception {

		driver.quit();
	}
	
	public void extentReportFlush() throws Exception {
		
		extent.flush();
		
	} 

}

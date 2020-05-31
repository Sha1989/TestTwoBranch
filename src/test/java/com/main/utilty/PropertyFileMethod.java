// Utility File - Property File Method

package com.main.utilty;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;

/**
 * @author shashank.a.bansal
 */
public class PropertyFileMethod {
	
	protected static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties propoutput = new Properties();
	protected DesiredCapabilities dc = new DesiredCapabilities();
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	public static File file = new File(
			System.getProperty("user.dir") + "/src/main/java/com/property/data/datafile.properties");

	public static File writeDataFile = new File(System.getProperty("user.dir") + "/src/main/java/com/property/data/OrderData.properties");

	public static File orfile = new File(System.getProperty("user.dir") + "/src/main/java/com/property/data/OR.properties");

	public static void propertyfunction(File file) {

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeData(File file) throws Exception {
		FileOutputStream fileOut = new FileOutputStream(file);
		propoutput.store(fileOut, "");
		fileOut.close();
	}

}
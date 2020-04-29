package com.main.utilty;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Logz extends PropertyFileMethod{
	private static Logger log = Logger.getLogger(Logz.class.getName());

	public static BaseClass baseClass;

	public static void message(String message, boolean b) {
		DOMConfigurator.configure("log4j.xml");

		log.info(message);
	}

	@SuppressWarnings("static-access")
	public static void startTestCase(String sTestCaseName) {
		DOMConfigurator.configure("log4j.xml");
		log.info("****************************************************************************************");
		log.info("****************************************************************************************");
		log.info("$$$$$$$$$$$$$$$$$$$$$                 " + sTestCaseName + "       $$$$$$$$$$$$$$$$$$$$$$$$$");
		log.info("****************************************************************************************");
		log.info("****************************************************************************************");
		pass(sTestCaseName);
	}

	public static void pass(String message) {
		DOMConfigurator.configure("log4j.xml");
		logger.log(Status.PASS, MarkupHelper.createLabel(message, ExtentColor.GREEN));
	}

	public static void info(String message) {
		log.info(message);
	}
	
	public static void message(String message) throws Exception {

		log.info(message);

	}
	
	public static String error(String message) throws IOException {

		log.error(message);
		fail(message);
		return message;
	}
	
	public static void fail(String message) {
		DOMConfigurator.configure("log4j.xml");
		logger.log(Status.FAIL, MarkupHelper.createLabel(message, ExtentColor.RED));
	}

}

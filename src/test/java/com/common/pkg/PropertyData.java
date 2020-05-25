package com.common.pkg;

import org.openqa.selenium.chrome.ChromeDriver;

import com.main.utilty.PropertyFileMethod;


public class PropertyData extends PropertyFileMethod {

	public static String getChromeExePath() throws Exception {

		String sPath = prop.getProperty("chromeExe");
		String sChromePath = System.getProperty("user.dir") + sPath;
		return sChromePath;

	}

	public static String getChromeKey() throws Exception {

		String sKey = prop.getProperty("chromeKey");
		return sKey;

	}

	public static String getGeckoPath() throws Exception {

		String sPath = prop.getProperty("geckoExe");
		String sGeckoPath = System.getProperty("user.dir") + sPath;
		return sGeckoPath;

	}

	public static String getGeckoKey() throws Exception {

		String sKey = prop.getProperty("geckoKey");
		return sKey;

	}

	public static String urlData() throws Exception {

		String sUrl = prop.getProperty("url");
		return sUrl;

	}

	public static String webChrome() throws Exception {

		String sData = prop.getProperty("webChrome");
		return sData;

	}
	
	

	/*
	 * public static String webChrome() throws Exception {
	 * 
	 * WebDriverManager.chromedriver().version("80.0.3987.106").setup(); driver =
	 * new ChromeDriver();
	 * 
	 * return "re";
	 * 
	 * }
	 */

	public static String webFirefox() throws Exception {

		String sData = prop.getProperty("webFirefox");
		return sData;

	}

	public static String mobileWebAndroidChrome() throws Exception {

		String sData = prop.getProperty("mobileWebAndroidChrome");
		return sData;

	}

	public static String mobileWebIOSChrome() throws Exception {

		String sData = prop.getProperty("mobileWebIOSChrome");
		return sData;

	}

	public static String allPlatorm() throws Exception {

		String sData = prop.getProperty("allPlatorm");
		return sData;

	}

	public static String browserType() throws Exception {
	    //String sData = System.getenv("browserType");
		String sData = prop.getProperty("browserType");
		return sData;

	}

	public static String androidPlatform() throws Exception {

		String sPlatform = prop.getProperty("androidPlatform");
		return sPlatform;

	}

	public static String apiMethod() throws Exception {

		String sMethod = prop.getProperty("apiMethod");
		return sMethod;

	}

	public static String baseUrlGetApi() throws Exception {

		String sApiUrl = prop.getProperty("baseUrlGetApi");
		return sApiUrl;

	}

	public static String apiLocationDetail() throws Exception {

		String sLocation = prop.getProperty("apiLocationDetail");
		return sLocation;

	}

	public void getClassName() throws Exception {

		String classname = this.getClass().getSimpleName();
		propoutput.setProperty("ClassName", classname);

	}

}

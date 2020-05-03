package com.common.pkg;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import io.appium.java_client.MobileBy;

public class Locator {

	public static enum Loc {

		CSS, XPATH, ID, NAME, CLASSNAME, TAGNAME, LINKTEXT, PARTIALLINKTEXT, ACCESSIBILITYID;
	}
	
		public static By getLocator(Loc type, String locator) {
			By by = null;
			switch (type) {
			case CSS:
				by = By.cssSelector(String.format(locator));
				break;
			case XPATH:
				by = By.xpath(String.format(locator));
				break;
			case ID:
				by = By.id(String.format(locator));
				break;
			case NAME:
				by = By.name(String.format(locator));
				break;
			case CLASSNAME:
				by = By.className(String.format(locator));
				break;
			case TAGNAME:
				by = By.tagName(String.format(locator));
				break;
			case LINKTEXT:
				by = By.linkText(String.format(locator));
				break;
			case PARTIALLINKTEXT:
				by = By.partialLinkText(String.format(locator));
				break;
			case ACCESSIBILITYID:
				by = MobileBy.AccessibilityId(String.format(locator));
				break;
			}
			return by;
		}

	
}

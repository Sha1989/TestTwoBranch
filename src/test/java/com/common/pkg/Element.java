package com.common.pkg;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.main.utilty.Logz;

public class Element {

	private By by;
	private WebDriver driver;
	private WebElement element;
	private WebDriverWait wait;

	public Element(WebDriver driver, WebElement e) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		this.element = e;
	}

	public WebElement element() {
		return element;
	}

	public Element sendKeys(String val) {
		this.element().sendKeys(val);
		return this;
	}

	public Element click() {
		this.element().click();
		return this;
	}

	public Element getText() {
		this.element.getText();
		return this;
	}

	public Element(WebDriver driver, ExpectedCondition<?> exp, int... delay) throws Exception {

		this.driver = driver;

		try {
			wait = new WebDriverWait(driver, 10);
			this.element = (WebElement) wait.until(exp);
		} catch (Exception e) {
			this.element = null;
			Logz.debug("element not located: " + by.toString());
			Logz.debug(e.getMessage());
		}

	}

	public Element(WebDriver driver, By by) throws Exception {

		this.driver = driver;
		this.by = by;

		try {
			wait = new WebDriverWait(driver, 10);
			this.element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			Logz.debug("Element is found.");
		} catch (Exception e) {
			Logz.debug("Element is not found.");
			Logz.message(e.getMessage());
		}

	}

}

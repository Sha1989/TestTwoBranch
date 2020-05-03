package com.common.pkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.common.pkg.Element;
import com.common.pkg.Locator.Loc;
import com.main.utilty.Logz;

import static com.common.pkg.Locator.Loc;
import static com.common.pkg.Locator.getLocator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.print.attribute.IntegerSyntax;

public class PageObject extends PropertyData {

	protected WebDriver driver;
	protected WebDriverWait wait;

	public PageObject(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);

	}

	public Element $(By by) throws Exception {
		return findElement(by);
	}

	public Element findElement(By by) throws Exception {
		Element el = new Element(driver, by);
		return el;
	}

	public WebDriverWait getWait() throws Exception {

		Logz.debug("obtaining the wait object for current thread");
		return wait;

	}

	public Element $(Loc type, String locator) throws Exception {

		Element el = new Element(driver, getLocator(type, locator));
		return el;

	}

	public Element $(ExpectedCondition<?> exp, int... delay) throws Exception {

		Element el = new Element(driver, exp, delay);
		return el;

	}

	public By $By(Loc type, String locator) throws Exception {

		By by = getLocator(Loc.XPATH, locator);
		return by;

	}

	public List<Element> findElements(ExpectedCondition<List<WebElement>> exp, int delay) {

		WebDriverWait wait = new WebDriverWait(driver, delay);

		try {
			List<WebElement> els = wait.until(exp);
			List<Element> elements = setElements(els);

			if (elements.size() > 0) {
				elements.get(0);
			}
			return elements;
		} catch (Exception e) {
			return Collections.emptyList();
		}

	}

	public List<Element> setElements(List<WebElement> els) {
		List<Element> list = new ArrayList<Element>();
		for (WebElement el : els) {
			list.add(new Element(driver, el));
		}
		return list;
	}

}

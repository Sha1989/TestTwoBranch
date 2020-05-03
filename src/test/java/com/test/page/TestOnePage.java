package com.test.page;

import static com.common.pkg.Locator.getLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.common.pkg.Locator.Loc;
import com.common.pkg.PageObject;
import com.main.utilty.Logz;

public class TestOnePage extends PageObject {

	public TestOnePage(WebDriver driver) {
		super(driver);
	}

	public String searchFieldLocator = prop.getProperty("searchField");

	public void enterDataSearchField() throws Exception {

		Logz.message("searchFieldLocator:- " + searchFieldLocator);

		$(Loc.XPATH, searchFieldLocator).click();
		
		findElements(ExpectedConditions.presenceOfAllElementsLocatedBy($By(Loc.XPATH, searchFieldLocator)), 5).get(0).sendKeys("Text ");

		$(ExpectedConditions.presenceOfElementLocated($By(Loc.XPATH, searchFieldLocator)), 5).sendKeys("Test");

		$(Loc.XPATH, searchFieldLocator).sendKeys("Test");
	}

	public void message() throws Exception {

		Logz.message("Success");

	}

}

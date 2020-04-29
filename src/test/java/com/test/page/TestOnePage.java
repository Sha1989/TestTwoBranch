package com.test.page;

import org.openqa.selenium.By;
import com.main.utilty.Logz;
import com.main.utilty.ObjectClass;
import com.main.utilty.PropertyFileMethod;

public class TestOnePage extends ObjectClass {

	public String searchFieldLocator = prop.getProperty("searchField");

	public void enterDataSearchField() throws Exception {

		Logz.message("searchFieldLocator:- " + searchFieldLocator);

		driver.findElement(By.xpath(searchFieldLocator)).sendKeys("Test");

		getTestpage().message();

	}

	public void message() throws Exception {

		Logz.message("Success");

	}

}

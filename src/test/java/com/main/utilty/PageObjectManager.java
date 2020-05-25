package com.main.utilty;


import com.common.pkg.PropertyData;
import com.test.page.TestOnePage;

public class PageObjectManager extends PropertyData {

	private static PageObjectManager pageObjectManager = new PageObjectManager();
	private static TestOnePage testpage;

	public static PageObjectManager getInstance() {
		return pageObjectManager;
	}

	public TestOnePage getTestOneInstance() {
		return (testpage == null) ? new TestOnePage(driver) : testpage;
	}

}

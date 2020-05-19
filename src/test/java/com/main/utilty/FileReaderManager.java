package com.main.utilty;

import org.openqa.selenium.WebDriver;

import com.common.pkg.CommonFunction;
import com.common.pkg.PropertyData;
import com.test.page.TestOnePage;

public class FileReaderManager extends PropertyData {

	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static TestOnePage testpage;

	public static FileReaderManager getInstance() {
		return fileReaderManager;
	}

	public TestOnePage getTestOneInstance() {
		return (testpage == null) ? new TestOnePage(driver) : testpage;
	}

}

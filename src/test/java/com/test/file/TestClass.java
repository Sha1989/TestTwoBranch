package com.test.file;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.main.utilty.BaseClass;
import com.main.utilty.FileReaderManager;
import com.main.utilty.Logz;

public class TestClass extends BaseClass {

	@com.main.utilty.JiraPolicy(logTicketReady = true)
	@Test
	public static void verifyUrl() throws Exception {

		logger = extent.createTest("--------- TestClass -----------");
		Thread.sleep(2000);

		FileReaderManager.getInstance().getTestOneInstance().enterDataSearchField();
		Logz.message("----- Done -----");
		Assert.assertEquals("test", "test");
	}

}

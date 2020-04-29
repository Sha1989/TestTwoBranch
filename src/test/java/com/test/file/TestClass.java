package com.test.file;

import org.testng.annotations.Test;
import com.main.utilty.BaseClass;
import com.main.utilty.Logz;
import com.main.utilty.ObjectClass;

public class TestClass extends BaseClass {
	
	@Test
	public static void verifyUrl() throws Exception {

		ObjectClass obj = new ObjectClass();
		
		logger = extent.createTest("--------- TestClass -----------");
		Thread.sleep(2000);

		obj.getTestpage().enterDataSearchField();
		Logz.message("----- Done -----");
	}

}

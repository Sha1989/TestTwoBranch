package com.main.utilty;

import com.common.pkg.CommonFunction;
import com.common.pkg.PropertyData;
import com.test.page.TestOnePage;

public class ObjectClass   extends PropertyData{ 
	
	
	private static TestOnePage testpage = new TestOnePage(driver);

	public  TestOnePage getTestpage() {
		return testpage;
	}

	public void setTestpage(TestOnePage testpage) {
		ObjectClass.testpage = testpage;
	}

}

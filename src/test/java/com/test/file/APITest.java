package com.test.file;

import org.testng.annotations.Test;

import com.main.utilty.BaseClass;
import com.main.utilty.Logz;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APITest extends BaseClass {

	@Test
	public void verifyLocationCondition() throws Exception {
		logger = extent.createTest("--------- API Test Class -----------");
		
		if(browserType().equalsIgnoreCase("API - GET Method") || browserType().equalsIgnoreCase("All Platform")) {

		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/" + apiLocationDetail());
		String responseBody = response.getBody().asString();
		Logz.message("Response Body is =>  " + responseBody);
		Logz.message("----- Done -----");
		
		}else {
			Logz.message("Not Executable");
		}
	}

}

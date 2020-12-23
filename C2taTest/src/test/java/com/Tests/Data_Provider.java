package com.Tests;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.testng.annotations.DataProvider;

public  class Data_Provider {
	@DataProvider(name="RegistrationAndLogin")
	public static Object[][] passData(Method m) {

		Object[][] 	data;	
	
		if(m.getName().equals("Registration_successfull_withallvalidvalues"))
		{
			data=new Object[3][3];
			data[1][0]="test39";
			data[1][1]="test39@gmail.com";
			data[1][2]="PAssword1#";

			data[2][0]="test40";
			data[2][1]="test40@gmail.com";
			data[2][2]="Password1#";
		}
		else
		{
			data=new Object[1][3];
		}
		data[0][0]="test41";			
		data[0][1]="test41@gmail.com";			
		data[0][2]="Password1#";
		
		if(m.getName().equals("Verify_alreadyregiseteredemailid"))
		{
			data[0][0]="test14##";
		}
		if(m.getName().equals("VerifyLogin_with_invalidpassword")) {
			data[0][2]="incorrectpassword";
		}
		return data;
	}

		
//	@DataProvider(name="SingleRegistration")
//	public static HashMap<String,String> passsingledata() {
//		HashMap<String,String> data = new HashMap<>();
//		data.put("")
//		return data;
//	}

	
}

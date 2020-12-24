package com.Tests;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.baseClasses.Library;
import com.reusablefunctions.SeleniumUtilities;

public class TestListener extends TestListenerAdapter{
	
	
	SeleniumUtilities util = new SeleniumUtilities();
	  @Override
	  public void onTestFailure(ITestResult tr) {
	    util.to_take_screenshot(tr.getName()+"failed");
	    Library.logger.info(tr.getName() + " failed!!");
	  }
	 
	  
	  @Override
	  public void onTestSuccess(ITestResult tr) {
		  util.to_take_screenshot(tr.getName()+"passed");
		  Library.logger.error(tr.getName() + " Passed!!");
	  }
	  
	  


}

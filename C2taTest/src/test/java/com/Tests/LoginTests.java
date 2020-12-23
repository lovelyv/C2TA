package com.Tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.baseClasses.Library;

public class LoginTests {
	
	@BeforeTest
	public void launchApp() {
		Library.browserSetUp();
	}
	
	
  @Test
  public void VerifyLogin_with_validemailandpassword() {
  }
  
  
  @Test
  public void VerifyLogin_with_invalidemailid() {
  }
  
  @Test
  public void VerifyLogin_with_invalidusername() {
  }
  
  @Test
  public void VerifyLogin_with_invalidpassword() {
  }
  
  @Test
  public void VerifyLogin_rememberme() {
  }
  
  @Test
  public void VerifyLogin_lostpassword() {
  }
  
   @AfterTest
	public void Teardown()
	{
		Library.tearDown();
	}
}

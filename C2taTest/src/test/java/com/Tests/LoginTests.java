package com.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.baseClasses.Library;
import com.pages.Loginpage;
import com.pages.Mainpage;



public class LoginTests extends Library {
	String errormessage = "ERROR: The username or password you entered is incorrect. Lost your password?";
	String passworderror = "Error: The password field is empty.";
	String usernameerror = "Error: The username field is empty.";
	Loginpage loginpage = new Loginpage();
	Mainpage mainpage = new Mainpage();
	String lostpwdurl = "https://c2ta.co.in/my-account/lost-password/";
	
	@BeforeClass
	public void launchApp() {
		browserSetUp();
	}
	
	
  @Test(priority=1,description="Verify login with valid emailid and password",dataProviderClass=Data_Provider.class ,dataProvider="RegistrationAndLogin")
  public void VerifyLogin_with_validemailandpassword(String username,String emailid,String password) {
	  mainpage.LoginlinkClick();
	  loginpage.Setusernamepassword(username, password);
	  loginpage.LoginClick();
	  String message = loginpage.VerifyLoggedinUsername();
	  String loggedinmsg = "Your are logged in as "+ username +". Log out?";
	  Assert.assertEquals(loggedinmsg,message);
	  mainpage.Logout();  
	  
  }
  
  @Test(priority=2,description="Verify login with valid username and password",dataProviderClass=Data_Provider.class ,dataProvider="RegistrationAndLogin")
  public void VerifyLogin_with_validusernameandpassword(String username,String emailid,String password) {
	  mainpage.LoginlinkClick();
	  loginpage.Setusernamepassword(emailid, password);
	  loginpage.LoginClick();
	  String message = loginpage.VerifyLoggedinUsername();
	  String loggedinmsg = "Your are logged in as "+ username +". Log out?";
	  Assert.assertEquals(loggedinmsg,message);
	  mainpage.Logout();
  }
  
  @Test(priority=3,description="Verify login with invalid emailid")
  public void VerifyLogin_with_invalidemailid() {
	  mainpage.LoginlinkClick();
	  loginpage.Setusernamepassword("aaaaaa@gmail.com", "password");
	  loginpage.LoginClick();
	  String msg = loginpage.GetMessageOnLoginClick();
	  Assert.assertEquals(msg, errormessage);
  }
  
  @Test(priority=4,description="Verify login with empty emailid")
  public void VerifyLogin_with_emptyemailid() {
	  mainpage.LoginlinkClick();
	  loginpage.Setusernamepassword("     ", "password");
	  loginpage.LoginClick();
	  String msg = loginpage.GetMessageOnLoginClick();
	  Assert.assertEquals(msg, usernameerror);
  }
  
  @Test(priority=5,description="Verify login with invalid username")
  public void VerifyLogin_with_invalidusername() {
	  mainpage.LoginlinkClick();
	  loginpage.Setusernamepassword("aaaaaa", "password");
	  loginpage.LoginClick();
	  String msg = loginpage.GetMessageOnLoginClick();
	  Assert.assertEquals(msg, errormessage);
	  
  }
  
  
  @Test(priority=6,description="Verify login with invalidpassword",dataProviderClass=Data_Provider.class ,dataProvider="RegistrationAndLogin")
  public void VerifyLogin_with_invalidpassword(String username,String emailid,String password) {
	  mainpage.LoginlinkClick();
	  loginpage.Setusernamepassword(username, password);
	  loginpage.LoginClick();
	  String msg = loginpage.GetMessageOnLoginClick();	  
	  Assert.assertEquals(msg, errormessage);
  }
  
  @Test(priority=7,description="Verify login with emptypassword")
  public void VerifyLogin_with_emptypassword() {
	  mainpage.LoginlinkClick();
	  loginpage.Setusernamepassword("test", "     ");
	  loginpage.LoginClick();
	  String msg = loginpage.GetMessageOnLoginClick();
	  Assert.assertEquals(msg, passworderror);
  }
  
  
  @Test(priority=8,description="Verify login with remember me",dataProviderClass=Data_Provider.class ,dataProvider="RegistrationAndLogin")
  public void VerifyLogin_rememberme(String username,String emailid, String password) {
	  mainpage.LoginlinkClick();
	  loginpage.Setusernamepassword(username, password);
	  loginpage.LoginClickwithRememberMe();	  
	  driver.close();
	  browserSetUp();
	  mainpage.LoginlinkClick();
	  String message = loginpage.VerifyLoggedinUsername();
	  String loggedinmsg = "Your are logged in as "+ username +". Log out?";
	  Assert.assertEquals(loggedinmsg,message);
	  mainpage.Logout();
	  
  }
  
  @Test(priority=9,description="Verify lost password link")
  public void VerifyLogin_lostpassword() {
	  mainpage.LoginlinkClick();
	  loginpage.LostpasswordlinkClick();
	  String url = loginpage.Geturl();
	  Assert.assertEquals(url, lostpwdurl);
  }
  
   @AfterClass
	public void QuitBrowser()
	{
		tearDown();
	}
}

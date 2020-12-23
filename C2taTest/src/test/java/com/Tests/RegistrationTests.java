package com.Tests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




import org.testng.Assert;
import com.baseClasses.Library;
import com.pages.Mainpage;
import com.pages.Registrationpage;



public class RegistrationTests extends Library{
	
	String errormsguser = "Sorry, that username already exists!";
	String errormsgemail = "Sorry, that email address is already used!";
	String shortpassword = "Password is too short!";
	String passwordcapital = "Password must include at least one capitalized letter!";
	String passwordonenumber = "Password must include at least one number!";
	String passwordcontainspecialchar = "Password must include at least one of these characters ~!@#$%^&*() !";
	Registrationpage regpage = new Registrationpage();
	Mainpage mainpage = new Mainpage();
	String username ="test";
	String emailid = username + "@gmail.com";	
	
	
	@BeforeClass
	public void launchApp() {
		browserSetUp();		
	}
	
	
  @Test(priority=1,description="Register a new user to application",dataProviderClass=Data_Provider.class ,dataProvider="RegistrationAndLogin") 
  public void Registration_successfull_withallvalidvalues(String username,String emailid, String password) {
	  
	  RegisterDetails(username,emailid,password);
	  String message = regpage.VerifyLoggedinUsername();
	  String loggedinmsg = "Your are logged in as "+ username +". Log out?";	  
	  Assert.assertEquals(loggedinmsg,message);
	  mainpage.Logout();
	  mainpage.RegisterlinkClick();
  }
  
  @Test(priority = 4,description="Register using empty values in fields")
  public void Verify_emptyusername_notallowed() {	  
	  RegisterDetails("","","");
	  String url = regpage.Geturl();
	  Assert.assertEquals(url, "https://c2ta.co.in/register/");
  }
  
  
  @Test(priority = 5,description="Register with empty email id and empty password")
  public void Verify_emptyemail_notallowed() {
	  RegisterDetails(username,"","");	  
	  String url = regpage.Geturl();
	  Assert.assertEquals(url, "https://c2ta.co.in/register/");
  }
  
  @Test(priority = 6,description="Register with empty password")
  public void Verify_emptypassword_notallowed() {
	  
	  RegisterDetails(username,emailid,"");
	  String url = regpage.Geturl();
	  Assert.assertEquals(url, "https://c2ta.co.in/register/");
  }
  
  
  
  @Test(priority = 7,description="Register with invalid format of email id")
  public void Verify_emailformat_validation() {
	  
	  RegisterDetails(username,"email","Password1#");	  
	  String url = regpage.Geturl();
	  Assert.assertEquals(url, "https://c2ta.co.in/register/");
  }
  
  @Test(priority = 8,description="Register with no capital letter in password")
  public void Verify_strong_password_forcapitalletter() {
	  RegisterDetails(username,emailid,"password1#");
	  String message = regpage.GetMessageOnRegisterClick();
	  Assert.assertEquals(message,passwordcapital);
  }

  @Test(priority = 9,description="Register with just 1 character in password")
  public void Verify_strong_password_short() {
	  RegisterDetails(username,emailid,"p");
	  String message = regpage.GetMessageOnRegisterClick();
	  Assert.assertEquals(message,shortpassword);
  }
  
  @Test(priority = 10,description="Register with no integer in password")
  public void Verify_strong_password_forint() {
	  RegisterDetails(username,emailid,"Password");
	  String message = regpage.GetMessageOnRegisterClick();
	  Assert.assertEquals(message,passwordonenumber);
  }
  
  @Test(priority = 11,description="Register with no special character in password")
  public void Verify_strong_password_forspecialchar() {
	  RegisterDetails(username,emailid,"Password1");
	  String message = regpage.GetMessageOnRegisterClick();
	  Assert.assertEquals(message,passwordcontainspecialchar);
  }
  
  @Test(priority = 2,description="Register with already registered username",dataProviderClass=Data_Provider.class ,dataProvider="RegistrationAndLogin")
  public void Verify_alreadyregiseteredusername(String username,String emailid,String password) {
	  RegisterDetails(username,emailid,password);
	  String message = regpage.GetMessageOnRegisterClick();	  	  
	  Assert.assertEquals(message,errormsguser);	  
  }
  
  
  @Test(priority = 3,description="Register with already registered emailid",dataProviderClass=Data_Provider.class ,dataProvider="RegistrationAndLogin")
  public void Verify_alreadyregiseteredemailid(String username,String emailid,String password) {
	  
	  RegisterDetails(username+"!",emailid,password);	  
	  String message = regpage.GetMessageOnRegisterClick();	  	  
	  Assert.assertEquals(message,errormsgemail);	  
  }  
  
     
    private void RegisterDetails(String username,String emailid,String password) {
	  
	  mainpage.RegisterlinkClick();	  	 
	  regpage.SetUsername(username);
	  regpage.SetEmailId(emailid);
	  regpage.SetPassword(password);
	  regpage.RegisterButtonClick();  	 
    }
    
    
     @AfterClass
	public void QuitBrowser()
	{
		tearDown();
	}
    

  
}

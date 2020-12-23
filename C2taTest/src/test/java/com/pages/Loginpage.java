package com.pages;

import org.openqa.selenium.By;
import com.reusablefunctions.SeleniumUtilities;

public class Loginpage {
	
	By loginlink = By.linkText("Login");
	By nameorid = By.id("username");
	By password = By.id("password");
	By loginbutton = By.xpath("//button[text()='Login']");
	By rememberme = By.name("rememberme");
	By lostlink = By.linkText("Lost your password?");
	By loggedinusername = By.className("learnpress");
	String lostpwdurl = "https://c2ta.co.in/my-account/lost-password/";
	
	
	SeleniumUtilities util = new SeleniumUtilities();
	
	
	public void Setusernamepassword(String username, String password) {
		util.ExplicitWaitForElementVisibility(nameorid).sendKeys(username);
		util.SetText(this.password, password);
	}
	
	public void LoginClick() {
		util.ElementClick(loginbutton);
	}
	
	public void LoginClickwithRememberMe() {
		util.ElementClick(rememberme);
		util.ElementClick(loginbutton);		
	}
	
	public String VerifyLoggedinUsername() {		
		return util.ExplicitWaitForElementVisibility(loggedinusername).getText();	
		
	}
	
	public void LostpasswordlinkClick() {		
		util.ElementClick(lostlink);
		util.ExplicitWaitForUrltochange(lostpwdurl);		
	}

}

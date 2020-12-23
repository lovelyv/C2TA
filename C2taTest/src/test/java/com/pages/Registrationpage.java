package com.pages;

import org.openqa.selenium.By;
import com.reusablefunctions.SeleniumUtilities;

public class Registrationpage {
	
	
	By registerlink = By.linkText("Register");
	By username = By.id("reg_username");
	By emailid = By.id("reg_email");
	By password = By.id("reg_password");
	By registerbutton = By.xpath("//button[text()='Register']");
	By message = By.cssSelector("div.learn-press-message.error");
	By errormessage = By.className("learn-press-message error");
	By loggedinusername = By.className("learnpress");
	By logout = By.cssSelector("a.logout_url");
	
	
	SeleniumUtilities util = new SeleniumUtilities();
	
	public void RegisterlinkClick() {
		util.ElementClick(registerlink);
		util.ExplicitWaitForElementPresence(username);
	}
	
	public void SetUsername(String username) {
		util.SetText(this.username, username);		
	}
	
	public void SetEmailId(String emailid) {
		util.SetText(this.emailid, emailid);		
	}
	
	public void SetPassword(String password) {
		util.SetText(this.password, password);		
	}
	
	public void RegisterButtonClick() {		
		util.ElementClick(registerbutton);		
	}
	
	public String GetMessageOnRegisterClick() {		
		return util.ExplicitWaitForElementPresence(message).getText(); 		
	}
	
	public String VerifyLoggedinUsername() {		
		return util.ExplicitWaitForElementVisibility(loggedinusername).getText();	
		
	}
	
	public String Geturl() {
		return util.getUrl();
	}
	
	public void Logout() {
		util.ElementClick(logout);
	}
	
	
}

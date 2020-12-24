package com.pages;

import org.openqa.selenium.By;

import com.reusablefunctions.SeleniumUtilities;

public class Mainpage {
	By registerlink = By.linkText("Register");
	By logout = By.cssSelector("a.logout_url");
	By loginlink = By.linkText("Login");
	
	SeleniumUtilities util = new SeleniumUtilities();
	
	public void RegisterlinkClick() {
		util.ElementClick(registerlink);		
	}
	
	public void LoginlinkClick() {
		util.ElementClick(loginlink);
	}
	
	public void Logout() {
		util.ElementClick(logout);
	}
	
	public boolean IsLogoutButtonVisible() {
		if (util.GetElement(logout) !=null) {
			return true;
		}
		return false;
	}
}

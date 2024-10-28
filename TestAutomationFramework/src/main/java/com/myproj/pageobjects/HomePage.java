package com.myproj.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myproj.base.BaseClass;
import com.myproj.browseraction.BrowserAction;

public class HomePage extends BaseClass {
	
	@FindBy(xpath = "//a[@data-nav-role = 'signin'][@data-csa-c-type = 'link']")
	WebElement signIn;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	public LoginPage signInButton()
	{
		BrowserAction.click(driver, signIn);
		return new LoginPage();
		
	}
}

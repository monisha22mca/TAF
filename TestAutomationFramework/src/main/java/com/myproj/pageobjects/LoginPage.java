package com.myproj.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myproj.base.BaseClass;
import com.myproj.browseraction.BrowserAction;

public class LoginPage extends BaseClass {
	
	@FindBy(xpath = "//input[@type = 'email']")
	WebElement emailTextBox;
	
	@FindBy(xpath = "//input[@aria-labelledby = 'continue-announce'][@type = 'submit']")
	WebElement continueButton;
	
	@FindBy(xpath = "//input[@name = 'password']")
	WebElement passwordTextBox;
	
	@FindBy(xpath = "//input[@aria-labelledby = 'auth-signin-button-announce'][@type = 'submit']")
	WebElement signinButton;
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void login()
	{
		BrowserAction.type(emailTextBox, prop.getProperty("username"));
		BrowserAction.click(driver, continueButton);
		BrowserAction.type(passwordTextBox, prop.getProperty("password"));
		BrowserAction.click(driver, signinButton);
	}

}
package com.myproj.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myproj.base.BaseClass;
import com.myproj.browseraction.BrowserAction;

public class HomePage extends BaseClass {
	
	@FindBy(xpath = "//a[contains(@href, 'register')]")
	WebElement registerLink;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	public void clickRegister() throws Throwable
	{
		BrowserAction.click(driver, registerLink);
		System.out.println("Click Register link");
		
	}
}

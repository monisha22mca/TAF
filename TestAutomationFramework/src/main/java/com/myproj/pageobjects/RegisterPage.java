package com.myproj.pageobjects;

import org.openqa.selenium.support.PageFactory;

import com.myproj.base.BaseClass;

public class RegisterPage extends BaseClass {
	
	
	
	public RegisterPage()
	{
		PageFactory.initElements(driver, this);
	}

}

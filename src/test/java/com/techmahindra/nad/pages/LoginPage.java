package com.techmahindra.nad.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.techmahindra.nad.generic.Assertion;
import com.techmahindra.nad.generic.GenericLib;



public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='_39M2dM']/input[@type='text']")
	private WebElement mobNumTxtFld;
	
	@FindBy(xpath="//div[@class='_39M2dM']/input[@type='password']")
	private WebElement pwdTxtFld;
	
	@FindBy(xpath="//div[@class='_1avdGP']/button[@type='submit']")
	private WebElement loginBtn;
	
	
	public void login(){
		Assertion.displayElement(mobNumTxtFld);
		this.mobNumTxtFld.clear();
		this.mobNumTxtFld.sendKeys(GenericLib.getConfigValue("./UI_Config.properties", "MobNum"));
		this.pwdTxtFld.clear();
		this.pwdTxtFld.sendKeys(GenericLib.getConfigValue("./UI_Config.properties", "Password"));
		this.loginBtn.click();
	}

}

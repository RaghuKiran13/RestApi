package com.techmahindra.nad.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.techmahindra.nad.generic.Assertion;
import com.techmahindra.nad.generic.GenericLib;
import com.techmahindra.nad.generic.SeleniumLib;




public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(xpath="//a[@href='/account/?rd=0&link=home_account']")
	private WebElement profileLnk;
	
	@FindBy(xpath="//input[contains(@title,'Search for products')]")
	private WebElement searchTxtFld;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//a[text()='Log Out']")
	private WebElement logoutBtn;
	
	public void verfiyHomepage(){
		Assertion.textContains(this.profileLnk, GenericLib.getConfigValue("./UI_Config.properties", "ProfileName"));
	}
	
	public void searchProduct(String productName){
		this.searchTxtFld.clear();
		this.searchTxtFld.sendKeys(productName);
		GenericLib.setConfigValue("./UI_Config.properties", "Product", productName);
		this.searchBtn.click();
	}
	
	public void logout() throws InterruptedException{
		SeleniumLib.waitTillElementDisplayed(driver, this.profileLnk);
		SeleniumLib.moveToEle(driver, profileLnk);
		SeleniumLib.waitTillElementDisplayed(driver, this.profileLnk);
		SeleniumLib.moveToEleAndClick(driver, logoutBtn);
	}
	
	

}

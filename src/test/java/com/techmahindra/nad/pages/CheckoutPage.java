
package com.techmahindra.nad.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.techmahindra.nad.generic.Assertion;
import com.techmahindra.nad.generic.GenericLib;
import com.techmahindra.nad.generic.SeleniumLib;




public class CheckoutPage {
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(text(),'Add a new address')]")
	private WebElement addNewAddressBtn;
	
	@FindBy(name="name")
	private WebElement nameTxtFld;
	
	@FindBy(name="phone")
	private WebElement phoneTxtFld;
	
	@FindBy(name="pincode")
	private WebElement pincodeTxtFld;
	
	@FindBy(name="addressLine2")
	private WebElement addressLine2TxtFld;
	
	@FindBy(name="addressLine1")
	private WebElement addressLine1TxtFld;
	
	@FindBy(name="city")
	private WebElement cityTxtFld;
	
	@FindBy(name="state")
	private WebElement selectStateDD;
	
	@FindBy(name="landmark")
	private WebElement landmarkTxtFld;
	
	@FindBy(xpath="(//input[@name='locationTypeTag'])[1]")
	private WebElement homeRadioBtn;
	
	@FindBy(xpath="//button[text()='Save and Deliver Here']")
	private WebElement saveNDelieverBtn;
	
	@FindBy(xpath="//button[text()='CONTINUE']")
	private WebElement continueBtn;
	
	@FindBy(xpath="//span[text()='Payment Options']")
	private WebElement paymentOptionsTxt;
	
	@FindBy(xpath="(//button[text()='Change'])[2]")
	private WebElement changeBtn;
	
	public void verifyCheckOutPage(){
		SeleniumLib.waitTillElementDisplayed(driver, this.changeBtn);
		String expectedText ="checkout";
		Assertion.verifyURL(driver, expectedText);
	}
	
	public void clickAddNewAddress(){
		this.changeBtn.click();
		SeleniumLib.waitTillElementDisplayed(driver, this.addNewAddressBtn);
		this.addNewAddressBtn.click();
	}
	
	public void enterAddressDetails(){
		this.nameTxtFld.clear();
		this.nameTxtFld.sendKeys(GenericLib.getConfigValue("./UI_Config.properties", "Name"));
		this.phoneTxtFld.clear();
		this.phoneTxtFld.sendKeys(GenericLib.getConfigValue("./UI_Config.properties", "MobNum"));
		this.pincodeTxtFld.clear();
		this.pincodeTxtFld.sendKeys(GenericLib.getConfigValue("./UI_Config.properties", "Pincode"));
		this.addressLine2TxtFld.clear();
		this.addressLine2TxtFld.sendKeys(GenericLib.getConfigValue("./UI_Config.properties", "Locality"));
		this.addressLine1TxtFld.clear();
		this.addressLine1TxtFld.sendKeys(GenericLib.getConfigValue("./UI_Config.properties", "Address"));
		this.cityTxtFld.clear();
		this.cityTxtFld.sendKeys(GenericLib.getConfigValue("./UI_Config.properties", "City"));
		SeleniumLib.selectDD(this.selectStateDD, GenericLib.getConfigValue("./UI_Config.properties", "State"));
		this.landmarkTxtFld.clear();
		this.landmarkTxtFld.sendKeys(GenericLib.getConfigValue("./UI_Config.properties", "Landmark"));
		this.saveNDelieverBtn.click();	
	}
	
	public void verifyOrderSummaryDisplayed(){
		SeleniumLib.waitTillElementDisplayed(driver, this.continueBtn);
		this.continueBtn.click();
	}
	
	public void verifyPaymentOptions() throws InterruptedException{
		SeleniumLib.waitTillElementDisplayed(driver, this.paymentOptionsTxt);
		Assertion.displayElement(this.paymentOptionsTxt);
		Thread.sleep(5000);
	}
	
	

}

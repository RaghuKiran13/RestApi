package com.techmahindra.nad.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.techmahindra.nad.generic.Assertion;
import com.techmahindra.nad.generic.SeleniumLib;




public class ProductDetailPage {
	
	WebDriver driver;
	
	public ProductDetailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@data-reactid='128']")   ////button[@data-reactid='128']//button[@class='_2AkmmA _2Npkh4 _2MWPVK RpigiU']
	private WebElement buyBtn;
	
	@FindBy(xpath="//span[contains(text(),'Change')]")
	private WebElement changeBtn;
	
	@FindBy(id="pincodeInputId")
	private WebElement deliverypinTxtFld;
	
	@FindBy(xpath="//span[contains(text(),'Check')]")
	private WebElement checkBtn;
	
	@FindBy(xpath="//div[contains(text(),'Delivery by')]")
	private WebElement deliveryDateTxtFld;
	
	public void verifyProductDetailPage(){
		SeleniumLib.switchToChildWIndow(driver);
		Assertion.displayElement(this.buyBtn);
	}
	
	public void clickOnBuyNow(){
		this.buyBtn.click();
	}

}

package com.techmahindra.nad.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.techmahindra.nad.generic.Assertion;
import com.techmahindra.nad.generic.SeleniumLib;



public class CartPage {

	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Place Order']")
	private WebElement placeOrderBtn;
	
	
	public void verifyCartPage(){
		SeleniumLib.waitTillElementDisplayed(driver, this.placeOrderBtn);
		String expectedText ="viewcart";
		Assertion.verifyURL(driver, expectedText);
	}
	
	public void clickPlaceOrder(){
		this.placeOrderBtn.click();
	}
}

package com.techmahindra.nad.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.techmahindra.nad.generic.Assertion;
import com.techmahindra.nad.generic.GenericLib;
import com.techmahindra.nad.generic.SeleniumLib;

public class ProductListPage {

	WebDriver driver;

	public ProductListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'results for')]")
	private WebElement showResultsTxt;

	@FindBy(xpath = "//span[@class='W-gt5y']")
	private WebElement productNameTxt;

	@FindAll({ @FindBy(xpath = "//a[@class='_1UoZlX']") })
	private List<WebElement> resultsLnk;

	public void verifySearchedResults() {
		String actualText = this.showResultsTxt.getText() + this.productNameTxt.getText();
		String expectedText = GenericLib.getConfigValue("./UI_Config.properties", "Results") + " " + "\""
				+ GenericLib.getConfigValue("./UI_Config.properties", "Product") + "\"";
		Assertion.textContains(expectedText, actualText);
	}

	public void clickOnProduct() {
		SeleniumLib.waitTillElementsDisplayed(driver, this.resultsLnk);
		this.resultsLnk.get(0).click();
	}

}

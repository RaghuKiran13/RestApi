package com.techmahindra.nad.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumLib {

	private static String currentWindow = null;
	
	// To switch to child window from parent window
	public static void switchToChildWIndow(WebDriver driver) {
		currentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		List<String> windowlist = new ArrayList<String>(windows);
		if (!currentWindow.equalsIgnoreCase(windowlist.get(1))) {
			driver.switchTo().window(windowlist.get(1));
		}
	}

	// To switch to parent window from child window
	public static void switchToParentWindow(WebDriver driver) {
		driver.switchTo().window(currentWindow);
	}

	// Wait upto visibility of WebElements
	public static void waitTillElementsDisplayed(WebDriver driver, List<WebElement> element) {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfAllElements((element)));
	}

	// Wait upto visibility of WebElement
	public static void waitTillElementDisplayed(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// To handle dropdown
	public static void selectDD(WebElement element, String visibleTxt) {
		Select dd = new Select(element);
		dd.selectByVisibleText(visibleTxt);
	}
	
	// To perfom move to element action
	public static void moveToEle(WebDriver driver, WebElement element){
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	
	//To perform move to element and click
	public static void moveToEleAndClick(WebDriver driver,WebElement element){
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
	}

}

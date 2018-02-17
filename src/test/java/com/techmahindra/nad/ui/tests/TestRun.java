package com.techmahindra.nad.ui.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.techmahindra.nad.utils.InitObj;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.ChromeDriverManager;

@CucumberOptions(
		features = "Feature", 
		glue = { "com.techm.newagedelivery.step_def" }, 
		tags = { "@Checkout"},
		plugin = {
		"html:target/cucumber-html-report", "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
		"junit:target/cucumber-results.xml" })
public class TestRun extends AbstractTestNGCucumberTests {

	@BeforeClass(alwaysRun = true)
	public void setup() {
		ChromeDriverManager.getInstance().setup();
		InitObj.driver = new ChromeDriver();
		InitObj.driver.manage().window().maximize();
		InitObj.driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}

	@AfterClass(alwaysRun = true)
	public void teardown() {
		InitObj.driver.quit();
	}


}

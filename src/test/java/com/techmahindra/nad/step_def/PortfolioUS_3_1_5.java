package com.techmahindra.nad.step_def;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.techmahindra.nad.generic.GenericLib;
import com.techmahindra.nad.pages.CartPage;
import com.techmahindra.nad.pages.CheckoutPage;
import com.techmahindra.nad.pages.HomePage;
import com.techmahindra.nad.pages.LoginPage;
import com.techmahindra.nad.pages.ProductDetailPage;
import com.techmahindra.nad.pages.ProductListPage;
import com.techmahindra.nad.utils.InitObj;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class PortfolioUS_3_1_5 extends InitObj{
	
	@Before
	public void preTest() {
		// Load the URL
		driver.get(GenericLib.getConfigValue("./UI_Config.properties", "URL"));

		// Create page instances
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		productlistpage=new ProductListPage(driver);
		productdetailpage = new ProductDetailPage(driver);
		checkoutpage = new CheckoutPage(driver);
		cartpage = new CartPage(driver);

	}

	
	
	@Given("^that portfolio user has raised a request to create a new individual portfolio$")
	public void that_portfolio_user_has_raised_a_request_to_create_a_new_individual_portfolio() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("http://www.craftsvilla.com");
	    throw new PendingException();
	}

	@When("^the Approver has approved the request for a new portfolio$")
	public void the_Approver_has_approved_the_request_for_a_new_portfolio() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the Approver will take inputs related to Concept, Plan, Prototype, Dev & Test, Launch, Lifecycle Mgmt, domain, technology, skills etc$")
	public void the_Approver_will_take_inputs_related_to_Concept_Plan_Prototype_Dev_Test_Launch_Lifecycle_Mgmt_domain_technology_skills_etc() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Approver creates a new portfolio$")
	public void approver_creates_a_new_portfolio() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}

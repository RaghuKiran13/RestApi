package com.techmahindra.nad.step_def;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.techmahindra.nad.generic.GenericLib;
import com.techmahindra.nad.generic.SeleniumLib;
import com.techmahindra.nad.pages.CartPage;
import com.techmahindra.nad.pages.CheckoutPage;
import com.techmahindra.nad.pages.HomePage;
import com.techmahindra.nad.pages.LoginPage;
import com.techmahindra.nad.pages.ProductDetailPage;
import com.techmahindra.nad.pages.ProductListPage;
import com.techmahindra.nad.utils.InitObj;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class  Checkout extends InitObj {

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

	@Given("^the user should be logged into Flipkart application$")
	public void the_user_should_be_logged_into_Flipkart_application() throws Throwable {
		loginpage.login();
		homepage.verfiyHomepage();
	}

	@When("^in search, enter the product name$")
	public void in_search_enter_the_product_name(DataTable productDetails) throws Throwable {
		List<List<String>> productName = productDetails.raw();
		homepage.searchProduct(productName.get(1).get(0));
	}

	@Then("^Product list page must be displayed$")
	public void product_list_page_must_be_displayed() throws Throwable {
		productlistpage.verifySearchedResults();
	}

	@When("^Select a product$")
	public void select_a_product() throws Throwable {
		productlistpage.clickOnProduct();
	}

	@Then("^Product detail page must be displayed$")
	public void product_detail_page_must_be_displayed() throws Throwable {
		productdetailpage.verifyProductDetailPage();
	}

	@When("^Check out the product$")
	public void check_out_the_product() throws Throwable {
		productdetailpage.clickOnBuyNow();
		cartpage.verifyCartPage();
		cartpage.clickPlaceOrder();
	}

	@Then("^Checkout page must be displayed$")
	public void checkout_page_must_be_displayed() throws Throwable {
		checkoutpage.verifyCheckOutPage();
	}

	@When("^Enter delivery delivery details$")
	public void enter_delivery_delivery_details() throws Throwable {
		checkoutpage.clickAddNewAddress();
		checkoutpage.enterAddressDetails();
		checkoutpage.verifyOrderSummaryDisplayed();
	}

	@Then("^Should proceed to payment options$")
	public void should_proceed_to_payment_options() throws Throwable {
		checkoutpage.verifyPaymentOptions();
		SeleniumLib.switchToParentWindow(driver);
	}
	
	@Then("^user should be logged out successfully$")
	public void user_should_be_logged_out_successfully() throws Throwable {
		homepage.logout();
	}

	@After
	public void postTest(Scenario scenario) throws InterruptedException {
		String timestamp=GenericLib.timestamp();
		System.out.println(timestamp);
		
		try {
			if (scenario.isFailed()) {
				scenario. embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
				TakesScreenshot sc = (TakesScreenshot) driver;
				File src = sc.getScreenshotAs(OutputType.FILE);
				File tar = new File("./Failure_Screenshots/"+scenario.getName()+timestamp+".png");
				try {
					FileUtils.moveFile(src, tar);
				} catch (IOException io) {
					Reporter.log("...Test has been passed...", true);
				}
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		Thread.sleep(10000);
	}

}// End of class

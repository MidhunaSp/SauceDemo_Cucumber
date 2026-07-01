package com.stepdef;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pom.CheckoutPage;
import com.pom.InventoryPage;
import com.pom.LoginPage;
import com.utils.DriverUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceDemoSteps {

	WebDriver driver;
	LoginPage lp = new LoginPage();
	CheckoutPage cp = new CheckoutPage();
	InventoryPage ip = new InventoryPage();
	
	@Given("Iam on the SauceDemo Login page")
	public void iam_on_the_sauce_demo_login_page() {
	    DriverUtils.getDriver().get("https://www.saucedemo.com/");
	}

	@When("I enter {string} and password {string}")
	public void i_enter_and_password(String user, String pass) {
	    lp.login(user, pass);
	}

	@When("I click the login button")
	public void i_click_the_login_button() {
	    
	}

	@Then("I should be redirected to the dashboard")
	public void i_should_be_redirected_to_the_dashboard() {
	   Assert.assertEquals(ip.getPageTitle(),"Products");
	}

	@When("I select sort {string} from the dropdown")
	public void i_select_sort_from_the_dropdown(String string) {
	    ip.sortAndAddProduct();
	}

	@When("I add the first product to the cart")
	public void i_add_the_first_product_to_the_cart() {
		// Handled within sortAndAddProduct() which is in POM
	}

	@When("I click on the shopping cart icon")
	public void i_click_on_the_shopping_cart_icon() {
		// Handled within sortAndAddProduct() which is in POM
	}

	@Then("I should be on the cart page")
	public void i_should_be_on_the_cart_page() {
	    Assert.assertEquals(cp.getPageTitle(), "Your Cart");
	}

	@When("I click the {string} button")
	public void i_click_the_button(String string) {
	    // handled using code in completeCheckout in POM
	}

	@When("I enter checkout information as {string},{string},{string}")
	public void i_enter_checkout_information_as(String f, String l, String z) {
	   cp.completeCheckout(f, l, z);
	}

	@Then("I should see the {string} message")
	public void i_should_see_the_message(String expected) {
	    String actual = cp.getSuccessMessage();
	    Assert.assertEquals(actual, expected);
	    
	    DriverUtils.getDriver().quit();
	}
}


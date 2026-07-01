package com.pom;

import com.utils.DriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends BasePage {
    
    // Standard locator for the sort dropdown
    @FindBy(className = "product_sort_container") 
    private WebElement sortDropdown;

    // ID for the 'Sauce Labs Fleece Jacket' (Highest price item)
    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket") 
    private WebElement addJacketBtn;

    @FindBy(className = "shopping_cart_link") 
    private WebElement cartBtn;
    
    @FindBy(xpath = "//span[@data-test='title']") 
    private WebElement pageTitle;

    public void sortAndAddProduct() {
        // sorting by Price (high to low) using Select class
        Select select = new Select(sortDropdown);
        // by using selectByValue() method in Select class
        select.selectByValue("hilo"); 

        // add the highest priced item directly using ID
        addJacketBtn.click();
        
        cartBtn.click();
    }

    // to verify we are in the products page
	public String getPageTitle() {
		return pageTitle.getText();
	}
}
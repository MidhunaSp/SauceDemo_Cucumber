package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.utils.DriverUtils;

public class LoginPage extends BasePage{

	@FindBy(id="user-name")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="login-button") 
	private WebElement loginBtn;
	
	public void login(String user,String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		
		
		Actions action = new Actions(DriverUtils.getDriver());
	    // clicking enter using Actions class's method moveToElement(), Keys.ENTER
		action.moveToElement(loginBtn)
        .sendKeys(org.openqa.selenium.Keys.ENTER) 
        .build()
        .perform();
	}
}

package pages;

import java.util.Properties;

import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {

	public LoginPage(RemoteWebDriver driver,Properties prop) {
		
		this.driver=driver;
		this.prop=prop;
	}
	
	public LoginPage enterUserName() {
		driver.findElementById(prop.getProperty("LoginPage.Username.ID")).sendKeys(prop.getProperty("username"));
		return this;
	}
	
	public LoginPage enterPassword() {
		driver.findElementById(prop.getProperty("LoginPage.Password.ID")).sendKeys(prop.getProperty("password"));
		return this;

	}
	
	public CrmsfaPage clickLogin() {
		driver.findElementByClassName(prop.getProperty("LoginPage.LoginButton.ClassName")).click();
		return new CrmsfaPage(driver,prop);

	}
	
}

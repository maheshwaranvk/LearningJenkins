package pages;

import java.util.Properties;

import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificMethods;

public class CrmsfaPage extends ProjectSpecificMethods{

	public CrmsfaPage(RemoteWebDriver driver,Properties prop) {
		this.driver=driver;
		this.prop=prop;
	}
	public MyHomePage clickCrmsfaLink() {
	
		driver.findElementByLinkText(prop.getProperty("HomePage.CRMSFA.linktext")).click();
		return new MyHomePage(driver,prop);
		
	}
}

package pages;

import java.util.Properties;

import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificMethods;

public class ViewLeadPage extends ProjectSpecificMethods{
	
	public ViewLeadPage(RemoteWebDriver driver,Properties prop) {
		this.driver = driver;
		this.prop=prop;
	}

	public ViewLeadPage viewPage() {
		System.out.println("LeadCreated");
		return this;

	}
	
	public MyLeadsPage clickDelete() throws InterruptedException {
		driver.findElementByXPath("//a[@class='subMenuButtonDangerous']").click();
		Thread.sleep(2000);
		return new MyLeadsPage(driver,prop);

	}
	
	public EditLeadPage clickEdit() {
		driver.findElementByXPath(prop.getProperty("ViewLead.EditButton.xpath")).click();
		return new EditLeadPage(driver,prop);
	}
	
	public void getLeadID() {
		String text = driver.findElementById("viewLead_companyName_sp").getText();
		leadID = text.replaceAll("\\D", "");
		System.out.println(leadID);
			}
}

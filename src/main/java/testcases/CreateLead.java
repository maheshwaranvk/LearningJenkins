package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import base.ProjectSpecificMethods;
import pages.LoginPage;

public class CreateLead extends ProjectSpecificMethods{
	
	
	@BeforeTest
	public void getExcel() {
		excelFileName="CreateLead1";

	}
	
	@Test(dataProvider="fetchdata")
	public void runCreateLead(String cName, String fName, String lName) {
		new LoginPage(driver,prop)
		.enterUserName()
		.enterPassword()
		.clickLogin()
		.clickCrmsfaLink()
		.clickLeads()
		.clickCreateLeads()
		.enterCompName(cName)
		.enterFirstName(fName)
		.enterLastName(lName)
		.clickCreateLeadButton()
		.viewPage().getLeadID();

	}
}

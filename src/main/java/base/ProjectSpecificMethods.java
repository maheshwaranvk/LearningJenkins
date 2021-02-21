package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcelData;

public class ProjectSpecificMethods {

	public RemoteWebDriver driver;
	public static String excelFileName;
	public Properties prop;
	public static String leadID;
	
	@Parameters({"lang"})
	@BeforeMethod
	public void launchApplication(String lang) throws IOException {
		
		FileInputStream fs = new FileInputStream("./src/main/resources/"+lang+".properties");
		prop = new Properties();
		prop.load(fs);
		
		
		WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
			driver.get(prop.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@DataProvider(name="fetchdata")
	public String[][] readxcelData() throws IOException {
		return new ReadExcelData().readExcel(excelFileName);

	}
	
	
	/*
	 * @AfterMethod public void closeBrowser() { driver.close();
	 * 
	 * }
	 */
	
}

package amazon.qa.pageLayerTest;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import amazon.qa.Basepage.Basepage;
import amazon.qa.elementUtility.elementUtility;
import amazon.qa.pageLayers.loginPage;


public class loginPageTest 
{
	Basepage basepage;
	WebDriver driver;
	Properties prop;
	loginPage loginpage;
	elementUtility ele;
	
	@BeforeMethod
	public void brosetup()
	{
		basepage = new Basepage();
		prop = basepage.int_properties();
		String Browsername = prop.getProperty("browser");
		driver = basepage.int_browser(Browsername);
		driver.get(prop.getProperty("url"));
		loginpage = new loginPage(driver);
	}
	
	
	@Test
	public void getTitleTest()
	{
		String title = loginpage.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}
	
	@Test()
	public void allLinkTest()
	{
	    loginpage.getAllLink();
		
	}
	
	@Test
	public void loginTest()
	{
		loginpage.dologin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
		
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
	

}

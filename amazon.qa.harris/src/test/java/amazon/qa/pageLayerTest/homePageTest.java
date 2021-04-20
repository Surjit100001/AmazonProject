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
import amazon.qa.pageLayers.homePage;
import amazon.qa.pageLayers.loginPage;

public class homePageTest 
{
	Basepage basepage;
	WebDriver driver;
	Properties prop;
	loginPage loginpage;
	homePage homepage;
	 
	
	@BeforeMethod
	public void setup()
	{
		basepage = new Basepage();
		prop = basepage.int_properties();
		String Browsername = prop.getProperty("browser");
		driver = basepage.int_browser(Browsername);
		driver.get(prop.getProperty("url"));
		loginpage = new loginPage(driver);
		homepage = loginpage.dologin(prop.getProperty("username"), prop.getProperty("password"));
		homepage = new homePage(driver);
		
	}
	
	@Test
	public void getTitleHomeTest()
	{
		String homeTitle = homepage.getTitleHome();
		System.out.println(homeTitle);
		Assert.assertEquals(homeTitle, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}
	
	@Test
	public void accounTypeLists()
	{
		 homepage.accounTypeLists();
		
	}
	
	@Test
	public void searchBoxTest()
	{
		homepage.searchBox(prop.getProperty("mobileSearch"));
	}
	
		
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}

package amazon.qa.Basepage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basepage 
{
	WebDriver driver;
	Properties prop;
	
	public WebDriver int_browser(String Browsername)
	{
		System.out.println("current bro: " +Browsername);
		
		if(Browsername.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(Browsername.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("pls pass correct browser");
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	//	driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}
	
	public Properties int_properties()
	{
		prop = new Properties();
		
		String path = "./src/main/java/configure/properties/File/confi.prop";
		try {
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("not found");
		} catch (IOException e) {
			System.out.println("not loaded");
		}
		return prop;
	}
	
	public String getScreenshot()
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") +"/screenshots/" + System.currentTimeMillis() + ".png";
		File dest = new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return path;
	}


}

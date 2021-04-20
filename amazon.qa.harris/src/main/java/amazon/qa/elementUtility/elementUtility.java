package amazon.qa.elementUtility;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class elementUtility 
{
	WebDriver driver;
	
	public elementUtility(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public WebElement findElement(By locator)
	{
		return driver.findElement(locator);
	}
	
	public List<WebElement> findElements(By locator)
	{
		return driver.findElements(locator);
	}
	
	
	public void sendKeys(By locator, String value)
	{
		driver.findElement(locator).sendKeys(value);
	}
	
	public void clickButton(By locator)
	{
		driver.findElement(locator).click();
	}
	
	
	//********************* 
	
	public boolean elesmentIsSelected(By locator)
	{
		return driver.findElement(locator).isSelected();
	}
	
	public boolean elesmentIsDisplayed(By locator)
	{
		return driver.findElement(locator).isDisplayed();
	}
   
	public boolean elesmentIsEnabled(By locator)
	{
		return driver.findElement(locator).isEnabled();
	}

	//********************** waits*********
	
	public void WebDriverWait(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	//*******************************All Links get Attribute ********************** 
	
	public List<WebElement> getAllLinks(By locator)
	{
		List<WebElement> allLinks = driver.findElements(locator);
		System.out.println("Total available links ==>" +allLinks.size());
		
		for(int i=0; i<=allLinks.size()-1; i++)
		{
			String hrefLinks = allLinks.get(i).getAttribute("href");
			try {
				URL url = new URL(hrefLinks);
				URLConnection urlconnection = url.openConnection();
				
				HttpURLConnection httpurlconnection = (HttpURLConnection)urlconnection;
				httpurlconnection.setConnectTimeout(5000);
				httpurlconnection.connect();
				
				if(httpurlconnection.getResponseCode() == 200)
				{
					System.out.println(hrefLinks+ "=>" +httpurlconnection.getResponseMessage()+ "=>" +httpurlconnection.getResponseCode());
				}
				else
				{
					System.err.println(hrefLinks+ "=>" +httpurlconnection.getResponseMessage()+ "=>" +httpurlconnection.getResponseCode());
				}
				
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		return allLinks;
	}
	

}

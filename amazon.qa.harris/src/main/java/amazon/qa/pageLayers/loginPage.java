package amazon.qa.pageLayers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import amazon.qa.Basepage.Basepage;
import amazon.qa.elementUtility.elementUtility;


public class loginPage extends Basepage
{
	WebDriver driver;
    elementUtility ele;
    
   // By signinMove = By.xpath("//span[@id=\"nav-link-accountList-nav-line-1\"]");
    By signinClick = By.xpath("//span[text() = 'Sign in']");
    By username = By.xpath("//input[@id=\"ap_email\"]");
    By password = By.xpath("//input[@id=\"ap_password\"]");
	By signinbutton = By.xpath("//input[@id=\"signInSubmit\"]");
	By usernameclick = By.xpath("//input[@id=\"continue\"]");
	By allLinks = By.tagName("a");
	
	 public loginPage(WebDriver driver)
	{
		this.driver = driver;
		ele = new elementUtility(driver);
	}
	
	public String getTitle()
	{
	    return ele.getTitle();
	}
	
	public List<WebElement> getAllLink()
	{
	   return ele.getAllLinks(allLinks);
	}
	
	public homePage dologin(String username, String password)
	{
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[@id=\"nav-link-accountList\"]"))).build().perform();
		ele.clickButton(signinClick);
		
		ele.sendKeys(this.username, username);
		ele.clickButton(usernameclick);
		ele.sendKeys(this.password, password);
		ele.clickButton(signinbutton);
		
		return new homePage(driver);
	
	}

	
	
	
	
	
	
	
	

}

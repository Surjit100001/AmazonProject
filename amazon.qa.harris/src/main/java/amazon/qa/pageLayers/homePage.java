package amazon.qa.pageLayers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import amazon.qa.Basepage.Basepage;
import amazon.qa.elementUtility.elementUtility;

public class homePage extends Basepage
{
	WebDriver driver;
	elementUtility ele;
	
	By accounTypeList = By.xpath("//div[@id=\"nav-al-container\"]/div");
	By searchBox = By.xpath("//input[@id=\"twotabsearchtextbox\"]");
	By searchBoxButton = By.xpath("//input[@id=\"nav-search-submit-button\"]");
	By failed = By.xpath("mobileSearch");
	
	
	
	public homePage(WebDriver driver)
	{
		this.driver = driver;
		ele = new elementUtility(driver);
	}
	
	public String getTitleHome()
	{
		return ele.getTitle();
	}
	
	public List<WebElement> accounTypeLists()
	{
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[@id=\"nav-link-accountList\"]"))).build().perform();
		
		List<WebElement> accounTypeAllList = driver.findElements(accounTypeList);
		
		for(int i=0; i<=accounTypeAllList.size()-1; i++)
		{
			String text = accounTypeAllList.get(i).getText();
			System.out.println(text);
			
			if(accounTypeAllList.get(i).isEnabled())
			{
				System.out.println(accounTypeAllList+ "==> true");
			}
			else
			{
				System.err.println(accounTypeAllList+ "==> false");
			}
			 
		}
		
		return accounTypeAllList;
		
		
	}
	
	public void searchBox(String value)
	{
		ele.sendKeys(searchBox, value);
		ele.clickButton(searchBoxButton);
		
	}

}

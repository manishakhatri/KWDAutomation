package WebElementLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElements {
	public WebDriver driver;
	public WebElements(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getWebElement(String locator, String locatorvalue)
	{
WebElement we = null;
		
		switch(locator)
		{
		case "id":
			we = driver.findElement(By.id(locatorvalue));
			break;
		
		case "name":
			we=driver.findElement(By.name(locatorvalue));
			break;
		
		case "xpath":
//			System.out.println("I am in- ");
			we=driver.findElement(By.xpath(locatorvalue));
			break;
			
		case "linkText":
			we=driver.findElement(By.linkText(locatorvalue));
			break;
		}
		return we;
	}
}
	



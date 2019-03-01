package UIKeywordsLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import WebElementLibrary.WebElements;

public class UIKeywords {
	
	public static WebDriver driver=null;
	static WebElements wel=null;
	
	public static boolean enterText(WebDriver driver,String Locator,String Locatorvalue,String data)
	{    boolean result;
		 wel= new WebElements(driver);
		
		 try {
			wel.getWebElement(Locator, Locatorvalue).sendKeys(data);
					result=true;
		  } catch (Exception e) {
			// TODO Auto-generated catch block
			 
			System.out.println(" Not able to send the text to the webelement");
			result=false;
		}
		return result;
	}
	
	public static boolean click(WebDriver driver,String Locator,String Locatorvalue) {
		boolean result;
		try
		{
		wel=new WebElements(driver);
		WebElement	we=wel.getWebElement(Locator, Locatorvalue);
		   Thread.sleep(5000);
		   we.click();
		   result=true;
		}
		catch(Exception e)
		{
			System.out.println(" Not able to click the webelement");
			result=false;
		}
		return result;
}
}

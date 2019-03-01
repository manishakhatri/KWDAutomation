package Runner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;

import UIKeywordsLibrary.UIKeywords;

public class ExecuteKeywords {
	static UIKeywords uik=null;
	public static void execute(WebDriver driver, String Keyword) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		uik = new UIKeywords();
		
		Method[] funcdet=uik.getClass().getDeclaredMethods();
		
		 boolean moduleExec=false;
		 for(int i=0;i<funcdet.length;i++)
		 {
			 if(Keyword.equals(funcdet[i].getName()))
			 {
				 if(!DriverScript.Locator.equals("")&& DriverScript.parametercount==0)
				 {
					 
					 funcdet[i].invoke(uik, DriverScript.driver,DriverScript.Locator,DriverScript.Locator_Value);
				 }
				 if(!DriverScript.Locator.equals("")&& DriverScript.parametercount==1)
				 {
					 
					 funcdet[i].invoke(uik, DriverScript.driver,DriverScript.Locator,DriverScript.Locator_Value,DriverScript.ParaValue1);
				 }
				 if(!DriverScript.Locator.equals("")&& DriverScript.parametercount==2)
				 {
					 
					 funcdet[i].invoke(uik, DriverScript.driver,DriverScript.Locator,DriverScript.Locator_Value,DriverScript.ParaValue1,DriverScript.ParaValue2);
				 }
				 if(!DriverScript.Locator.equals("")&& DriverScript.parametercount==3)
				 {
					 
					 funcdet[i].invoke(uik, DriverScript.driver,DriverScript.Locator,DriverScript.Locator_Value,DriverScript.ParaValue1,DriverScript.ParaValue2,DriverScript.ParaValue3);
				 }
				 if(!DriverScript.Locator.equals("")&& DriverScript.parametercount==4)
				 {
					 
					 funcdet[i].invoke(uik, DriverScript.driver,DriverScript.Locator,DriverScript.Locator_Value,DriverScript.ParaValue1,DriverScript.ParaValue2,DriverScript.ParaValue3,DriverScript.ParaValue4);
				 }
			 }
		 }
			 
}
}

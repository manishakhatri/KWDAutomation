package Runner;


import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;

import ExcelKeywordsLibrary.ExcelKeywords;

public class DriverScript {
	public static String basiclocation=null;
	public static String driverfileloc=null;
	public static String driverfilename="DriverSheet_trial.xlsx";
	public static String driversheetname="MasterSheet";
	public static String componentfileloc=null;
	public static String componentfilename="TestComponents_trial.xlsx";
	public static String componentsheetname="TestComponents";
	public static String orfileloc=null;
	public static String orfilename="OR_Trial.xlsx";
	public static String orsheetname="Register_OR";
	public static String datasheetloc=null;
	public static String datasheetfilename="DataSheet_trial.xlsx";
	public static String datasheetname="Test_DataSheet";
	public static Sheet ms=null;
	public static Sheet cs=null;
	public static Sheet ors=null;
	public static Sheet ds=null;
	public static WebDriver driver=null;
	public static String TCID,Run,Browser,DataSheetName;
	
	public static int cs_cellValue;
	public static int ColCount,ColCount_cs;
	public static String objName,ObjectName;
	public static int obj_Row,dataColNo;
	public static String ParaValue1=null;
	public static String ParaValue2=null;
	public static String ParaValue3=null;
	public static String ParaValue4=null;
	public static String Locator=null;
	public static String Locator_Value=null;
	static String Keyword=null;
	static int parametercount;
	 
	
	public static void main(String args[]) throws Exception
	{
		basiclocation="C:\\Users\\Manisha\\KWDFW_WS";
		driverfileloc=basiclocation+"\\DriverSheet";
		componentfileloc=basiclocation+"\\TestComponent";
		orfileloc=basiclocation+"\\ObjectRepository";
		datasheetloc=basiclocation+"\\DataSheet";
		ExcelKeywords excel=new ExcelKeywords();
		cs=excel.returnSheet(componentfileloc, componentfilename, componentsheetname);
		ors=excel.returnSheet(orfileloc, orfilename, orsheetname);
		ds=excel.returnSheet(datasheetloc, datasheetfilename, datasheetname);
		ms=excel.returnSheet(driverfileloc, driverfilename, driversheetname);
		
		int Total_Scenarios=excel.RowCount(ms);
		
		for(int i=1;i<Total_Scenarios;i++)
		{
			int ColCount=excel.ColCount(ms, i);
			System.out.println("value for ColCount is"+ColCount);
			TCID=excel.getCellValue(ms, i, 0);
			Run=excel.getCellValue(ms, i, 1);
			Browser=excel.getCellValue(ms, i, 2);
			System.out.println("value for TCID is"+TCID);
		
			for(int j=3;j<ColCount;j++)
			{
				String componentName=excel.getCellValue(ms, i, j);
				int last_Row=excel.returnreverseStringRow(cs, componentName, 1);
				System.out.println("componentName is"+componentName);
				int first_Row=excel.returnStringRow(cs, componentName, 1);
				System.out.println("first_Row is"+first_Row);
				System.out.println("last_Row is"+last_Row);
				for(int k=first_Row;k<=last_Row;k++)
				{
					ColCount_cs=excel.ColCount(cs, k);
					String ComponentID=excel.getCellValue(cs, k, 0);
					String ComponentName=excel.getCellValue(cs, k, 1);	
					String ComponentSteps=excel.getCellValue(cs, k, 2);
					String Keyword=excel.getCellValue(cs, k, 3);
					String Object=excel.getCellValue(cs, k, 4);
					String TestParameter1=excel.getCellValue(cs, k, 5);
					String TestParameter2=excel.getCellValue(cs, k, 6);
					String TestParameter3=excel.getCellValue(cs, k, 7);
					String TestParameter4=excel.getCellValue(cs, k, 8);
					
					System.out.println("value for ComponentID is" +ComponentID);
					System.out.println("value for ComponentName is" +ComponentName);
					System.out.println("value for ComponentSteps is" +ComponentSteps);
					System.out.println("value for Keyword is" +Keyword);
					System.out.println("value for Object is" +Object);
					System.out.println("value for TestParameter1 is" +TestParameter1);
					System.out.println("value for TestParameter2 is" +TestParameter2);
					try {
					int obj_Row=excel.returnStringRow(ors, Object, 0);
					System.out.println("value for obj_Row is" +obj_Row);
					String Locator=excel.getCellValue(ors, obj_Row, 1);
					String Locator_Value=excel.getCellValue(ors, obj_Row, 2);
					System.out.println("Locator is" +Locator);
					System.out.println("Locator value is" +Locator_Value);
					
					

					if (!TestParameter1.equals("")) {
						int dataColNo=excel.returnStringCol(ds,TestParameter1,0);
						System.out.println("value for dataColNo is" +dataColNo);
						String ParaValue1=excel.getCellValue(ds, i, dataColNo);
						System.out.println("ParaValue1 is" +ParaValue1);
						parametercount++;
						
					}
						if (!TestParameter2.equals(null)) {
							int dataColNo=excel.returnStringCol(ds,TestParameter2,0);
							String ParaValue2=excel.getCellValue(ds, i, dataColNo);
							System.out.println("ParaValue2 is" +ParaValue2);
							parametercount++;
						}
						if (!TestParameter3.equals(null)) {
							int dataColNo=excel.returnStringCol(ds,TestParameter3,0);
							String ParaValue2=excel.getCellValue(ds, i, dataColNo);
							System.out.println("ParaValue3 is" +ParaValue3);
							parametercount++;
						}
						if (!TestParameter4.equals(null)) {
							int dataColNo=excel.returnStringCol(ds,TestParameter4,0);
							String ParaValue2=excel.getCellValue(ds, i, dataColNo);
							System.out.println("ParaValue4 is" +ParaValue4);
							parametercount++;
						}
						ExecuteKeywords.execute(driver, Keyword);
					//callKeyword();
						
							
							}
					catch(Exception e)
					{
						//System.out.println("Exception occured");
					}
					
						}
						
					//else
					//{
						//break;
					//}
					//}
					
					
					
					}
					
				

						
                     
					
				}
				
			
			}
		}
		
		
	/*
	 public static void callKeyword() throws Exception
	{
	switch (Keyword)
	{
		case "type":
		
		{
			UIKeywords.enterText(driver, Locator, Locator_Value, ParaValue1);
			break;
		}
		
        case "click":
		
		{
			UIKeywords.click(driver, Locator, Locator_Value);
			break;
		}
        
        case "LinkText":
		
		{
			UIKeywords.clickLink(driver, Locator, Locator_Value);
			break;
		}
		
        case "openURL":
			
		{
			WebDriver driver=new ChromeDriver();
			ui.LoadApplication(driver,"Chrome",ParaValue1);
			break;
		}
        
       
		}
	} 	
	 */
		
	



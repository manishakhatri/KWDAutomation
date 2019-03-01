package ExcelKeywordsLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelKeywords {
	
		//Created By :- Abhishek Jain
		//Created Date :- 3/25/2017
		//This function is going to return the sheet from which data is to be picked
		//Parameters of function - 
		//fileloc - location at which file is saved
		//filename - Name of the file with extension
		//sheetname - sheet from which data is to be picked
		@SuppressWarnings("resource")
		public static Sheet returnSheet(String fileloc, String filename, String sheetname) throws Exception
		{
			//Create complete file path
			String filepath = fileloc +"\\"+filename;
			//create file object which contains the reference of excel file
			File file = new File(filepath);
			//Create fileinputstream object which is going to give access
			FileInputStream fileinp = new FileInputStream(file);
			//Create workbook object
			Workbook wb = null;
			//There are two extensions of excel file. Get extension on run time
			//Indexof function is going to give the location at which '.' comes in filename
			//Substring is going to give the string after '.' which is the extension
			String fileextn = filename.substring(filename.indexOf("."));
			if (fileextn.equals(".xlsx")){
				//if the extension is xlsx we create XSSFWorkbook object
//				System.out.println("create wb object");
				wb = new XSSFWorkbook(fileinp);
			}
			else if(fileextn.equals(".xls")){
				//if the extension is xls we create HSSFWorkbook object
				wb = new HSSFWorkbook(fileinp);
			}
			//Create sheet object and getting the access of the specific sheet in the workbook
			Sheet sh = (Sheet) wb.getSheet(sheetname);
			return sh;
		}
			
		//Created By :- Abhishek Jain
		//Created Date :- 3/25/2017
		//This function is going to return the cell calue from the specific sheet
		//parameters of function - 
		//sh - object of the sheet returned from returnSheet function
		//rownum - row number of the cell
		//colnum - column number of the cell
		@SuppressWarnings("deprecation")
		public static String getCellValue(Sheet sheet,int rownum,int colnum)
		{ 
			Cell c= sheet.getRow(rownum).getCell(colnum);
		   int type;
		   Object val = null;
		 if(null!=c)
		 {
		   type=c.getCellType();
		   switch(type)
			{
				case 0:
					if (HSSFDateUtil.isCellDateFormatted(c)) {
		                System.out.println("The cell contains a date value: " + c.getDateCellValue());
		                Date d= c.getDateCellValue();
		                SimpleDateFormat dt=new SimpleDateFormat("MM/dd/yyyy");
		                val= dt.format(d);	
		                 break;
		            }
					c.setCellType(Cell.CELL_TYPE_STRING);
					val=c.getStringCellValue();
				// val=	cell1.getNumericCellValue();
					break;
				case 1:
					 val=	c.getStringCellValue();
					break;
				case 3:
					val="";
				break;
				default:
					throw new RuntimeException("There are no support for this type of cell");
			}
			return val.toString();
			
		}
		 else
		 {
		return "";
		}
	}
		
		
		//Created By :- Abhishek Jain
		//Created Date :- 3/25/2017
		//This function is going to return the total number of rows occupied in the the sheet
		//Parameters - 
		//sh - object of the sheet returned from returnSheet function
		public static int RowCount(Sheet sh)
		{
			int rcount=((XSSFSheet )sh).getLastRowNum()+1;
			return rcount;
		}

		//Created By :- Abhishek Jain
		//Created Date :- 3/25/2017
		//This function is going to return the total number of columns occupied in the the sheet
		//Parameters - 
		//sh - object of the sheet returned from returnSheet function
		//rownum - rownumber specific to which total number of columns is to be identified
		public static int ColCount(Sheet sh, int rownum)
		{
			 int col=((XSSFSheet )sh).getRow(rownum).getLastCellNum();
			 return col;
		}
			
			public static String getcellvaluestring(Sheet sheet,int rownum,int colnum )
			{
				String val=((Sheet )sheet).getRow(rownum).getCell(colnum).getStringCellValue();
				return val;
			}
			// TODO Auto-generated method stub

		
			public static int returnStringRow(Sheet sheetobj, String objectname, int colnum) throws Exception
			{
				int rowvalue = 0;
				int totalrows =  RowCount(sheetobj);
			//	System.out.println("total row count is " + totalrows);
				for(int i = 0;i<totalrows;i++)
				{
					if(objectname.equals(getCellValue(sheetobj,i,colnum)))
					{
						rowvalue=i;
						break;
					}
				}
				if(rowvalue==0)
				{
					throw new RuntimeException("No matching Row found for  " + objectname + " . Please create the valid row  or edit it if alraedy created");
				}
				return rowvalue;
			}
			
			public static int returnStringCol(Sheet sheetobj, String objectname, int rownum) throws Exception
			{
				int colvalue=0;
				int totalcol =  ColCount(sheetobj,rownum);
				for(int i = 0;i<totalcol;i++)
				{
					if(objectname.equals(getCellValue(sheetobj,rownum,i)))
					{
						colvalue=i;
						break;
					}
					
				}
				
				if(colvalue==0)
				{
					throw new RuntimeException("No matching testdata column found for  " + objectname + " . Please create the valid testdata column or edit it if alraedy created");
				}
				return colvalue;
			}


			public static int returnreverseStringRow(Sheet sheetobj, String objectname, int colnum) throws Exception
			{
				int rowvalue = 0;
				int totalrows =  RowCount(sheetobj);
				//System.out.println("total row count is " + totalrows);
				for(int i =totalrows-1;i>0;i--)
				{
					if(objectname.equals(getCellValue(sheetobj,i,colnum)))
					{
						rowvalue=i;
						break;
					}
				}
				
				return rowvalue;
			}
			

		

}


package com.wolverine.utils.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataHandlers {
	public static void storeDataToExcel(String filePath, String sheetName,
			int rowIndex, int cellIndex, String data)
	{
		try
		{
			File f = new File(filePath);
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sheetName);
			Row r = st.getRow(rowIndex);
			Cell c = r.getCell(cellIndex);
			c.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void storeDataToProperties(String filePath, String key,
			String value, String comment)
	{
		try
		{
			File f = new File(filePath);
			FileInputStream fis = new FileInputStream(f);
			Properties prop = new Properties();
			prop.load(fis);
			prop.setProperty(key, value);
			FileOutputStream fos = new FileOutputStream(f);
			prop.store(fos, comment);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static String getDataFromExcel(String filePath, 
			String sheetName, int rowIndex, int cellIndex)
	{
		String data = null;
		try
		{
			File f = new File(filePath);
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sheetName);
			Row r = st.getRow(rowIndex);
			Cell c = r.getCell(cellIndex);
			data = c.toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	public static String getDataFromProperties
	(String filePath, String key)
{
String data = null;
try
{
File f = new File(filePath);
FileInputStream fis = new FileInputStream(f);
Properties prop = new Properties();
prop.load(fis);
data = prop.get(key).toString();
}
catch(Exception e)
{
e.printStackTrace();
}
return data;
}
}

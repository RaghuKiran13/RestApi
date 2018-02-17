package com.techmahindra.nad.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GenericLib {
	public static String sDir=System.getProperty("user.dir");
	public static String rDir=sDir+"//src//test//resources//testdata";
	public static String gitLabTestDataPath=rDir+"//gitlab";
	//Function to write Date and Time
	public static String timestamp(){
		String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		return timestamp;
	}
	
	/*//Function to write data to a File
	public static void writedata(String actualOutput)
	{
		final String FILENAME = "F:\\POC\\POC\\test.json";
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String content = actualOutput;

			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write(content);

			//System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
	}*/
	
	//Function to retrieve data from Properties file
	public static String getConfigValue(String sFile, String sKey) {
		Properties prop = new Properties();
		String sValue = null;
		try {
			InputStream input = new FileInputStream(sFile);
			prop.load(input);
			sValue = prop.getProperty(sKey);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sValue;
	}

	//Function to write data to Properties file
	public static void setConfigValue(String sFile, String sKey, String sValue) {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(new File(sFile));
			prop.load(fis);
			fis.close();

			FileOutputStream fos = new FileOutputStream(new File(sFile));
			prop.setProperty(sKey, sValue);
			prop.store(fos, "Updating folder path");
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * To read data from excel sheet
	 */
	public static String[] excelData_String(String filePath,String sheetName,String sTestCaseID)
	{
		String sData[]=null;
		try
		{
			FileInputStream fis = new FileInputStream(filePath);
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet(sheetName);
			int iRowNum= sht.getLastRowNum();
			int k=0;
			for(int i=1;i<=iRowNum;i++)
			{
				if(sht.getRow(i).getCell(0).toString().equals(sTestCaseID))
				{
					int iCellNum=sht.getRow(i).getLastCellNum();
					sData= new String[iCellNum];
					for(int j=0;j<iCellNum;j++)		
					{
						sData[j]=sht.getRow(i).getCell(j).getStringCellValue();		
					}
					break;
				}
			}	
		}
		catch(Exception e)
		{	
			e.printStackTrace();
		}
		return sData;
	}
	public static Integer[] excelData_Integer(String filePath,String sheetName,String sTestCaseID)
	{
		Integer sData[]=null;
		try
		{
			FileInputStream fis = new FileInputStream(filePath);
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet(sheetName);
			int iRowNum= sht.getLastRowNum();
			int k=0;
			for(int i=1;i<=iRowNum;i++)
			{
				if(sht.getRow(i).getCell(0).toString().equals(sTestCaseID))
				{
					int iCellNum=sht.getRow(i).getLastCellNum();
					sData= new Integer[iCellNum];
					for(int j=1;j<iCellNum;j++)		
					{
						sData[j]=(int) sht.getRow(i).getCell(j).getNumericCellValue();		
					}
					break;
				}
			}	
		}
		catch(Exception e)
		{	
			e.printStackTrace();
		}
		return sData;
	}
	/*
	 * To write data into excel sheet
	 */
	public static void toWriteExcelData(String filePath,String sheetName,String sTestCaseID,String value)
	{
		try
		{
			FileInputStream fis = new FileInputStream(filePath);
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet(sheetName);
			int iRowNum = sht.getLastRowNum();
			for (int i = 0; i <= iRowNum; i++) {
			if (sht.getRow(i).getCell(0).toString().equalsIgnoreCase(sTestCaseID)) {
				sht.getRow(i).getCell(1).setCellValue(value);
				//sht.getRow(i).getCell(2).setCellValue(password);
				}
			}
			FileOutputStream fos = new FileOutputStream(filePath);
			wb.write(fos);
		}
		catch(Exception e)
		{	
			e.printStackTrace();
		}
	}
	
}

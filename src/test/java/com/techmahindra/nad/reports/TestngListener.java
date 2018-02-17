/***********************************************************************
 * @author 			:		
 * @description		: 		Implemented ITestListener interface and overrided methods as per requirement. It listenes to all the events performed by Testng and keep track of it.
 */
package com.techmahindra.nad.reports;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.activation.DataSource;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;
import java.util.List;
import java.util.Map;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
public class TestngListener implements ITestListener {
	public static File sHtmlReports;
	public static File sTestngReports;
	public static File sPdfReports;
	public static String sdateTime;
	public static String sdate;
	public static int iPassCount=0;
	public static int iFailCount=0;
	public static int iSkippedCount=0;
	static public String sDirPath = System.getProperty("user.dir");
	public static ArrayList sTestName= new ArrayList<String>();
	public static ArrayList sStatus= new ArrayList<String>();
	public static ArrayList sDescription= new ArrayList<String>();
	public TestngListener() throws IOException 
	{
		Date date = new Date();
		SimpleDateFormat sdtf=new SimpleDateFormat("dd-MM-yyyy_hh_mm_ss");
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		sdateTime = sdtf.format(date);
		sdate = sdf.format(date);
		sHtmlReports=new File(sDirPath+"//..//Reports//HTMLReports");

		if(!sHtmlReports.exists())
		{
			FileUtils.forceMkdir(sHtmlReports);

		}
		System.setProperty("KIRWA.reporter.config", "KIRWA.properties");	
	}

	public void onTestStart(ITestResult result) 
	{
//		GenericLib.setCongigValue(GenericLib.sConfigFile, "DATE", sdateTime);
	}

	public void onTestSuccess(ITestResult result) 
	{
		sDescription.add(result.getMethod().getDescription());
		iPassCount = iPassCount+1;
		//GenericLib.setStatus(result.getName().toString(), "Passed",sTestName,sStatus);
	}

	public void onTestFailure(ITestResult result) 
	{
		sDescription.add(result.getMethod().getDescription());
		iFailCount = iFailCount+1;
		//GenericLib.setStatus(result.getName().toString(), "Failed",sTestName,sStatus);
		//NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}

	public void onTestSkipped(ITestResult result) 
	{
		sDescription.add(result.getMethod().getDescription());
		iSkippedCount = iSkippedCount+1;
//		GenericLib.setStatus(result.getName(), "Skipped",sTestName,sStatus);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
	}

	public void onStart(ITestContext context) 
	{
	}

	public void onFinish(ITestContext context) 
	{
		Set<ITestResult> failedTests = context.getFailedTests().getAllResults();
		for (ITestResult temp : failedTests) {
			ITestNGMethod method = temp.getMethod();
			if (context.getFailedTests().getResults(method).size() > 1) {
				failedTests.remove(temp);
			} else {
				if (context.getPassedTests().getResults(method).size() > 0) {
					failedTests.remove(temp);
				}
			}
		}
		File testOuput = new File(sDirPath+"\\test-output");    
		String sTestngReports= sDirPath+"\\..\\Reports\\TestNGReports\\TestNG_"+sdateTime;	
		File pdfReports = new File(sPdfReports+"\\PDFReports"+sdateTime+".pdf");
		iPassCount=context.getPassedTests().size(); 
		iFailCount=context.getFailedTests().size(); 
		iSkippedCount=context.getSkippedTests().size(); 
		int iTotal_Executed = iPassCount+iFailCount+iSkippedCount;
		//sendMail(iPassCount, iFailCount, iSkippedCount, iTotal_Executed, pdfReports);
		try

		{
			FileUtils.copyDirectoryToDirectory(testOuput,new File(sTestngReports));
			System.out.println("testoutput is moved");
		}
		catch(Exception e)
		{
			System.out.println("testoutput is not moved");
		}
	}

}

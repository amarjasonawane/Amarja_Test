package jarvis.scripts;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import base.FrameworkConstants;
import pageObjects.BooksPage;
import pageObjects.FileUploadPage;
import pageObjects.PDFPage;
import utilities.CustomMethods;
import utilities.ExcelLibrary;
import utilities.Reporter;
import utilities.WebDriverActions;

@Listeners(utilities.Listener.class)
public class FileUpload extends BaseClass{
	
	WebDriverActions ui;
	ExcelLibrary excel;
	SoftAssert s;
	
	FileUploadPage fp;
	PDFPage pp;
	ReusableMethods reu;
	
	
	@Test(priority=0, enabled=true)
	public void SampleTest() throws Exception {
		ui=new WebDriverActions();
		s=new SoftAssert();
	//	excel=new ExcelLibrary();
		fp=new FileUploadPage();
		reu=new ReusableMethods();
		
		getDriver().get(cs.getProperty("url1"));
		
		long start=fp.start();
			
		String file=reu.renameExcel("DemoFiles", "Demo.xlsx", 12);
		
		ui.uploadFCMFile(fp.chooseFileBtn,file);
		Reporter.pass("File is uploaded");
		
		ui.click(fp.acceptTerms);
		Reporter.pass("Accept terms checkbox is clicked");
		
		ui.click(fp.submitBtn);
		Reporter.pass("Submit Button is clicked",true);
		
		Thread.sleep(2000);
		Reporter.pass("File Uploaded Message:"+ui.getText(fp.uploadMsg),true);
		
		Thread.sleep(2000);
		
		ui.refreshPage(getDriver());
		String msg=ui.getText(fp.uploadMsg);
		
/*		if(msg.equalsIgnoreCase("1 file has been successfully uploaded.")) {
			Reporter.pass("File uploaded successfully");
			long ffinish=fp.start();
			long total=fp.end(start, ffinish);
			Reporter.pass("Time required only for file upload is:"+total);
		}*/
		
		long ffinish=fp.start();
		long total=fp.end(start, ffinish);
		long sec=total/1000;
		Reporter.pass("Time required only for file upload in Seconds is:"+sec);
		
		ui.closeBrowser(getDriver());
		
		System.out.println("Updated Commit");
		
	}
	
	

}

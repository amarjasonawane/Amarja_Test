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
public class PDFFile extends BaseClass{
	
	WebDriverActions ui;
	ExcelLibrary excel;
	SoftAssert s;
	
	PDFPage pp;
	ReusableMethods reu;
	
	@Test(priority=0, enabled=true)
	public void SampleTest() throws Exception {
		ui=new WebDriverActions();
		s=new SoftAssert();
	//	excel=new ExcelLibrary();
		pp=new PDFPage();
		reu=new ReusableMethods();
		
		getDriver().get(cs.getProperty("url2"));
			
		String file="C:\\Users\\12943\\git\\ExpleoFramework\\resources\\TestFile.pdf";
		int index=file.lastIndexOf("\\") +1;
		String fName=file.substring(index);
		
		ui.uploadFCMFile(pp.chooseFile,file);
		Reporter.pass("File is uploaded");
		
		ui.click(pp.compressPDF);
		Reporter.pass("Compress pdf is clicked");
		
		Thread.sleep(3000);
		Reporter.pass("File is downloaded",true);
		
		Thread.sleep(30000);
		
		File f1=ui.getTheNewestFile(FrameworkConstants.getDownloadpath(), "pdf");
		Reporter.pass("File Name :"+f1);
		
		String downloadFile=f1.toString();
		int index1=downloadFile.lastIndexOf("\\") + 1;
		String fName1=downloadFile.substring(index1);
		Reporter.pass("File Name is:"+fName1);
		
		s.assertTrue(CustomMethods.readAndAssert(fName1, "Internal career fair"), "Internal career fair");
		Thread.sleep(3000);
		Reporter.pass("Contents are present");
		
		s.assertAll();
		
		ui.closeBrowser(getDriver());
	
	}

}

package jarvis.scripts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import pageObjects.FileUploadPage;
import pageObjects.PDFPage;
import utilities.ExcelLibrary;
import utilities.Reporter;
import utilities.WebDriverActions;

@Listeners(utilities.Listener.class)
public class Captcha extends BaseClass{
	
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
		
		getDriver().get(cs.getProperty("url3"));
	
		ui.click(pp.loginBtn);
		Reporter.pass("Login Button is clicked");
		
		ui.click(pp.clickToLogin);
		Reporter.pass("Click to Login is clicked");
		
		Thread.sleep(2000);
		
		WebElement image=getDriver().findElement(By.id("refreshImgCaptcha"));
		
		File src=image.getScreenshotAs(OutputType.FILE);
		String path="C:\\Users\\12943\\git\\ExpleoFramework\\CaptchaImages\\captcha.png";
		
		ui.type(pp.userName, "amarjarsonawane");
		
		ui.type(pp.password, "Amarja@123");
		
		
		FileHandler.copy(src,new File(path));
		
		Thread.sleep(2000);
		ITesseract img=new Tesseract();
		String captcha=img.doOCR(new File(path));
		//getDriver().findElement(By.id("captcha")).sendKeys(captcha);
		ui.type(pp.captchaTxt, captcha);
		Reporter.pass(captcha);
		
	}	
	

}

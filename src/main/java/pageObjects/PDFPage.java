package pageObjects;

import org.openqa.selenium.By;

import utilities.WebDriverActions;

public class PDFPage {

	WebDriverActions ui=new WebDriverActions();
	
	public By chooseFile=By.id("pickfiles");
	
	public By compressPDF=By.id("processTask");
	
	public By downloadPDF=By.id("pickfiles");
	
	public By loginBtn=By.xpath("//a/span[text()='LOGIN']");
	
	public By clickToLogin=By.xpath("(//a[text()='CONTINUE TO LOGIN'])[1]");
	
	public By image=By.id("refreshImgCaptcha");
	
	public By userName=By.id("username");
	
	public By password=By.id("label2");
	
	public By captchaTxt=By.id("loginCaptchaValue");
	
}

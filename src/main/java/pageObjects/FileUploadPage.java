package pageObjects;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.joda.time.DateTime;

import org.openqa.selenium.By;

import com.codoid.products.utils.FilenameUtils;

import base.FrameworkConstants;
import utilities.ConfigurationSupport;
import utilities.CustomMethods;
import utilities.ExcelLibrary;
import utilities.WebDriverActions;

public class FileUploadPage {
	
	WebDriverActions ui=new WebDriverActions();
	
	public By chooseFileBtn=By.className("upload_txt");
	
	public By acceptTerms=By.id("terms");
	
	public By submitBtn=By.id("submitbutton");
	
	public By uploadMsg=By.id("res");
	
	public void uploadFilePath(String path) {
		ui.uploadFCMFile(chooseFileBtn, path);
	}
	
	public long start() {
		return System.currentTimeMillis();
	}
	
	public long end(long start,long ffinish) {
		return ffinish-start;
	}
	
	
}

package jarvis.scripts;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.joda.time.DateTime;
import org.testng.annotations.Listeners;

import com.codoid.products.utils.FilenameUtils;

import base.BaseClass;
import base.FrameworkConstants;
import utilities.CustomMethods;
import utilities.ExcelLibrary;
import utilities.WebDriverActions;

@Listeners(utilities.Listener.class)

public class ReusableMethods extends BaseClass {
	
	WebDriverActions ui;
	ExcelLibrary excel;
	
	String refNo="";

	public String renameExcel(String folder, String fileName, int noOfRows) throws IOException {
		ui=new WebDriverActions();
		excel=new ExcelLibrary();
		
		DateTime d1=new DateTime(new Date());
		String currentDate=d1.toString("ddMMyyyy");
		
		LocalDate dateObj=LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String strDate=dateObj.format(formatter);
		
		int rno=0;
		fileName=cs.getProperty("testdata") + "-" + fileName;
		CustomMethods.copyFiles(System.getProperty("user.dir") + "\\resources" + "\\" + folder + "\\" +fileName, fileName);
		String serialNumber = new SimpleDateFormat("SSS").format(new Date());
		File oldName=new File(FrameworkConstants.getDownloadpath() + "\\" +fileName);
		String extension=FilenameUtils.getExtension(oldName.toString());
		File newName=new File(FilenameUtils.removeExtension(oldName.getName()) + "-" + currentDate + "-" + serialNumber+ "." + extension);
		
		oldName.renameTo(new File(FrameworkConstants.getDownloadpath() + "\\" + newName));
		String excelName=FilenameUtils.removeExtension(newName.getName());
		String path=FrameworkConstants.getDownloadpath() + "\\" + excelName + ".xlsx";
		System.out.println("Path :"+ path);
		
		for(int i=1; i<=noOfRows; i++) {
			refNo=CustomMethods.randomPRef();
			String refNo1=folder + refNo + "-" + i;
			CustomMethods.setCellData(path,2,rno,refNo1);
			CustomMethods.setCellData(path,3,rno,strDate);
			CustomMethods.setCellData(path,4,rno,strDate);
			rno++;
		}
		
		return path;
		
	}
	
}

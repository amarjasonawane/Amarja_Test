package jarvis.scripts;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import pageObjects.BooksPage;
import utilities.CustomMethods;
import utilities.ExcelLibrary;
import utilities.Reporter;
import utilities.ScreenRecorderUtil;
import utilities.WebDriverActions;

@Listeners(utilities.Listener.class)

public class Login extends BaseClass{
	
	WebDriverActions ui;
	ExcelLibrary excel;
	SoftAssert s;
	
	BooksPage bp;
	
	@BeforeMethod
	public void test_Login() throws IOException, AWTException {
		excel=new ExcelLibrary();
		ScreenRecorderUtil.startRecord("SampleTest");
		CustomMethods.login(excel.getCellData("Sheet1", 1, 1),excel.getCellData("Sheet1",1,2 ));
		
	}
	
	@Test(priority=0, enabled=true)
	public void SampleTest() throws Exception {
		ui=new WebDriverActions();
		s=new SoftAssert();
		excel=new ExcelLibrary();
		bp=new BooksPage();
		
	//	CustomMethods.login("amarjarsonawane@gmail.com", "Amarja@123");
		
		
		bp.selectTopMenu("Book");
		Reporter.pass("Books Link is Clicked");
		
		bp.selectAddToCart("Computing and Internet");
		Reporter.pass("Add To Cart for Computing and Internet is Selected");
		
		String msg=ui.getText(bp.addCartMsg);
		Thread.sleep(1000);
		Reporter.pass("Added to cart message is displayed"+msg);
		
		ui.click(bp.shoppingCart);
		Reporter.pass("Click Shopping cart");
		
		ui.check(bp.termsOfService);
		Reporter.pass("Terms of Service is Clicked");
		
		ui.click(bp.checkOutBtn);
		Reporter.pass("Checkout Button is Clicked");
		
		ui.click(bp.continueBtn1);
		Reporter.pass("Continue button from Billing Address is clicked");
		
		ui.explicitWait_Clickability(bp.continueBtn2);
		ui.click(bp.continueBtn2);
		Reporter.pass("Continue button from Shipping Address is clicked");
		
		ui.explicitWait_Clickability(bp.continueBtn3);
		ui.click(bp.continueBtn3);
		Reporter.pass("Continue button from Shipping Method is clicked");
		
		ui.explicitWait_Clickability(bp.continueBtn4);
		ui.click(bp.continueBtn4);
		Reporter.pass("Continue button from Payment Method is clicked");
		
		ui.explicitWait_Clickability(bp.continueBtn5);
		ui.click(bp.continueBtn5);
		Reporter.pass("Continue button from Payment Information is clicked");
		
		ui.explicitWait_Clickability(bp.confirmBtn);
		ui.click(bp.confirmBtn);
		Reporter.pass("Confirm button is clicked");
		
		ui.closeBrowser(getDriver());
		
		ScreenRecorderUtil.stopRecord();
		
		List<String>l1= new ArrayList<String>();
		l1.add("10");
		l1.add("20");
		l1.add("30");
		l1.add("40");
		
		List<String>l2= new ArrayList<String>();
		l2.add("10");
		l2.add("20");
		l2.add("30");
		l2.add("400");
		
		l1.retainAll(l2);
		
		Reporter.pass("List Comparision  :"+l1);
	//	s.assertTrue(WebDriverActions.comapreLists(l1, l2), "List comparision");
	//	s.assertAll();
	}
	
}

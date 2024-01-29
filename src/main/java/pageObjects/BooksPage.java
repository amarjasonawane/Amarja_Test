package pageObjects;

import org.openqa.selenium.By;

import utilities.WebDriverActions;

public class BooksPage {
	
	WebDriverActions ui=new WebDriverActions();
	
	public By shoppingCart=By.xpath("//a/span[text()='Shopping cart']");
	
	public By termsOfService=By.id("termsofservice");
	
	public By checkOutBtn=By.id("checkout");
	
	public By addCartMsg=By.xpath("//p[@class='content']/a ");
	
	public By continueBtn1=By.xpath("//div[@id='billing-buttons-container']/input");
	
	public By continueBtn2=By.xpath("//div[@id='shipping-buttons-container']/input[@value='Continue']");
	
	public By continueBtn3=By.xpath("//div[@id='shipping-method-buttons-container']/input[@value='Continue']");
	
	public By continueBtn4=By.xpath("//div[@id='payment-method-buttons-container']/input[@value='Continue']");
	
	public By continueBtn5=By.xpath("//div[@id='payment-info-buttons-container']/input[@value='Continue']");
	
	public By confirmBtn=By.xpath("//input[@value='Confirm']");
	
	public void selectTopMenu(String varText) throws Exception {
		By dynamicMenu=By.xpath("//*[@class='top-menu']/li/a[contains(text(),'" + varText + "')]");
		ui.click(dynamicMenu);
	}
	
	public void selectAddToCart(String varText) throws Exception {
		By addToCartDynamic=By.xpath("//a[text()='" + varText +"']/ancestor::h2/following-sibling::div[3]/div[2]/input");
		ui.click(addToCartDynamic);
	}
	


}

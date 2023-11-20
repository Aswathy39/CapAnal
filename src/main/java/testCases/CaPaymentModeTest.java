package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CaPaymentModePage;
import utilities.BaseClass;

public class CaPaymentModeTest
{
	public WebDriver driver;
	@BeforeTest
	public void beforetest()
	{
		BaseClass bs =new BaseClass();
		driver=bs.initialize_driver();
		driver.get("https://capital-analytical.myshopify.com/");
	}
	@Test(priority=1)
	public void login() throws Exception
	{
		CaPaymentModePage acfm =new CaPaymentModePage(driver);
		acfm.Login();
		acfm.search_product();
		acfm.click_single_product();
		acfm.popup_checkout_click();
		acfm.paymentArea();
		
		
		
	}
	
	

}

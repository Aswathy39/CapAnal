package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CaCurrencyChangePage;
import pages.CaLoginPage;
import utilities.BaseClass;

public class CaCurrencyChangeTest
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
	public void VerifyCurrency1() throws Exception
	{
		CaLoginPage acfm =new CaLoginPage(driver);
		CaCurrencyChangePage acfm1 =new CaCurrencyChangePage(driver);
		acfm.navigateToLogin();
		acfm.LoginForm();
		acfm1.countryHeading();
		acfm1.verifyCurrencySelected();
	}
	@Test(priority=2)
	public void VerifyCurrency2() throws Exception
	{

		CaCurrencyChangePage acfm1 =new CaCurrencyChangePage(driver);
			acfm1.verifyCurrencyInAddtoCart();
	}
	@Test(priority=3)
	public void VerifyProduct_checkout_page3()throws Exception
	{
		CaCurrencyChangePage acfm1 =new CaCurrencyChangePage(driver);
		acfm1.verifyCurrencyInCheckout();
		
	}
//	@Test(priority=4)
//	public void payment_process_canada()throws Exception
//	{
//		CaCurrencyChangePage acfm1 =new CaCurrencyChangePage(driver);
//		acfm1.paymentArea();
//	}
	@AfterClass
	public void close()
	{
//	driver.quit();
	}

}

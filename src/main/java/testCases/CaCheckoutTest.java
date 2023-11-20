package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CaCurrencyChangePage;
import pages.CaLoginPage;
import utilities.BaseClass;

public class CaCheckoutTest 
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
	public void V() throws Exception
	{
		CaLoginPage acfm =new CaLoginPage(driver);
		CaCurrencyChangePage acfm1 =new CaCurrencyChangePage(driver);
		acfm.navigateToLogin();
		acfm.LoginForm();
		acfm1.countryHeading();
		
		
	}

}

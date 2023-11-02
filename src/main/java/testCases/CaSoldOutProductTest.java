package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CaLoginPage;
import pages.CaSoldoutProductPage;
import utilities.BaseClass;

public class CaSoldOutProductTest 
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
	public void Login() throws Exception
	{
		CaLoginPage acfm =new CaLoginPage(driver);
		acfm.navigateToLogin();
		acfm.LoginForm();
		
	}
	@Test(priority=2)
	public void SoldOutProduct() throws Exception
	{
		CaSoldoutProductPage acfm = new CaSoldoutProductPage(driver);
		acfm.selectProduct();
		
	}

}

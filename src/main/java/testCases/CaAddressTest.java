package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CaAddressPage;
import pages.CaLoginPage;
import utilities.BaseClass;

public class CaAddressTest
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
	public void AddressPage() throws Exception
	{
		CaAddressPage acfm =new CaAddressPage(driver);
		acfm.navigateToAddressPage();
		acfm.addAddress();
		
	}
	@Test(priority=3)
	public void AddEmptyAddress() throws Exception
	{
		CaAddressPage acfm =new CaAddressPage(driver);
		acfm.addEmptyAddress();
		
	}
	@Test(priority=4)
	public void CancelButton() throws Exception
	{
		CaAddressPage acfm =new CaAddressPage(driver);
		acfm.clickCancelBtn();
		
	}
	@Test(priority=5)
	public void EditAddress() throws Exception
	{
		CaAddressPage acfm =new CaAddressPage(driver);
		acfm.editAddress();
		
	}

}

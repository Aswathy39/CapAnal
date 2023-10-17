package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CaAddAccountPage;
import pages.CaLoginPage;
import utilities.BaseClass;

public class CaLoginTest 
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
	public void LoginFormValid() throws Exception
	{
		CaLoginPage acfm =new CaLoginPage(driver);
		acfm.navigateToLogin();
		acfm.LoginForm();
	}
	@Test(priority=2)
	public void InvalidloginInfo() throws Exception
	{
		CaLoginPage acfm =new CaLoginPage(driver);
		acfm.navigateToLogin();
		acfm.LogUseInvalidInfo();
	}
	
	@Test(priority=3)
	public void emptylogin() throws Exception
	{
		CaLoginPage acfm =new CaLoginPage(driver);
		acfm.navigateToLogin();
		acfm.LogUseEmptyForm();
	}
	
	@Test(priority=4)
	public void ValiduserInvalidpass() throws Exception
	{
		CaLoginPage acfm =new CaLoginPage(driver);
		acfm.navigateToLogin();
		acfm.LoginValiduserInvalidpass();
	}
	
	@Test(priority=5)
	public void Invaliduservalidpass() throws Exception
	{
		CaLoginPage acfm =new CaLoginPage(driver);
		acfm.navigateToLogin();
		acfm.LoginInvaliduservalidpass();
	}
	
	@Test(priority=6)
	public void InactiveUsernameAndPassowrd() throws Exception
	{
		CaLoginPage acfm =new CaLoginPage(driver);
		acfm.navigateToLogin();
		acfm.LoginInactiveUsernameAndPassowrd();
	}
	@Test(priority=7)
	public void loginAndBackTest() throws Exception
	{
		CaLoginPage acfm =new CaLoginPage(driver);
		acfm.navigateToLogin();
		acfm.loginAndBack();
	}
	
	
}

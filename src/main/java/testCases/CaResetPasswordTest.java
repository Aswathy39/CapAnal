package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CaResetPasswordPage;
import utilities.BaseClass;

public class CaResetPasswordTest 
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
	public void restPasswordCorrectDetail() throws Exception
	{
		CaResetPasswordPage acfm =new CaResetPasswordPage(driver);
		acfm.navigateToResetPassword();
		acfm.resetpassword();
		
	}
	@Test(priority=2)
	public void resetPasswordEmptyField() throws Exception
	{
		CaResetPasswordPage acfm =new CaResetPasswordPage(driver);
		acfm.navigateToResetPassword();
		acfm.PasswordResetFormEmpty();
		
	}
	@Test(priority=3)
	public void resetPasswordInvalid() throws Exception
	{
		CaResetPasswordPage acfm =new CaResetPasswordPage(driver);
		acfm.navigateToResetPassword();
		acfm.PasswordResetInvalidDetail();
		
	}
	@Test(priority=4)
	public void resetPasswordCancelLink() throws Exception
	{
		CaResetPasswordPage acfm =new CaResetPasswordPage(driver);
		acfm.navigateToResetPassword();
		acfm.PasswordResetCancelLink();
		
	}
	
	@Test(priority=5)
	public void resetPassInvalidEmailFor() throws Exception
	{
		CaResetPasswordPage acfm =new CaResetPasswordPage(driver);
		acfm.navigateToResetPassword();
		acfm.PasswResetInvalidEmailFormat();
		
	}
}

package testCases;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CaAddAccountPage;
import utilities.BaseClass;

public class CaAddAccountTest 
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
	public void createAccount() throws Exception
	{
		CaAddAccountPage ca =new CaAddAccountPage(driver);
		ca.navigateToAccountCreation();
		ca.accountCreation();
	}
	@Test(priority=2)
	public void createAccExistEmail() throws Exception
	{
		Thread.sleep(3000);
		CaAddAccountPage ca =new CaAddAccountPage(driver);
		ca.accountCreationEmailExist();
	}
	@Test(priority=3)
	public void createAccInvalid() throws Exception
	{
		Thread.sleep(3000);
		CaAddAccountPage ca =new CaAddAccountPage(driver);
		ca.accountCreationInvalid();
	}
	@Test(priority=4)
	public void createAccEmpty() throws Exception
	{
		Thread.sleep(3000);
		CaAddAccountPage ca =new CaAddAccountPage(driver);
		ca.accountCreationEmpty();
	}
	@Test(priority=5)
	public void createAccMandatoryFields() throws Exception
	{
		Thread.sleep(3000);
		CaAddAccountPage ca =new CaAddAccountPage(driver);
		ca.createAccMandatoryFields();
	
	}

}

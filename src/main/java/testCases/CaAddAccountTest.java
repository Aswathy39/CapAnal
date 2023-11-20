package testCases;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;
import com.google.common.io.Files;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import pages.CaAddAccountPage;
import utilities.BaseClass;

public class CaAddAccountTest 
{
	public WebDriver driver;
	
	@BeforeTest
//	@org.testng.annotations.Parameters("browser")
//	public void setup(String browser) throws Exception 
//	{
//		if (browser.equalsIgnoreCase("firefox")) 
//		{
//			driver = new FirefoxDriver();
//			driver.get("https://capital-analytical.myshopify.com/");
//		} else if (browser.equalsIgnoreCase("chrome")) 
//		{
//			driver = new ChromeDriver();
//			driver.get("https://capital-analytical.myshopify.com/");
//		} else if (browser.equalsIgnoreCase("Edge"))
//		{
//			driver =new EdgeDriver();
//			driver.get("https://capital-analytical.myshopify.com/");
//			
//		} else 
//		{
//			throw new Exception("Incorrect Browser");
//		}
//	}
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
		//Use TakesScreenshot method to capture screenshot & Saving the screenshot in desired location
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path to the location to save screenshot
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\Account_creation\\Created_account.jpg"));
	}
	@Test(priority=2)
	public void createAccExistEmail() throws Exception
	{
		Thread.sleep(3000);
		CaAddAccountPage ca =new CaAddAccountPage(driver);
		ca.accountCreationEmailExist();
		//Use TakesScreenshot method to capture screenshot & Saving the screenshot in desired location
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path to the location to save screenshot
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\Account_creation\\create_Acc_using_ExistEmail.jpg"));
			
	}
	@Test(priority=3)
	public void createAccInvalid() throws Exception
	{
		Thread.sleep(3000);
		CaAddAccountPage ca =new CaAddAccountPage(driver);
		ca.accountCreationInvalid();
		//Use TakesScreenshot method to capture screenshot & Saving the screenshot in desired location
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path to the location to save screenshot
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\Account_creation\\create_Acc_using_invalid_details.jpg"));
				
	}
	@Test(priority=4)
	public void createAccEmpty() throws Exception
	{
		Thread.sleep(3000);
		CaAddAccountPage ca =new CaAddAccountPage(driver);
		ca.accountCreationEmpty();
		//Use TakesScreenshot method to capture screenshot & Saving the screenshot in desired location
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path to the location to save screenshot
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\Account_creation\\create_Acc_using_Empty_details.jpg"));
					
	}
	@Test(priority=5)
	public void createAccMandatoryFields() throws Exception
	{
		Thread.sleep(3000);
		CaAddAccountPage ca =new CaAddAccountPage(driver);
		ca.createAccMandatoryFields();
		//Use TakesScreenshot method to capture screenshot & Saving the screenshot in desired location
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path to the location to save screenshot
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\Account_creation\\create_Acc_using_Email_and_password.jpg"));
					
	    
	}
	@AfterClass
	public void close()
	{
	driver.quit();
	}

}

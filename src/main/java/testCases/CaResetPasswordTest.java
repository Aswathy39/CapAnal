package testCases;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import pages.CaResetPasswordPage;
import utilities.BaseClass;

public class CaResetPasswordTest 
{
public WebDriver driver;
	
	@BeforeTest
//	@Parameters("browser")
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
//			
//		}
//	}
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
		//Use TakesScreenshot method to capture screenshot & Saving the screenshot in desired location
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path to the location to save screenshot
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\Reset_password\\restPasswordCorrectDetail.jpg"));
		
	}
	@Test(priority=2)
	public void resetPasswordEmptyField() throws Exception
	{
		CaResetPasswordPage acfm =new CaResetPasswordPage(driver);
		acfm.navigateToResetPassword();
		acfm.PasswordResetFormEmpty();
		//Use TakesScreenshot method to capture screenshot & Saving the screenshot in desired location
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path to the location to save screenshot
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\Reset_password\\resetPasswordEmptyField.jpg"));
				
		
	}
	@Test(priority=3)
	public void resetPasswordInvalid() throws Exception
	{
		CaResetPasswordPage acfm =new CaResetPasswordPage(driver);
		acfm.navigateToResetPassword();
		acfm.PasswordResetInvalidDetail();
		//Use TakesScreenshot method to capture screenshot & Saving the screenshot in desired location
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path to the location to save screenshot
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\Reset_password\\resetPasswordInvalid.jpg"));
	}
	@Test(priority=4)
	public void resetPasswordCancelLink() throws Exception
	{
		CaResetPasswordPage acfm =new CaResetPasswordPage(driver);
		acfm.navigateToResetPassword();
		acfm.PasswordResetCancelLink();
		//Use TakesScreenshot method to capture screenshot & Saving the screenshot in desired location
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path to the location to save screenshot
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\Reset_password\\resetPasswordCancelLink.jpg"));
	}
	
	@Test(priority=5)
	public void resetPassInvalidEmailFor() throws Exception
	{
		CaResetPasswordPage acfm =new CaResetPasswordPage(driver);
		acfm.navigateToResetPassword();
		acfm.PasswResetInvalidEmailFormat();
		//Use TakesScreenshot method to capture screenshot & Saving the screenshot in desired location
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path to the location to save screenshot
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\Reset_password\\resetPassInvalidEmailFor.jpg"));
				
	}
	@AfterClass
	public void close()
	{
	driver.quit();
	}
}


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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import pages.CaAddAccountPage;
import pages.CaContactUsPage;
import utilities.BaseClass;


public class CaContactUsTest {
public WebDriver driver;
//@Parameters("browser")
//public void setup(String browser) throws Exception 
//{
//	if (browser.equalsIgnoreCase("firefox")) 
//	{
//		driver = new FirefoxDriver();
//		driver.get("https://capital-analytical.myshopify.com/");
//	} else if (browser.equalsIgnoreCase("chrome")) 
//	{
//		driver = new ChromeDriver();
//		driver.get("https://capital-analytical.myshopify.com/");
//	} else if (browser.equalsIgnoreCase("Edge"))
//	{
//		driver =new EdgeDriver();
//		driver.get("https://capital-analytical.myshopify.com/");
//		
//	} else 
//	{
//		throw new Exception("Incorrect Browser");
//		
//	}
//}
	@BeforeTest
	public void beforetest()
	{
		BaseClass bs =new BaseClass();
		driver=bs.initialize_driver();
		driver.get("https://capital-analytical.myshopify.com/");
	}
	@Test(priority=1)
	public void NavigateToContactUsPage() throws Exception
	{
		CaContactUsPage ca =new CaContactUsPage(driver);
		ca.navigateToContactUsPage();
		ca.AddContactUsFormDetails();
	
		//Use TakesScreenshot method to capture screenshot & Saving the screenshot in desired location
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path to the location to save screenshot
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\contact_us\\contact_us_submission.jpg"));
	}
	
	@Test(priority=2)
	public void EmptysubmitContactusForm() throws Exception
	{
		CaContactUsPage ca =new CaContactUsPage(driver);
		ca.navigateToContactUsPage();
		ca.SubmitContactFormEmptyfields();
	
		//Use TakesScreenshot method to capture screenshot & Saving the screenshot in desired location
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path to the location to save screenshot
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\contact_us\\EmptysubmitContactusForm.jpg"));
	}
	
	@Test(priority=3)
	public void InvalidEmailContactusForm() throws Exception
	{
		CaContactUsPage ca =new CaContactUsPage(driver);
		ca.navigateToContactUsPage();
		ca.InvalidEmailContactUsFormSub();
	
		//Use TakesScreenshot method to capture screenshot & Saving the screenshot in desired location
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path to the location to save screenshot
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\contact_us\\InvalidEmailContactusForm.jpg"));
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	
}

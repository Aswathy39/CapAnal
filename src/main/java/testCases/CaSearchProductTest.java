package testCases;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import pages.CaLoginPage;
import pages.CaSearchProductPage;
import utilities.BaseClass;

public class CaSearchProductTest 
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
	public void Login() throws Exception
	{
		CaLoginPage acfm =new CaLoginPage(driver);
		acfm.navigateToLogin();
		acfm.LoginForm();
		//Use TakesScreenshot method to capture screenshot & Saving the screenshot in desired location
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path to the location to save screenshot
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\search_product\\Login.jpg"));
	}
	@Test(priority=2)
	public void SearchProduct() throws Exception
	{
		CaSearchProductPage acfm =new CaSearchProductPage(driver);
		acfm.search();
		//Use TakesScreenshot method to capture screenshot & Saving the screenshot in desired location
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path to the location to save screenshot
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\search_product\\SearchProduct.jpg"));
	}
	@Test(priority=3)
	public void VerifySearchedProduct() throws Exception
	{
		CaSearchProductPage acfm =new CaSearchProductPage(driver);
		acfm.verifyProductSearched();
		//Use TakesScreenshot method to capture screenshot & Saving the screenshot in desired location
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path to the location to save screenshot
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\search_product\\VerifySearchedProduct.jpg"));
	}
	@Test(priority=4)
	public void FindProductFromDropdown() throws Exception
	{
		CaSearchProductPage acfm =new CaSearchProductPage(driver);
		acfm.findProductFromDropdown();
		//Use TakesScreenshot method to capture screenshot & Saving the screenshot in desired location
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path to the location to save screenshot
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\search_product\\FindProductFromDropdown.jpg"));
	}
	@Test(priority=5)
	public void VerifyProductListedFromDropdown() throws Exception
	{
		CaSearchProductPage acfm =new CaSearchProductPage(driver);
		acfm.verifyProductListed();
		//Use TakesScreenshot method to capture screenshot & Saving the screenshot in desired location
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path to the location to save screenshot
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\search_product\\VerifyProductListedFromDropdown.jpg"));
	}
	@Test(priority=6)
	public void SearchProductWithPartialName() throws Exception
	{
		CaSearchProductPage acfm =new CaSearchProductPage(driver);
		acfm.searchWithPartialProdName();
		//Use TakesScreenshot method to capture screenshot & Saving the screenshot in desired location
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path to the location to save screenshot
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\search_product\\SearchProductWithPartialName.jpg"));
	}
	@Test(priority=7)
	public void SearchProductWithInvalidName() throws Exception
	{
		CaSearchProductPage acfm =new CaSearchProductPage(driver);
		acfm.invalidSearch();
		//Use TakesScreenshot method to capture screenshot & Saving the screenshot in desired location
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path to the location to save screenshot
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\search_product\\SearchProductWithInvalidName.jpg"));
	}
	@Test(priority=8)
	public void VerifyProductSearchWithInvalidName() throws Exception
	{
		CaSearchProductPage acfm =new CaSearchProductPage(driver);
		acfm.verifyInvalidSearch();
		//Use TakesScreenshot method to capture screenshot & Saving the screenshot in desired location
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path to the location to save screenshot
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\search_product\\VerifyProductSearchWithInvalidName.jpg"));
		
	}
	@AfterClass
	public void close()
	{
	driver.quit();
	}

}

package testCases;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import pages.CaLoginPage;
import pages.CaProductPriceTotalVerifyPage;
import utilities.BaseClass;

public class CaProductPriceTotalVerifyTest
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
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\product_quantity_verifiy\\Login.jpg"));
	}
	@Test(priority=1)
	public void ProductTotalPriceVerification() throws Exception
	{
		CaProductPriceTotalVerifyPage acfm =new CaProductPriceTotalVerifyPage(driver);
		acfm.navigateToCartPage();
		acfm.addQuantity();
		acfm.totalAmountCalculation();
		//Use TakesScreenshot method to capture screenshot & Saving the screenshot in desired location
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path to the location to save screenshot
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\product_quantity_verifiy\\ProductTotalPriceVerification.jpg"));
	}
	@Test(priority=2)
	public void ContinueShopFromCart() throws Exception
	{
		CaProductPriceTotalVerifyPage acfm =new CaProductPriceTotalVerifyPage(driver);
		acfm.navigateToCartPage();
		acfm.continueShoppingFromCart();
		//Use TakesScreenshot method to capture screenshot & Saving the screenshot in desired location
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path to the location to save screenshot
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\product_quantity_verifiy\\ClickContinueShopFromCart.jpg"));

		driver.close();
	}
	

}

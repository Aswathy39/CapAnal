package testCases;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import pages.CaAddToCartPage;
import pages.CaLoginPage;
import utilities.BaseClass;

public class CaAddToCartTest 
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
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\add_to_cart\\Login.jpg"));
	}
	@Test(priority=2)
	public void AddToCart() throws Exception
	{
		CaAddToCartPage acfm =new CaAddToCartPage(driver);
		acfm.addToCart();
		acfm.cartViewHeader();
		//Use TakesScreenshot method to capture screenshot & Saving the screenshot in desired location
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path to the location to save screenshot
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\add_to_cart\\Add_to_cart_a_product.jpg"));
	}
	@Test(priority=3)
	public void AddToCartTwo() throws Exception
	{
		CaAddToCartPage acfm =new CaAddToCartPage(driver);
		acfm.addToCart();
		acfm.cartViewPopup();
		//Use TakesScreenshot method to capture screenshot & Saving the screenshot in desired location
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path to the location to save screenshot
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\add_to_cart\\Add_cart_clicked_from_pop_up.jpg"));
	}
	@Test(priority=4)
	public void ProductQuantityIncrease() throws Exception
	{
		CaAddToCartPage acfm =new CaAddToCartPage(driver);
		acfm.addToCart();
		acfm.cartViewHeader();
		acfm.productQuantityIncreaseByIcon();
		//Use TakesScreenshot method to capture screenshot & Saving the screenshot in desired location
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path to the location to save screenshot
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\add_to_cart\\product_qty_increase_clicking_icon.jpg"));
	}
	@Test(priority=5)
	public void ProductQuantityDecrease() throws Exception
	{
		CaAddToCartPage acfm =new CaAddToCartPage(driver);
		acfm.addToCart();
		acfm.cartViewHeader();
		acfm.productQuantityDecreaseByIcon();
		//Use TakesScreenshot method to capture screenshot & Saving the screenshot in desired location
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path to the location to save screenshot
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\add_to_cart\\product_qty_decrease.jpg"));
	}
	@Test(priority=6)
	public void ProductQuantityEnterFromInputArea() throws Exception
	{
		CaAddToCartPage acfm =new CaAddToCartPage(driver);
		acfm.addToCart();
		acfm.cartViewHeader();
		acfm.productQuantityInputArea();
		//Use TakesScreenshot method to capture screenshot & Saving the screenshot in desired location
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path to the location to save screenshot
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\add_to_cart\\product_qty_entered_manually.jpg"));
	}
	@Test(priority=7)
	public void emptyCart() throws Exception
	{
		CaAddToCartPage acfm =new CaAddToCartPage(driver);
		acfm.emptyCart();
		//Use TakesScreenshot method to capture screenshot & Saving the screenshot in desired location
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path to the location to save screenshot
		Files.copy(f, new File("C:\\Users\\Aswat\\eclipse-workspace\\new_capAnalytical\\screenshots\\add_to_cart\\delete_cart_item.jpg"));
	}
	
	@Test(priority=8)
	public void ProductQuantityVerification() throws Exception
	{
		CaAddToCartPage acfm =new CaAddToCartPage(driver);
		acfm.productQuantityVerification();
		acfm.decimalValueInQuantity();
		acfm.alphabeticalValueInQuantity();
		acfm.emptyValueInQuantity();
		acfm.negativeValueInQuantity();
		
//		driver.close();
	}
	@AfterClass
	public void close()
	{
	driver.quit();
	}
}

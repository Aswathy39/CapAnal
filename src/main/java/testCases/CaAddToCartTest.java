package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CaAddToCartPage;
import pages.CaLoginPage;
import utilities.BaseClass;

public class CaAddToCartTest 
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
	public void AddToCart() throws Exception
	{
		CaAddToCartPage acfm =new CaAddToCartPage(driver);
		acfm.addToCart();
		acfm.cartViewHeader();
	}
	@Test(priority=3)
	public void AddToCartTwo() throws Exception
	{
		CaAddToCartPage acfm =new CaAddToCartPage(driver);
		acfm.addToCart();
		acfm.cartViewPopup();
	}
	@Test(priority=4)
	public void ProductQuantityIncrease() throws Exception
	{
		CaAddToCartPage acfm =new CaAddToCartPage(driver);
		acfm.addToCart();
		acfm.cartViewHeader();
		acfm.productQuantityIncreaseByIcon();
	}
	@Test(priority=5)
	public void ProductQuantityDecrease() throws Exception
	{
		CaAddToCartPage acfm =new CaAddToCartPage(driver);
		acfm.addToCart();
		acfm.cartViewHeader();
		acfm.productQuantityDecreaseByIcon();
	}
	@Test(priority=6)
	public void ProductQuantityEnterFromInputArea() throws Exception
	{
		CaAddToCartPage acfm =new CaAddToCartPage(driver);
		acfm.addToCart();
		acfm.cartViewHeader();
		acfm.productQuantityInputArea();
	}
	

}

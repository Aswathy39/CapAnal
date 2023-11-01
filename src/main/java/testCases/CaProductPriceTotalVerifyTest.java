package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CaLoginPage;
import pages.CaProductPriceTotalVerifyPage;
import utilities.BaseClass;

public class CaProductPriceTotalVerifyTest
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
	@Test(priority=1)
	public void ProductTotalPriceVerification() throws Exception
	{
		CaProductPriceTotalVerifyPage acfm =new CaProductPriceTotalVerifyPage(driver);
		acfm.navigateToCartPage();
		acfm.addQuantity();
		acfm.totalAmountCalculation();
	}
	@Test(priority=2)
	public void ContinueShopFromCart() throws Exception
	{
		CaProductPriceTotalVerifyPage acfm =new CaProductPriceTotalVerifyPage(driver);
		acfm.navigateToCartPage();
		acfm.continueShoppingFromCart();
	}
	

}

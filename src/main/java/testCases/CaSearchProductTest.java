package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CaLoginPage;
import pages.CaSearchProductPage;
import utilities.BaseClass;

public class CaSearchProductTest 
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
	public void SearchProduct() throws Exception
	{
		CaSearchProductPage acfm =new CaSearchProductPage(driver);
		acfm.search();
	}
	@Test(priority=3)
	public void VerifySearchedProduct() throws Exception
	{
		CaSearchProductPage acfm =new CaSearchProductPage(driver);
		acfm.verifyProductSearched();
	}
	@Test(priority=4)
	public void FindProductFromDropdown() throws Exception
	{
		CaSearchProductPage acfm =new CaSearchProductPage(driver);
		acfm.findProductFromDropdown();
	}
	@Test(priority=5)
	public void VerifyProductListedFromDropdown() throws Exception
	{
		CaSearchProductPage acfm =new CaSearchProductPage(driver);
		acfm.verifyProductListed();
	}
	@Test(priority=6)
	public void SearchProductWithPartialName() throws Exception
	{
		CaSearchProductPage acfm =new CaSearchProductPage(driver);
		acfm.searchWithPartialProdName();
	}
	@Test(priority=7)
	public void SearchProductWithInvalidName() throws Exception
	{
		CaSearchProductPage acfm =new CaSearchProductPage(driver);
		acfm.invalidSearch();
	}
	@Test(priority=8)
	public void VerifyProductSearchWithInvalidName() throws Exception
	{
		CaSearchProductPage acfm =new CaSearchProductPage(driver);
		acfm.verifyInvalidSearch();
	}

}

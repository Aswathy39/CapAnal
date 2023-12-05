package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CaCurrencyChangePage;
import pages.CaFindBrokenLinksPage;
import utilities.BaseClass;

public class CaFindBrokenLinksPageTest 
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
	public void FindBrokenLinks() throws Exception
	{
		CaCurrencyChangePage acfm1 =new CaCurrencyChangePage(driver);
		acfm1.Login();
		CaFindBrokenLinksPage acfm2 = new CaFindBrokenLinksPage(driver);
		acfm2.FindLinks();
		
	}

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class CaCheckoutPage 
{
	
	public WebDriver driver;
	SoftAssert softAssert =new SoftAssert();
	public  CaCheckoutPage(WebDriver driver)
	{
		this.driver=driver; 
	}
	

}

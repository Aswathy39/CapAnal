package testCases;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CaCheckoutAddressAddEditDelePage;
import utilities.BaseClass;
public class CaCheckoutAddressAddEditDeleTest {


public WebDriver driver;
	
	@BeforeTest
	public void beforetest()
	{
		BaseClass bs =new BaseClass();
		driver=bs.initialize_driver();
		driver.get("https://capital-analytical.myshopify.com/");
	}
	@Test(priority=1)
	public void login() throws Exception
	{
		CaCheckoutAddressAddEditDelePage acfm =new CaCheckoutAddressAddEditDelePage(driver);
		
		acfm.Login();
		
	}
	
	
	@Test(priority=2)
	public void search_product() throws Exception
	{
		CaCheckoutAddressAddEditDelePage acfm =new CaCheckoutAddressAddEditDelePage(driver);
		acfm.search_product();
		
	}	
	
	@Test(priority=3)
	public void Clicked_single_item_add_to_cart() throws Exception
	{
		CaCheckoutAddressAddEditDelePage acfm =new CaCheckoutAddressAddEditDelePage(driver);
		acfm.click_single_product();
		
	}
	@Test(priority=4)
	public void Clicked_popup_checkout_click() throws Exception
	{
		CaCheckoutAddressAddEditDelePage acfm =new CaCheckoutAddressAddEditDelePage(driver);
		acfm.popup_checkout_click();
		
	}
	
	@Test(priority=5)
	public void expand_ship_to_down_arrow() throws Exception
	{
		CaCheckoutAddressAddEditDelePage acfm =new CaCheckoutAddressAddEditDelePage(driver);
		acfm.expand_ship_to_down_arrow();
		
		
	}
	@Test(priority=6)
	public void three_dot_more_option_view_edit_delete() throws InterruptedException
	{
		CaCheckoutAddressAddEditDelePage acfm =new CaCheckoutAddressAddEditDelePage(driver);
		acfm.click_dots_to_viewaddress_edit_delete_options();
		
		
	}
	@Test(priority=7)
	public void click_edit_option() throws InterruptedException
	{
		CaCheckoutAddressAddEditDelePage acfm =new CaCheckoutAddressAddEditDelePage(driver);
		acfm.click_edit_option();
		acfm.Edit_address();
		
	}
	@Test(priority=8)
	public void Delete_address() throws Exception
	{
		CaCheckoutAddressAddEditDelePage acfm =new CaCheckoutAddressAddEditDelePage(driver);
		acfm.deleteAddress();
		
		
		
	}
	
	
	
}
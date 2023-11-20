package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Allure;

public class CaCheckoutAddressAddEditDelePage
{
	public WebDriver driver;
	SoftAssert softAssert =new SoftAssert();
	public  CaCheckoutAddressAddEditDelePage(WebDriver driver)
	{
		this.driver=driver; 
	//	driver.manage().deleteAllCookies();
	}
	//profile icon
	By capitalHeading = By.xpath("//a[@class='header__icon header__icon--account link focus-inset small-hide']");
	By LoginEmail = By.xpath("//*[@id=\"CustomerEmail\"]");//login email
	By LoginPassword=By.xpath("//*[@id=\"CustomerPassword\"]");//password
	By signinbuton=By.xpath("//*[@id=\"customer_login\"]/button"); //signup
	By searchBarIcon = By.cssSelector(".header > .header__search .modal__toggle-open");
	By searchBar = By.xpath("//*[@id=\"Search-In-Modal-1\"]");  
	By productName = By.xpath("/html/body/main/section/div/div[2]/div/div/ul/li[1]/div/div/div[2]/div[1]/h3/a");	
	By particular_product_click = By.xpath("//a[@id=\"CardLink--8214106013910\"]");  //single product click
	By add_to_cart_button=By.xpath("//button[@class='product-form__submit button button--full-width button--primary']");
    By pop_up_cart_checkout=By.xpath("//*[@id=\"CartDrawer-Checkout\"]");  
    By expand_ship_to_down_arrow=By.xpath("//*[@id=\"deliveryAddress-collapsible\"]/div[1]");	
    By more_address_option_3_dots=By.xpath("(//button[@type='button'])[4]");
    By delete_link=By.xpath("//*[@id=\"Overlay3\"]/div/div/div");
    By edit_link=By.xpath("(//button[@type=\"button\"])[12]");
    By edit_firstname=By.cssSelector("#TextField0");
    By edit_company=By.cssSelector("#TextField2");
    By edit_lastName=By.cssSelector("#TextField1");
    By address1=By.cssSelector("#shipping-address1");
    By save_edit_button=By.cssSelector(".\\_1fragemf4:nth-child(2)");
    By card_no=By.xpath("//input[@id='number']");
    By dropdown_logout_view=By.xpath("//*[@id=\"contact-collapsible\"]/div[1]/div");
    By deleteConfirmPopUp = By.xpath("/html/body/div[1]/div/div/div/div[2]/div[3]/div/div[2]/div/div[2]/div/button[2]");
	public void Login() throws Exception
	{
		
		driver.findElement(capitalHeading).click();
		Allure.step("Clicked on capital analytical icon");
	    
		//Email
		driver.findElement(LoginEmail).sendKeys("sit36@ascensor.com");
		Allure.step("Entered a new Emailid");
		//Password
		driver.findElement(LoginPassword).sendKeys("123456789");
		Allure.step("Entered a new Password");
		//signin 
		driver.findElement(signinbuton).click();
		Allure.step("Clicked the signin button");
		
		
		
	}	
	public void search_product() throws Exception
	{
		
		Thread.sleep(4000);
		driver.findElement(searchBarIcon).click();
		Allure.step("Clicked on search icon");
		Thread.sleep(2000);
		driver.findElement(searchBar).click();
		driver.findElement(searchBar).sendKeys("WATCH GLASS 40mm");
		Allure.step("Entered product name");
		driver.findElement(searchBar).sendKeys(Keys.ENTER);
		Allure.step("Enter key is pressed");
	
	}
	public void click_single_product() throws InterruptedException
	{
		
		Thread.sleep(2000);
		//scroll down
		JavascriptExecutor js1 = (JavascriptExecutor) driver; 
		 js1.executeScript("window.scrollBy(0,400)"); 
		driver.findElement(particular_product_click).click();
		Allure.step("Clicked on a specific product");
		driver.findElement(add_to_cart_button).click();
		Allure.step("Clicked on a add to cart button");
	}
	 
	 public void popup_checkout_click() throws InterruptedException
		{
		 Thread.sleep(2000);
			driver.findElement(pop_up_cart_checkout).click();
			Allure.step("Clicked on add to cart button on popup screen");
			
		}
	 
	 public void expand_ship_to_down_arrow() throws InterruptedException
		{
		 Thread.sleep(2000);
			driver.findElement(expand_ship_to_down_arrow).click();
			Allure.step("Clicked expand option to view existing address");
			
		}
	 public void click_dots_to_viewaddress_edit_delete_options() throws InterruptedException 
	 {
		 Thread.sleep(3000);
		 driver.findElement(more_address_option_3_dots).click();
	     Allure.step("Clicked 3 dot to view addresses");
	 }
	 public void click_edit_option() throws InterruptedException 
	 {
		 Thread.sleep(3000);
		 driver.findElement(edit_link).click();
	     Allure.step("Clicked edit");
	 }

	 public void Edit_address() throws InterruptedException 
	 {
		 
	     Thread.sleep(3000);
		 driver.findElement(edit_firstname).clear();
		 driver.findElement(edit_firstname).sendKeys("Hakan");
	     Allure.step("Entered firstname to update");
	     driver.findElement(edit_lastName).clear();
	     driver.findElement(edit_lastName).sendKeys("Ali muhammed");
	     Allure.step("Entered lastName to update");
	     driver.findElement(edit_company).clear();
	     driver.findElement(edit_company).sendKeys("vAli muhammed company pvt.ltd");
	     Allure.step("Entered edit_company to update");
	     Thread.sleep(1000);
	     driver.findElement(address1).clear();
	     driver.findElement(address1).sendKeys("58 Hertingfordbury Rd");
	     Allure.step("Entered address to update");
	     driver.findElement(save_edit_button).click();
	     Allure.step("Clicked save button to edit address details");
	     
	 }
	
	 public void logoutFromCheckoutpage() throws InterruptedException
	 {
		 Thread.sleep(2000);
		 driver.findElement(dropdown_logout_view).click();
		 Allure.step("Entered address to update");
	 }
	 
	 public void deleteAddress() throws Exception
	 {
		 Thread.sleep(3000);
		 driver.findElement(more_address_option_3_dots).click();
		 driver.findElement(delete_link).click();
		 Thread.sleep(2000);
		 driver.findElement(deleteConfirmPopUp).click();
		 
		 
	 }
	 
	 
	}
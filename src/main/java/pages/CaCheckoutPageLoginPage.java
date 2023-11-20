package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Allure;

public class CaCheckoutPageLoginPage 
{
	
	public WebDriver driver;
	SoftAssert softAssert =new SoftAssert();
	public  CaCheckoutPageLoginPage(WebDriver driver)
	{
		this.driver=driver; 
		
	}
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
    By final_review_paymnt_button=By.xpath("//*[@id=\"pay-button-container\"]/div/div/button");
    By login_in_checkoutpage=By.xpath("//*[@id=\"Form0\"]/div[1]/div/div/section/div[2]/div/div/div/div[1]/span/a");
    By login_title=By.xpath("//h1[@id=\"login\"]");
    By continue_as_guest=By.xpath("//*[@id=\"shopify-section-template--16897772191958__main\"]/div/div[3]/h2");
    By continue_as_guest_continue_button=By.xpath("//*[@id=\"customer_login_guest\"]/button");
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
			String ActText ="Log in";
			String expText =driver.findElement(login_in_checkoutpage).getText();
			softAssert.assertEquals(ActText, expText, "Validation message mismatch");
			softAssert.assertAll(); 
			Allure.step("Verified 'Log in' option available on the checkout page");
			driver.findElement(login_in_checkoutpage).click();
			Allure.step("Clicked on login");
			
			String ActText1 ="Login";
			String expText1 =driver.findElement(login_title).getText();
			softAssert.assertEquals(ActText1, expText1, "Validation message mismatch");
			softAssert.assertAll(); 
			Allure.step("Verified the login page is loaded");
		}
	 public void Continue_as_guest() throws InterruptedException
		{
		 Thread.sleep(2000);
		 
		    String ActText1 ="Continue as a guest";
			String expText1 =driver.findElement(continue_as_guest).getText();
			softAssert.assertEquals(ActText1, expText1, "Validation message mismatch");
			softAssert.assertAll(); 
			Allure.step("Verified the Continue as a guest section present");
			
			driver.findElement(continue_as_guest_continue_button).click();
			Allure.step("Clicked on continue as guest button");
		}
	 
	 	}
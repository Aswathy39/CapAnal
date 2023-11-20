package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Allure;

public class CaPaymentModePage 
{
	
	public WebDriver driver;
	SoftAssert softAssert =new SoftAssert();
	public  CaPaymentModePage(WebDriver driver)
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
	 public void paymentArea() throws Exception
	 {
		 WebElement element = driver.findElement(By.cssSelector("#contact-collapsible > .\\_1ip0g651"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	     
	      JavascriptExecutor js1 = (JavascriptExecutor) driver; 
			 js1.executeScript("window.scrollBy(0,600)");
	      Thread.sleep(2000);
	    driver.switchTo().frame(2);
	    driver.findElement(By.id("number")).click();
	    Allure.step("Clicked on card number field");
	    driver.findElement(By.id("number")).clear();
	    Allure.step("clear if there is existing value");
	    Thread.sleep(2000);
	    
        String cardNumber = "4000056655665556";
        new Actions(driver).moveToElement(driver.findElement(By.id("number"))).sendKeys(cardNumber).build().perform();
	    Thread.sleep(2000);
	    Allure.step("send card number");
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame(3);
	   driver.findElement(By.id("expiry")).click();
	   Allure.step("Clicked on expiry date field ");
	   new Actions(driver).moveToElement(driver.findElement(By.id("expiry"))).sendKeys("11/23").build().perform();
	    Allure.step("Entered expiry date");
	   Thread.sleep(2000);
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame(4);
	    driver.findElement(By.id("verification_value")).click();
	    Allure.step("Clicked on cvv field ");
	    driver.findElement(By.id("verification_value")).sendKeys("328");
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame(7);
	    driver.findElement(By.id("name")).click();
	    Allure.step("Clicked on card holder name field");
	    driver.findElement(By.id("name")).sendKeys("thanu rahol33");
	    Allure.step("Entered card holder name");
	    driver.switchTo().defaultContent();
	    driver.findElement(By.cssSelector(".\\_1fragemf4")).click();
	    Allure.step("Clicked 'review order' on checkout page");
	    Thread.sleep(3000);
       driver.findElement(final_review_paymnt_button).click();
       Allure.step("Clicked 'review order' on last checkout page");
	 }
	 

}

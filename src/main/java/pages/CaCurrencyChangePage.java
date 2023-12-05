package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Allure;

public class CaCurrencyChangePage 
{
	public WebDriver driver;
	SoftAssert softAssert =new SoftAssert();
	public  CaCurrencyChangePage(WebDriver driver)
	{
		this.driver=driver; 
	}
	By capitalHeading = By.cssSelector(".header__heading-logo");
	By countryHeading =By.cssSelector("#HeaderCountryForm .disclosure__button > span");
	By accounticon=By.xpath("//*[@id=\"shopify-section-sections--16897772519638__header\"]/sticky-header/header/div/a[1]");//account icon
	By LoginEmail = By.xpath("//*[@id=\"CustomerEmail\"]");//login email
	By LoginPassword=By.xpath("//*[@id=\"CustomerPassword\"]");//password
	By signinbuton=By.xpath("//*[@id=\"customer_login\"]/button"); //signup	
	By countryCan =By.cssSelector("#HeaderCountryList > .disclosure__item:nth-child(6) > .link");
	By shopNowBtn = By.xpath("/html/body/main/section[1]/slideshow-component/div[2]/div[1]/div[2]/div/div[2]/a");
	By collectionName1 =By.xpath("/html/body/main/div/div/ul/li[5]/div/div/div[2]/div/h3/a");
	By collectionName2 = By.xpath("/html/body/main/div/div/ul/li[1]/div/div/div[2]/div/h3/a");
	By firstProduct = By.xpath("/html/body/main/div[2]/div/div/div/div/ul/li[1]/div/div/div[2]/div[1]/h3/a");
	By homeIcon = By.xpath("/html/body/div[3]/sticky-header/header/a/div/img");	
	By searchBarIcon = By.xpath("/html/body/div[5]/sticky-header/header/details-modal/details/summary/span");
	By searchBarIcon2 = By.xpath("/html/body/div[6]/sticky-header/header/details-modal/details/summary");
	By searchBar = By.xpath("//*[@id=\"Search-In-Modal-1\"]");  
	By productName = By.xpath("/html/body/main/section/div/div[2]/div/div/ul/li[1]/div/div/div[2]/div[1]/h3/a");
	By fstProd = By.xpath("/html/body/main/section/div/div[2]/div/div/ul/li[1]/div/div/div[2]/div[1]/h3/a");
	By currency1 = By.xpath("/html/body/main/section/div/div[2]/div/div/ul/li[1]/div/div/div[2]/div[1]/div/div/div/div[1]/span[2]");
	
	By cookieAccept = By.xpath("/html/body/div[3]/div/div[1]/button[3]");
	By currencyFind = By.cssSelector(".price-item--regular:nth-child(2)");
	By currencyFind2 = By.xpath("/html/body/cart-drawer/div/div[2]/div[2]/div[1]/div[1]/span[2]");
	
	By addToCartBtn = By.xpath("//button[@id='ProductSubmitButton-template--16897771864278__main']");
	By productName_singleproduct=By.linkText("WATCH GLASS 40mm");
	
	By checkoutBtn = By.xpath("//button[@id='CartDrawer-Checkout']");
	By prodName_Checkout =By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div[1]/div/div[2]/div/div[2]/div/div/aside/div/div[1]/section/div[2]/div[2]/div[2]/div/p");
	By currencyFind3 = By.xpath("/html/body/div[1]/div/div/div/div[1]/div[1]/div/div[2]/div/div[2]/div/div/aside/div/div[1]/section/div[2]/div[2]/div[4]/div/div/span");
	By homeBtn = By.xpath("/html/body/div[1]/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div/div/div/div/header/div[1]");
	By accountIcon = By.xpath("(//a[@href='/account'])[2]");
	By logout=By.xpath("//a[@href='/account/logout']");
	By final_review_paymnt_button=By.xpath("//*[@id=\"pay-button-container\"]/div/div/button");
	
	By shipAdrsCheckbox = By.xpath("//*[@id=\"billingAddress\"]");
	By shipAddrsDrop = By.cssSelector("#Select0");
	By shipAddrs1 = By.xpath("//*[@id=\"Select13\"]/option[1]/text()");
	By shipAddrs2 = By.xpath("//*[@id=\"Select13\"]/option[2]/text()");
	String expCurrency1;
	
	
	public void Login() throws Exception
	{
		
		driver.findElement(capitalHeading).click();
		Allure.step("Clicked on capital analytical icon");
		driver.findElement(accounticon).click();
		Allure.step("Clicked on contact form button to navigate to contact form");
	    
		//Email
		driver.findElement(LoginEmail).sendKeys("test319@ascensor.com");
		Allure.step("Entered a new Emailid");
		//Password
		driver.findElement(LoginPassword).sendKeys("GREGORY12");
		Allure.step("Entered a new Password");
		//signin 
		driver.findElement(signinbuton).click();
		Allure.step("Clicked the signin button");
		
		
		
	}	
	
	public void countryHeading() throws Exception
	{
		
		driver.findElement(capitalHeading).click();
	    driver.findElement(countryHeading).click();
	    driver.findElement(countryCan).click();
		
		
		Thread.sleep(3000);
		driver.findElement(searchBarIcon).click();
		Allure.step("Clicked on search icon");
		Thread.sleep(2000);
		driver.findElement(searchBar).click();
		driver.findElement(searchBar).sendKeys("WATCH GLASS 40mm");
		Allure.step("Entered product name");
		driver.findElement(searchBar).sendKeys(Keys.ENTER);
		Allure.step("Enter key is pressed");
		
		Thread.sleep(2000);
		expCurrency1 = driver.findElement(currency1).getText();
		driver.findElement(fstProd).click();
	}
	public void countryHeading2() throws Exception
	{
		
		driver.findElement(capitalHeading).click();
	    driver.findElement(countryHeading).click();
	    driver.findElement(countryCan).click();
		
		
		Thread.sleep(4000);
		driver.findElement(searchBarIcon2).click();
		Allure.step("Clicked on search icon");
		Thread.sleep(2000);
		driver.findElement(searchBar).click();
		driver.findElement(searchBar).sendKeys("WATCH GLASS 40mm");
		Allure.step("Entered product name");
		driver.findElement(searchBar).sendKeys(Keys.ENTER);
		Allure.step("Enter key is pressed");
		
		Thread.sleep(2000);
		expCurrency1 = driver.findElement(currency1).getText();
		driver.findElement(fstProd).click();
	}
	
	public void verifyCurrencySelected()
	{
		
		/*String product_name_actual = driver.findElement(productName_singleproduct).getText();
		String product_name_expected="WATCH GLASS 40mm";
		
		softAssert.assertEquals(product_name_actual, product_name_expected, "product name Mismatch");
		Allure.step("Verified product name");*/
		
		String actCurrency1 = driver.findElement(currencyFind).getText();
		System.out.println("Expected currency and amount "+expCurrency1);
		System.out.println("currency and amount "+actCurrency1);
		
		softAssert.assertEquals(actCurrency1, expCurrency1, "Message Mismatch");
		Allure.step("Verified currency change");
		softAssert.assertAll();
		
		
	}
	public void logout()throws Exception
	{
		//logout  
		driver.findElement(homeBtn).click();
		Thread.sleep(3000);
		driver.findElement(accountIcon).click();
		
		driver.findElement(logout).click();
		Allure.step("Clicked the Log out");
		
	}
	public void verifyCurrencyInAddtoCart() throws Exception
	{
		driver.findElement(addToCartBtn).click();
		Thread.sleep(3000);
		String expCurrency2 ="$40.00 CAD";
		String actCurrency2 =driver.findElement(currencyFind2).getText();
		
		System.out.println("Currency " +actCurrency2);
		softAssert.assertEquals(actCurrency2, expCurrency2, "Currency Mismatch");
		Allure.step("Verified currency change in add to cart page");
		
		//verifying product name is matching with single product page and 'your cart' page
		String product_name_actual = driver.findElement(productName_singleproduct).getText();
		String product_name_expected="WATCH GLASS 40mm";	
		softAssert.assertEquals(product_name_actual, product_name_expected, "product name Mismatch");
		Allure.step("Verified product name");
		softAssert.assertAll();
		
	   //add order information
		
	}
	public void verifyCurrencyInCheckout() throws Exception
	{
		driver.findElement(checkoutBtn).click();
		Allure.step("Clicked on checkout button");
		Thread.sleep(2000);
		String actualProdname="";
		actualProdname =driver.findElement(prodName_Checkout).getText();
		System.out.println("product name"+actualProdname);
		String expectedProdName ="WATCH GLASS 40mm";
		
		softAssert.assertEquals(actualProdname, expectedProdName, "product name Mismatch");
		Allure.step("Verified product name in checkout page");
		
		
		//Case will fail. Actually country is canada but on checkout page by default uk address showing and price caluclated in pounds
		String expCurrency ="$40.00";
		String actCurrency =driver.findElement(currencyFind3).getText();
		
		System.out.println("Currency " +actCurrency);
		softAssert.assertEquals(actCurrency, expCurrency, "Currency Mismatch");
		Allure.step("Verified cad currency is shown in the checkout page");
		
		softAssert.assertAll();
	}
	public void AddressVerification() throws Exception
	{
		//payment billing address
		
		driver.findElement(shipAdrsCheckbox).click();
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(3000);
		driver.findElement(shipAddrsDrop).click();
		
		String addrs1 = driver.findElement(shipAddrsDrop).getText();
		
		
		
		if(addrs1.contains("Mckellar ON P0G 1C0, Canada")) 
		{
			System.out.println("adrrrss 1 passs ");
		
		}
		
		
	}
	
	
	
}

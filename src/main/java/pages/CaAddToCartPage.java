package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Allure;

public class CaAddToCartPage 
{
	public WebDriver driver;
	SoftAssert softAssert =new SoftAssert();
	public  CaAddToCartPage(WebDriver driver)
	{
		this.driver=driver; 
	}
	
	By shopNowBtn = By.xpath("/html/body/main/section[1]/slideshow-component/div[2]/div[1]/div[2]/div/div[2]/a");
	By collectionName1 =By.xpath("/html/body/main/div/div/ul/li[5]/div/div/div[2]/div/h3/a");
	By collectionName2 = By.xpath("/html/body/main/div/div/ul/li[1]/div/div/div[2]/div/h3/a");
	By firstProduct = By.xpath("/html/body/main/div[2]/div/div/div/div/ul/li[1]/div/div/div[2]/div[1]/h3/a");
	By addToCartBtn = By.xpath("/html/body/main/section[1]/section/div/div[2]/product-info/div[5]/product-form/form/div/button");
	By homeIcon = By.xpath("/html/body/div[3]/sticky-header/header/a/div/img");	
	By addToCartIcon = By.xpath("/html/body/div[3]/sticky-header/header/div/a[2]/div");
	By addToCartIcon2 = By.xpath("/html/body/div[3]/cart-notification/div/div/div[3]/a");
	By prodQtyIncrBtn = By.xpath("/html/body/main/div[1]/cart-items/form/div/div/table/tbody/tr/td[4]/div[1]/quantity-input/button[2]");
	By prodQtyInput = By.xpath("/html/body/main/div[1]/cart-items/form/div/div/table/tbody/tr/td[4]/div[1]/quantity-input/input");
	By prodQtyInput2 = By.xpath("/html/body/main/section[1]/section/div/div[2]/product-info/div[4]/quantity-input/input");
	By prodQtyInput3 = By.xpath("/html/body/main/div[1]/cart-items/form/div/div/table/tbody/tr/td[4]/div[1]/quantity-input/input");
	By prodQtyDecrBtn = By.xpath("/html/body/main/div[1]/cart-items/form/div/div/table/tbody/tr/td[4]/div[1]/quantity-input/button[1]");
	By viewCartBtn = By.id("cart-notification-button");
	By cartHeading = By.xpath("/html/body/main/div[1]/cart-items/div[1]/h1");
	
	
	public void addToCart() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(homeIcon).click();
		Thread.sleep(2000);
		driver.findElement(shopNowBtn).click();
		Allure.step("Clicked on shopnow button");
		Thread.sleep(2000);
		driver.findElement(collectionName1).click();
		Allure.step("Clicked on a collection");
		Thread.sleep(2000);
		driver.findElement(firstProduct).click();
		Allure.step("Clicked on product name");
		Thread.sleep(2000);
		driver.findElement(addToCartBtn).click();
		Allure.step("Clicked on add to cart button");
		
	}
	public void cartViewHeader() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(addToCartIcon).click();
		Allure.step("Clicked on add to cart icon from header menu ");
		
	}
	public void cartViewPopup() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(addToCartIcon2).click();
		Allure.step("Clicked on add to cart icon from popup menu");
	}
	
	public void productQuantityIncreaseByIcon()
	{
		driver.findElement(prodQtyIncrBtn).click();
		Allure.step("Clicked on product quantity (+) button");
		
	}
	public void productQuantityDecreaseByIcon()
	{
		driver.findElement(prodQtyDecrBtn).click();
		Allure.step("Clicked on product quantity (-) button");
		
	}
	public void productQuantityInputArea()
	{
		driver.findElement(prodQtyInput).clear();
		driver.findElement(prodQtyInput).sendKeys("10");
		Allure.step("Entered product quantity in input area");
		driver.findElement(cartHeading).click();
		
	}
	public void productQuantityVerification() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(homeIcon).click();
		Thread.sleep(2000);
		driver.findElement(shopNowBtn).click();
		Allure.step("Clicked on shopnow button");
		Thread.sleep(2000);
		driver.findElement(collectionName2).click();
		Allure.step("Clicked on a collection");
		Thread.sleep(2000);
		driver.findElement(firstProduct).click();
		Allure.step("Clicked on product name");
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("window.scrollBy(0,500)"); 
		
		driver.findElement(prodQtyInput2).clear();
		driver.findElement(prodQtyInput2).sendKeys("5");
		Allure.step("Entered product quantity in input area");
		Thread.sleep(2000);
		driver.findElement(addToCartBtn).click();
		Allure.step("Clicked on add to cart button");
		
		Thread.sleep(2000);
		//verify view cart button details
		
		String actBtnName = driver.findElement(viewCartBtn).getText();
		String expBtnName = "View cart (5)";
		softAssert.assertEquals(actBtnName, expBtnName, "Quantity mistmatch in button name ");
		Allure.step("Verified quantity in view cart button");
		
		Thread.sleep(2000);
		driver.findElement(viewCartBtn).click();
		Allure.step("Clicked on view cart button");
		
		
		String actProdQty = "5";
		String expProdQty = driver.findElement(prodQtyInput3).getAttribute("value");
		softAssert.assertEquals(actProdQty, expProdQty, "Quantity mistmatch");
		Allure.step("Verified product quantity");
		
		softAssert.assertAll();
		
	}
	public void emptyCart()
	{
		driver.findElement(addToCartIcon).click();
		Allure.step("Clicked on add to cart icon from header menu ");
		
		for(int i=1;i<2;i++)
		{
		By removeProdBtnFromCart = By.xpath("//*[@id=\"Remove-"+i+"\"]/a");
		if(driver.findElement(removeProdBtnFromCart).isDisplayed())
		driver.findElement(removeProdBtnFromCart).click();
		}
		
		
	}
	
	

}

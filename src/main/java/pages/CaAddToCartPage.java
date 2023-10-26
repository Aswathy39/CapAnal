package pages;

import org.openqa.selenium.By;
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
	By firstProduct = By.xpath("/html/body/main/div[2]/div/div/div/div/ul/li[1]/div/div/div[2]/div[1]/h3/a");
	By addToCartBtn = By.xpath("/html/body/main/section[1]/section/div/div[2]/product-info/div[5]/product-form/form/div/button");
	By homeIcon = By.xpath("/html/body/div[3]/sticky-header/header/a/div/img");	
	By addToCartIcon = By.xpath("/html/body/div[3]/sticky-header/header/div/a[2]/div");
	By addToCartIcon2 = By.xpath("/html/body/div[3]/cart-notification/div/div/div[3]/a");
	By prodQtyIncrBtn = By.xpath("/html/body/main/div[1]/cart-items/form/div/div/table/tbody/tr/td[4]/div[1]/quantity-input/button[2]");
	By prodQtyInput = By.xpath("/html/body/main/div[1]/cart-items/form/div/div/table/tbody/tr/td[4]/div[1]/quantity-input/input");
	By prodQtyDecrBtn = By.xpath("/html/body/main/div[1]/cart-items/form/div/div/table/tbody/tr/td[4]/div[1]/quantity-input/button[1]");
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
		
	}

}

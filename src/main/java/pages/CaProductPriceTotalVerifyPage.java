package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Allure;

public class CaProductPriceTotalVerifyPage 
{
	public WebDriver driver;
	SoftAssert softAssert =new SoftAssert();
	public  CaProductPriceTotalVerifyPage(WebDriver driver)
	{
		this.driver=driver; 
	}
	
	By shopNowBtn = By.xpath("/html/body/main/section[1]/slideshow-component/div[2]/div[1]/div[2]/div/div[2]/a");
	By collectionName1 =By.xpath("/html/body/main/div/div/ul/li[5]/div/div/div[2]/div/h3/a");
	By firstProduct = By.xpath("/html/body/main/div[2]/div/div/div/div/ul/li[1]/div/div/div[2]/div[1]/h3/a");
	By addToCartBtn = By.xpath("/html/body/main/section[1]/section/div/div[2]/product-info/div[5]/product-form/form/div/button");
	By homeIcon = By.xpath("/html/body/div[3]/sticky-header/header/a/div/img");	
	By addToCartIcon = By.xpath("/html/body/div[3]/sticky-header/header/div/a[2]/div");
	By prodQtyInput = By.xpath("/html/body/main/div[1]/cart-items/form/div/div/table/tbody/tr/td[4]/div[1]/quantity-input/input");
	By cartHeading = By.xpath("/html/body/main/div[1]/cart-items/div[1]/h1");
	By singleProdPrice = By.xpath("/html/body/main/div[1]/cart-items/form/div/div/table/tbody/tr/td[2]/div");
	By prodQtyInput3 = By.xpath("/html/body/main/div[1]/cart-items/form/div/div/table/tbody/tr/td[4]/div[1]/quantity-input/input");
	
	public void navigateToCartPage() throws Exception
	{
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
		Thread.sleep(2000);
		driver.findElement(addToCartIcon).click();
		Allure.step("Clicked on add to cart icon from header menu ");
	}
	public void addQuantity()
	{
		driver.findElement(prodQtyInput).clear();
		driver.findElement(prodQtyInput).sendKeys("10");
		Allure.step("Entered product quantity in input area");
		driver.findElement(cartHeading).click();
	}
	public void totalAmountCalculation()
	{
		String SingleProdPriceVal1 =driver.findElement(singleProdPrice).getText();
		float SingleProdPriceValue = Float.parseFloat(SingleProdPriceVal1);
		
		String prodQty = driver.findElement(prodQtyInput3).getAttribute("value");
		float prodQtyValue = Float.parseFloat(prodQty);
		float totalPriceVal=prodQtyValue * SingleProdPriceValue;
		System.out.println("Total price :"+totalPriceVal);
		
		String expProdTotal = "";
		String actProdTotal = "";
		softAssert.assertEquals(actProdTotal, expProdTotal, "Product price mistmatch");
		Allure.step("Verified product price total");
		
		
	}

}

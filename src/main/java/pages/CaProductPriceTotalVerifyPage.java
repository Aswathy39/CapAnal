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
	By continueShop = By.xpath("//a[@href='/collections/all']");
	
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
		//to trim the currency symbol
		SingleProdPriceVal1 = SingleProdPriceVal1.replace("£","");
		//convert string to float value
		float SingleProdPriceValue = Float.parseFloat(SingleProdPriceVal1);
		//to get 'quantity' from the field. And assigned as string value.
		String prodQty = driver.findElement(prodQtyInput3).getAttribute("value");
		//converted string to float
		float prodQtyValue = Float.parseFloat(prodQty);
		
		float totalPriceVal=prodQtyValue * SingleProdPriceValue;
		System.out.println("Total price :"+totalPriceVal);
		//the total value received from line 67 is again converted to string to verify
		String totalPriceValue2 =Float.toString(totalPriceVal);
	
		String expProdTotal = totalPriceValue2;
		String actProdTotal = driver.findElement(singleProdPrice).getText();
		softAssert.assertEquals(actProdTotal, expProdTotal, "Product price mistmatch");
		Allure.step("Verified product price total");
	}
	
	public void continueShoppingFromCart() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(continueShop).click();
		Allure.step("Clicked on continue shopping link from cart");
		
		String expURL = "https://capital-analytical.myshopify.com/collections/all";
		String actURL = driver.getCurrentUrl();
		softAssert.assertEquals(actURL, expURL, "URL mistmatch");
		Allure.step("Verified continue shopping url");
		
	}

}

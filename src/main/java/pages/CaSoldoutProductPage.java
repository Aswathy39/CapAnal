package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Allure;

public class CaSoldoutProductPage 
{
	public WebDriver driver;
	SoftAssert softAssert =new SoftAssert();
	public  CaSoldoutProductPage(WebDriver driver)
	{
		this.driver=driver; 
	}
	//By homeIcon = By.xpath("/html/body/div[3]/sticky-header/header/a/div/img");
	By homeIcon=By.xpath("//img[@class=\"header__heading-logo motion-reduce\"]");
	By shopNowBtn = By.xpath("/html/body/main/section[1]/slideshow-component/div[2]/div[1]/div[2]/div/div[2]/a");
	//By collection1 = By.xpath("/html/body/main/div/div/ul/li[5]/div/div/div[2]/div/h3/a");
	By collection1=By.linkText("Autosampler Vials & Sampling containers");
	By product2 = By.xpath("/html/body/main/div[2]/div/div/div/div/ul/li[2]/div/div/div[2]/div[1]/h3/a");
	By soldOutBtn = By.xpath("/html/body/main/section[1]/section/div/div[2]/product-info/div[5]/product-form/form/div/button");
	
	
	public void selectProduct() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(homeIcon).click();
		Thread.sleep(2000);
		driver.findElement(shopNowBtn).click();
		Allure.step("Clicked on shop now button");
		
		driver.findElement(collection1).click();
		Allure.step("Clicked on Autosampler Vials & Sampling containers");
		driver.findElement(product2).click();
		Allure.step("Clicked on product");
		
		Boolean soldOutVal =driver.findElement(soldOutBtn).isEnabled();
		System.out.println("Is enabled or not :"+soldOutVal);
		
		Boolean actValue =false;
		Boolean expValue =soldOutVal;
		softAssert.assertEquals(actValue, expValue, "Value mismatch");
		Allure.step("Verified Soldout button is enabled or not");

	}

}

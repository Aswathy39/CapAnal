package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Allure;

public class CaSearchProductPage 
{
	public WebDriver driver;
	SoftAssert softAssert =new SoftAssert();
	public  CaSearchProductPage(WebDriver driver)
	{
		this.driver=driver; 
	}
	
	By searchBarIcon = By.xpath("/html/body/div[3]/sticky-header/header/details-modal/details/summary");
	By searchBar = By.xpath("//*[@id=\"Search-In-Modal-1\"]");  
	By productName = By.xpath("/html/body/main/section/div/div[2]/div/div/ul/li[1]/div/div/div[2]/div[1]/h3/a");
	By searchBar2 = By.xpath("//*[@id=\"Search-In-Template\"]");
	By resetBtn = By.xpath("/html/body/main/section/div/div[1]/div/predictive-search/main-search/form/div/button[1]");
	By fstProductInLIst = By.id("predictive-search-option-product-1");
	By prodName =By.xpath("/html/body/main/section[1]/section/div/div[2]/product-info/div[1]/h1");
	By homeIcon =By.xpath("//html/body/div[3]/sticky-header/header/a/div/img");
	By validationStatus = By.xpath("/html/body/main/section/div/div[1]/p");
	
	public void search() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(searchBarIcon).click();
		Allure.step("Clicked on search icon");
		Thread.sleep(2000);
		driver.findElement(searchBar).click();
		driver.findElement(searchBar).sendKeys("WATCH GLASS 40mm");
		Allure.step("Entered product name");
		driver.findElement(searchBar).sendKeys(Keys.ENTER);
		Allure.step("Enter key is pressed");
		
	}
	public void verifyProductSearched() throws Exception
	{
		Thread.sleep(2000);
		String actProductName ="WATCH GLASS 40mm";
		String expProductName = driver.findElement(productName).getText();
		softAssert.assertEquals(actProductName, expProductName, "Product Name Mismatch");
		softAssert.assertAll();
		Allure.step("Verified product search");
	}
	public void findProductFromDropdown() throws Exception
	{
		driver.findElement(resetBtn).click();
		driver.findElement(searchBar2).click();
		driver.findElement(searchBar2).sendKeys("WATCH GLASS 40mm");
		Allure.step("Entered product name");
		Thread.sleep(2000);
		driver.findElement(fstProductInLIst).click();
		Allure.step("Clicked on first product listed from search");
		
	}
	public void verifyProductListed() throws Exception
	{
		Thread.sleep(2000);
		String actProductName ="WATCH GLASS 40mm";
		String expProductName = driver.findElement(prodName).getText();
		softAssert.assertEquals(actProductName, expProductName, "Product Name Mismatch");
		softAssert.assertAll();
		Allure.step("Verified partial product search");
	}
	public void searchWithPartialProdName() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(searchBarIcon).click();
		Allure.step("Clicked on search icon");
		Thread.sleep(2000);
		driver.findElement(searchBar).click();
		driver.findElement(searchBar).sendKeys("WATCH");
		Allure.step("Entered product name");
		driver.findElement(searchBar).sendKeys(Keys.ENTER);
		Allure.step("Enter key is pressed");
	}
	public void invalidSearch() throws Exception
	{
		driver.findElement(homeIcon).click();
		Thread.sleep(2000);
		driver.findElement(searchBarIcon).click();
		Allure.step("Clicked on search icon");
		Thread.sleep(2000);
		driver.findElement(searchBar).click();
		driver.findElement(searchBar).sendKeys("dajkhbfgdsvdbgs()*&#876544w");
		Allure.step("Entered product name");
		driver.findElement(searchBar).sendKeys(Keys.ENTER);
		Allure.step("Enter key is pressed");
		
	}
	public void verifyInvalidSearch() throws Exception
	{
		Thread.sleep(2000);
		String actProductName ="No results found for “dajkhbfgdsvdbgs()*&#876544w”. Check the spelling or use a different word or phrase.";
		String expProductName = driver.findElement(validationStatus).getText();
		softAssert.assertEquals(actProductName, expProductName, "Validation Message Mismatch");
		softAssert.assertAll();
		Allure.step("Verified invalid product search validation message");
	}
	

}

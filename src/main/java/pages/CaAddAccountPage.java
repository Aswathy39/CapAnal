package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Allure;

public class CaAddAccountPage 

{
	public WebDriver driver;
	SoftAssert softAssert =new SoftAssert();
	

	public  CaAddAccountPage(WebDriver driver)
	{
		this.driver=driver; 
	}
	
	By accounticon=By.xpath("//*[@id=\"shopify-section-sections--16897772519638__header\"]/sticky-header/header/div/a[1]");//account icon
	By Creataccountlink=By.xpath("//*[@id=\"customer_login\"]/a[2]");//create account link
	By firstname=By.xpath("//*[@id=\"RegisterForm-FirstName\"]");//firstname
	By lastname=By.xpath("//*[@id=\"RegisterForm-LastName\"]");//lastname
	By emaild=By.xpath("//*[@id=\"RegisterForm-email\"]");//emaild
	By password=By.xpath("//*[@id=\"RegisterForm-password\"]");//password
	By createbutton=By.xpath("//*[@id=\"create_customer\"]/button");//password
	By logout =By.xpath("//*[@id=\"shopify-section-template--16897772126422__main\"]/div/div[1]/a");
	By createAcc =By.xpath("/html/body/main/div/div/div[2]/form/a[2]");
	
	
	public void navigateToAccountCreation() throws Exception
	{
		driver.findElement(accounticon).click();
		Allure.step("Clicked on profile icon");
		Thread.sleep(3000);
		driver.findElement(Creataccountlink).click();
		Allure.step("Clicked on create account link");
		
		String ActualUrl= "https://capital-analytical.myshopify.com/account/register";
		String ExpUrl= driver.getCurrentUrl();
		softAssert.assertEquals(ActualUrl, ExpUrl, "URL Mismatched");
		Allure.step("Verified url ");
		softAssert.assertAll();

	}
	public void logout() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(logout).click();
		
	}
	public void accountCreation() throws Exception
	{
		//first name
		driver.findElement(firstname).sendKeys("Gregory");
		//last name
		driver.findElement(lastname).sendKeys("Emerson");
		//emailid
		driver.findElement(emaild).sendKeys("test16@ascensor.com");
		//password
		driver.findElement(password).sendKeys("GREGORY12");
		//create button
		driver.findElement(createbutton).click();
		
		
	}
	public void accountCreationEmailExist() throws Exception
	{
		//wait to set captcha
		Thread.sleep(3000);
		driver.findElement(accounticon).click();
//		driver.findElement(Creataccountlink).click();
		Thread.sleep(4000);
		logout();
		Thread.sleep(3000);
//		JavascriptExecutor js = (JavascriptExecutor) driver; 
//		js.executeScript("window.scrollBy(0,500)"); 
		driver.findElement(accounticon).click();
		Thread.sleep(2000);
		driver.findElement(createAcc).click();
		
		Allure.step("Clicked on create account link");
		//first name
		driver.findElement(firstname).sendKeys("Gregory");
		//last name
		driver.findElement(lastname).sendKeys("Emerson");
		//emailid
		driver.findElement(emaild).sendKeys("sit38@ascensor.com");
		//password
		driver.findElement(password).sendKeys("GREGORY12");
		//create button
		driver.findElement(createbutton).click();

	}
	public void accountCreationInvalid() throws Exception
	{
		driver.navigate().refresh();
		driver.findElement(accounticon).click();
		Thread.sleep(2000);
		driver.findElement(createAcc).click();
		Allure.step("Clicked on profile icon");
		//first name
		driver.findElement(firstname).sendKeys("jyyfhv*^%$#23456");
		//last name
		driver.findElement(lastname).sendKeys(",ugfsers*^%$#@45u8674");
		//emailid
		driver.findElement(emaild).sendKeys("gg)(*^5434456(*^%456(*^%$#");
		//password
		driver.findElement(password).sendKeys("HFRDERSuiytdr^%$@456&^%$#");
		//create button
		driver.findElement(createbutton).click();

	}
	public void accountCreationEmpty() throws Exception
	{
		driver.navigate().refresh();
		driver.findElement(accounticon).click();
		Thread.sleep(2000);
		driver.findElement(createAcc).click();
		//create button
		driver.findElement(createbutton).click();

	}


}

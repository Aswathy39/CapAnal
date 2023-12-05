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
	//By createAcc =By.xpath("/html/body/main/div/div/div[2]/form/a[2]");
	By createAcc=By.xpath("//a[@href=\"/account/register\"]");//create account link
	By email_exist=By.xpath("//form[@id='create_customer']/ul/li");//email existing validation
	By validationmessage=By.xpath("//a[@href=\"#RegisterForm-email\"]");
	By validationmessage2=By.xpath("//a[@href='#RegisterForm-email']");
	
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
		Allure.step("Verified the user redirected to account creation page");
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
		Allure.step("Entered firstname");
		//last name
		driver.findElement(lastname).sendKeys("Emerson");
		Allure.step("Entered lastname");
		//emailid
		driver.findElement(emaild).sendKeys("testing319@ascensor.com");
		Allure.step("Entered emaild");
		//password
		driver.findElement(password).sendKeys("GREGORY12");
		Allure.step("Entered password");
		//create button
		driver.findElement(createbutton).click();
		Allure.step("Clicked create button");
		String ActualUrl= "https://capital-analytical.myshopify.com/";
		String ExpUrl= driver.getCurrentUrl();
		softAssert.assertEquals(ActualUrl, ExpUrl, "URL Mismatched");
		Allure.step("Verified url ");
		softAssert.assertAll();
		
	}
	public void accountCreationEmailExist() throws Exception
	{
		//wait to set captcha
		Thread.sleep(3000);
		driver.findElement(accounticon).click();
		Allure.step("Clicked on profile icon");
//		driver.findElement(Creataccountlink).click();
		Thread.sleep(4000);
		logout();
		Thread.sleep(3000);
//		JavascriptExecutor js = (JavascriptExecutor) driver; 
//		js.executeScript("window.scrollBy(0,500)"); 
		driver.findElement(accounticon).click();
		Allure.step("Clicked on profile icon");
		Thread.sleep(2000);
		driver.findElement(createAcc).click();
		Allure.step("Clicked on create account link");
		
		//first name
		driver.findElement(firstname).sendKeys("Gregory");
		Allure.step("Entered firstname");
		//last name
		driver.findElement(lastname).sendKeys("Emerson");
		Allure.step("Entered lastname");

		//emailid
		driver.findElement(emaild).sendKeys("test302@ascensor.com");
		Allure.step("Entered existing emailid");

		//password
		driver.findElement(password).sendKeys("GREGORY12");
		Allure.step("Entered password");
		//create button
		driver.findElement(createbutton).click();
		Allure.step("Clicked create button");
		
		String actMsg ="This email address is already associated with an account. If this account is yours, you can reset your password";
		String expMsg = driver.findElement(email_exist).getText();
		softAssert.assertEquals(expMsg, actMsg, "Message Mismatch");
		Allure.step("Verified the existing emailid validation message");
		softAssert.assertAll();
	}
	public void accountCreationInvalid() throws Exception
	{
		driver.navigate().refresh();
		driver.findElement(accounticon).click();
		Allure.step("Clicked on profile icon");
		Thread.sleep(3000);
		driver.findElement(createAcc).click();
		Allure.step("Clicked on profile icon");
		//first name
		driver.findElement(firstname).sendKeys("jyyfhv*^%$#23456");
		Allure.step("Entered invalid firstname");
		//last name
		driver.findElement(lastname).sendKeys(",ugfse09=s*^%$#@45u8674");
		Allure.step("Entered invalid lastname");
		//emailid
		driver.findElement(emaild).sendKeys("gg)(*^549e77=6(*^%456(^%$#");
		Allure.step("Entered invalid emailid");
		//password
		driver.findElement(password).sendKeys("HFDE3oSuitdr^%$@456&^%$#");
		Allure.step("Entered invalid password");
		//create button
		driver.findElement(createbutton).click();
		Allure.step("Clicked create button");
		
		
		String actMsg ="Email is invalid";
		String expMsg = driver.findElement(validationmessage).getText();
		softAssert.assertEquals(expMsg, actMsg, "Message Mismatch");
		Allure.step("Verified the validation message");
		softAssert.assertAll();

	}
	public void accountCreationEmpty() throws Exception
	{
		driver.navigate().refresh();
		driver.findElement(accounticon).click();
		Allure.step("Clicked on profile icon");
		Thread.sleep(3000);
		driver.findElement(createAcc).click();
		Allure.step("Clicked create account link");
		//create button
		driver.findElement(createbutton).click();
		Allure.step("Clicked create button");
		
		String actMsg ="Email can't be blank";
		String expMsg = driver.findElement(validationmessage2).getText();
		softAssert.assertEquals(expMsg, actMsg, "Message Mismatch");
		Allure.step("Verified the validation message");
		softAssert.assertAll();
	}
	public void createAccMandatoryFields() throws InterruptedException
	{
		driver.navigate().refresh();
		driver.findElement(accounticon).click();
		Allure.step("Clicked on profile icon");
		Thread.sleep(3000);
		driver.findElement(createAcc).click();
		driver.findElement(emaild).sendKeys("test700@ascensor.com");
		Allure.step("Entered emailid");
		//password
		driver.findElement(password).sendKeys("Herdyui");
		Allure.step("Entered password");
		//create button
		driver.findElement(createbutton).click();
		Allure.step("Clicked create button");
	}
	

}

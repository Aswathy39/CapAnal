package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Allure;

public class CaLoginPage
{
	public WebDriver driver;
	SoftAssert softAssert =new SoftAssert();
	

	public  CaLoginPage(WebDriver driver)
	{
		this.driver=driver; 
	}
	
	By accounticon=By.xpath("//*[@id=\"shopify-section-sections--16897772519638__header\"]/sticky-header/header/div/a[1]");//account icon 
	By LoginEmail = By.xpath("//*[@id=\"CustomerEmail\"]");
	By LoginPassword=By.xpath("//*[@id=\"CustomerPassword\"]");
	By signinbuton=By.xpath("//*[@id=\"customer_login\"]/button"); 
	By logout=By.xpath("//*[@id=\"shopify-section-template--16897772126422__main\"]/div/div[1]/a");
	By invalidMsg = By.xpath("//*[@id=\"customer_login\"]/div[1]/ul/li");
	
	
	public void navigateToLogin()
	{
		driver.findElement(accounticon).click();
		Allure.step("Clicked on contact form button to navigate to contact form");
	}
	public void LoginForm() throws Exception
	{
	driver.findElement(accounticon).click();
	Allure.step("Clicked on contact form button to navigate to contact form");
	//Email
	driver.findElement(LoginEmail).sendKeys("sit37@ascensor.com");
	Allure.step("Entered a new Emailid");
	//Password
	driver.findElement(LoginPassword).sendKeys("qwerty");
	Allure.step("Entered a new Password");
	//signin 
	driver.findElement(signinbuton).click();
	Allure.step("Clicked the signin button");
	
	Thread.sleep(1000);
	String actMsg ="Log out";
	String expMsg = driver.findElement(logout).getText();
	softAssert.assertEquals(expMsg, actMsg, "Message Mismatch");
	softAssert.assertAll();
	
	//logout  
	driver.findElement(logout).click();
	Allure.step("Clicked the Log out"); 
	}

	
	public void LogUseInvalidInfo() throws Exception
{ 
	driver.findElement(accounticon).click(); 
	Allure.step("Clicked on contact form button to navigate to contact form"); 
	//Email  
	driver.findElement(LoginEmail).sendKeys("emrson"); 
    Allure.step("Entered invalid Emailid");
     //Password     
	
    driver.findElement(LoginPassword).sendKeys("Emersopm233"); 
	Allure.step("Entered invalid Password");
   
	driver.findElement(signinbuton).click(); 
	Allure.step("Clicked the signin button");
	
	Thread.sleep(2000);
	String actMsg ="Incorrect email or password.";
	String expMsg = driver.findElement(invalidMsg).getText();
	softAssert.assertEquals(expMsg, actMsg, "Message Mismatch");
	softAssert.assertAll();
} 
	
	public void LogUseEmptyForm() throws Exception
	{
	//signin
	driver.findElement(signinbuton).click(); 
	Allure.step("Clicked the signin button without entering emailid and password ");
	
	Thread.sleep(2000);
	String actMsg ="Incorrect email or password.";
	String expMsg = driver.findElement(invalidMsg).getText();
	softAssert.assertEquals(expMsg, actMsg, "Message Mismatch");
	
	softAssert.assertAll();
	}
	
	public void LoginValiduserInvalidpass() throws Exception
{ 
	driver.findElement(accounticon).click();
   Allure.step("Clicked on contact form button to navigate to contact form");
	//Email    
  driver.findElement(LoginEmail).sendKeys("sit37@ascensor.com"); 
	Allure.step("Entered correct Emailid"); 
	//Password       

	driver.findElement(LoginPassword).sendKeys("tiuyiuyio"); 
	Allure.step("Entered incorrect Password"); 

	//signin  
	driver.findElement(signinbuton).click(); 
	Allure.step("Clicked the signin button");
	
	Thread.sleep(2000);
	String actMsg ="Incorrect email or password.";
	String expMsg = driver.findElement(invalidMsg).getText();
	softAssert.assertEquals(expMsg, actMsg, "Message Mismatch");
	
	softAssert.assertAll();
}
	public void LoginInvaliduservalidpass() throws Exception
	{
	driver.findElement(accounticon).click(); 
	Allure.step("Clicked on contact form button to navigate to contact form");
    //Email
    driver.findElement(LoginEmail).sendKeys("hgjh"); 
    Allure.step("Entered incorrect Emailid"); 
//Password     
	 driver.findElement(LoginPassword).sendKeys("qwerty"); 
	 Allure.step("Entered correct Password"); 

	 //signin
	 driver.findElement(signinbuton).click();
	 Allure.step("Clicked the signin button");
	 
	 Thread.sleep(2000);	
	 String actMsg ="Incorrect email or password.";
		String expMsg = driver.findElement(invalidMsg).getText();
		softAssert.assertEquals(expMsg, actMsg, "Message Mismatch");
		softAssert.assertAll();
	 
	 }
	public void LoginInactiveUsernameAndPassowrd() throws Exception
       {
	driver.findElement(accounticon).click(); 
	Allure.step("Clicked on contact form button to navigate to contact form");
    //Email 
	driver.findElement(LoginEmail).sendKeys("sit40@ascensor.com");
    Allure.step("Entered inactive Emailid");

	//Password  

    driver.findElement(LoginPassword).sendKeys("123456789"); 
    Allure.step("Entered inactive Password"); 
	//signin 
	driver.findElement(signinbuton).click();
	Allure.step("Clicked the signin button"); 
	
	Thread.sleep(2000);
	String actMsg ="Incorrect email or password.";
	String expMsg = driver.findElement(invalidMsg).getText();
	softAssert.assertEquals(expMsg, actMsg, "Message Mismatch");
	
	softAssert.assertAll();
   }
  public void loginAndBack() throws Exception
  {
	  LoginForm();
	  driver.navigate(). back();
	  
	  Thread.sleep(1000);
	  String actMsg ="https://capital-analytical.myshopify.com/account/login";
	  String expMsg = driver.getCurrentUrl();
	  softAssert.assertEquals(expMsg, actMsg, "URL Mismatch");
	  softAssert.assertAll();
		
  }
	
	
	
	
}

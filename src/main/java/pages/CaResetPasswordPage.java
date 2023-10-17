package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Allure;
public class CaResetPasswordPage {
	public WebDriver driver;
	SoftAssert softAssert =new SoftAssert();
	

	public  CaResetPasswordPage(WebDriver driver)
	{
		this.driver=driver; 
	}
	By accounticon=By.xpath("//*[@id=\"shopify-section-sections--16897772519638__header\"]/sticky-header/header/div/a[1]");//account icon   
	By passwordresetlink = By.linkText("Forgot your password?");
	//reset password link 
	By emaiild=By.name("email");
	//email field  
	By submit=By.xpath("//*[@id=\"shopify-section-template--16897772191958__main\"]/div/div[1]/form/button");
	By mesage=By.xpath("/html/body/div/div[2]/div[2]/div");
	By cancelLink=By.linkText("Cancel");
	By invalidMsg = By.xpath("//*[@id=\"shopify-section-template--16897772191958__main\"]/div/div[2]/h3");
	By resetPassValidatnMsg =By.xpath("//*[@id=\"RecoverEmail-email-error\"]");
	
	
	public void navigateToResetPassword() 
	{ 
	driver.findElement(accounticon).click();
	Allure.step("Clicked on contact form button to navigate to contact form"); 
	driver.findElement(passwordresetlink).click(); 
	Allure.step("Clicked on contact form button to navigate to contact form");
	
	String actMsg ="https://capital-analytical.myshopify.com/account/login#recover";
	String expMsg = driver.getCurrentUrl();
	softAssert.assertEquals(expMsg, actMsg, "URL Mismatch");
	softAssert.assertAll();
	Allure.step("Reset password URL Verified");
	}
	public void resetpassword() throws InterruptedException 
	{
		//clicking account icon   
		driver.findElement(accounticon).click(); 
		Allure.step("Clicked on contact form button to navigate to contact form"); 
		//password reset link    
		driver.findElement(passwordresetlink).click(); 
		Allure.step("Clicked on contact form button to navigate to contact form"); 
		//email field    
		driver.findElement(emaiild).sendKeys("test12@ascensor.com"); 
		Allure.step("Entered Emailid to receive an email to reset your password"); 
		//submit button 
		driver.findElement(submit).click(); 
		Allure.step("Clicked submit button");
        Thread.sleep(2000);
		String ActnmTxt =driver.getCurrentUrl();
		String ExpnmTxt = "https://capital-analytical.myshopify.com/account/login"; 
		softAssert.assertEquals(ActnmTxt, ExpnmTxt, "URL Mismatched"); 
		softAssert.assertAll(); 
	}
	public void PasswordResetFormEmpty() throws InterruptedException 
    {
	driver.findElement(submit).click();
	Allure.step("Clicked submit button");
	
	String ActText ="No account found with that email.";
	String expText =driver.findElement(resetPassValidatnMsg).getText();
	softAssert.assertEquals(ActText, expText, "Validation message mismatch");
	softAssert.assertAll(); 
	} 
	public void PasswordResetInvalidDetail() throws InterruptedException 
	{ 

	//email field       
	driver.findElement(emaiild).sendKeys("ytuiYRRTYF@ascensor.com"); 
	Allure.step("Entered Emailid to receive an email to reset your password"); 
	//submit button    
	driver.findElement(submit).click(); 
	Allure.step("Clicked submit button"); 
	Thread.sleep(2000);
	String ActText ="No account found with that email.";
	String expText =driver.findElement(resetPassValidatnMsg).getText();
	softAssert.assertEquals(ActText, expText, "Validation message mismatch");
	softAssert.assertAll(); 
	} 
	public void PasswordResetCancelLink() throws InterruptedException 
	{ 
	driver.findElement(cancelLink).click(); 
	Allure.step("Clicked the cancel link to navigate back to the login page"); 
	Thread.sleep(2000);
	String ActnmTxt =driver.getCurrentUrl(); 
	String ExpnmTxt = "https://capital-analytical.myshopify.com/account/login#login"; 
	softAssert.assertEquals(ActnmTxt, ExpnmTxt, "URL Mismatched");
	softAssert.assertAll();
	} 
	public void PasswResetInvalidEmailFormat() throws InterruptedException 
	{ 		
	//email field       
	driver.findElement(emaiild).sendKeys("ytGui"); 
	Allure.step("Entered Invalid Email format"); 
	//submit button    
	driver.findElement(submit).click(); 
	Allure.step("Clicked submit button"); 
	String ActnmTxt =driver.getCurrentUrl(); 
	String ExpnmTxt = "https://capital-analytical.myshopify.com/account/login#recover"; 
	softAssert.assertEquals(ActnmTxt, ExpnmTxt, "URL Mismatched");
	softAssert.assertAll();
	} 
	
}

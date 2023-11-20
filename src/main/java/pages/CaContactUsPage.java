
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Allure;

public class CaContactUsPage 

{
	public WebDriver driver;
	SoftAssert softAssert =new SoftAssert();
	

	public  CaContactUsPage(WebDriver driver)
	{
		this.driver=driver; 
	}
	
	//capital analytical icon
	By contact_us=By.xpath("//*[@id=\"shopify-section-sections--16897772486870__footer\"]/footer/div[1]/div[1]/div[1]/ul/li[2]/a");//account icon
	By name=By.xpath("//input[@name='contact[Name]']");//name
	By email =By.xpath("//input[@id='ContactForm-email']");//email
	By phoneno =By.xpath("//input[@id='ContactForm-phone']");
	By comments =By.xpath("//textarea[@id='ContactForm-body']");
	By send_Button=By.xpath("//button[@class=\"button\"]");
	By Verifysuccessmessage=By.xpath("/html/body/main/section[2]/div/div/form/h2");
	By invalid_message=By.linkText("Email is invalid");
	
	By cookieaccept=By.xpath("/html/body/div[2]/div/div[1]/button[3]");
	
	public void navigateToContactUsPage() throws Exception
	{
		/*driver.findElement(cookieaccept).click();
		Allure.step("Accepted cookie");*/

		JavascriptExecutor js1 = (JavascriptExecutor) driver; 
		 js1.executeScript("window.scrollBy(0,600)"); 
		driver.findElement(contact_us).click();
		Allure.step("Clicked on capital analytical icon");
		Thread.sleep(3000);
		


	}
	public void AddContactUsFormDetails() throws Exception
	{
		
		driver.findElement(name).sendKeys("Arnavil");
		Allure.step("Entered name");
		driver.findElement(email).sendKeys("Arnavil@gmail.com");
		Allure.step("Entered email");
		driver.findElement(phoneno).sendKeys("01234567891");
		Allure.step("Entered phoneno");
		driver.findElement(comments).sendKeys("Test Data to check the contact form. Testing the comments");
		Allure.step("Entered comments");
		
		//scroll down to view the button    
		 
		 JavascriptExecutor js1 = (JavascriptExecutor) driver; 
		 js1.executeScript("window.scrollBy(0,400)"); 
		
		driver.findElement(send_Button).click();
		Allure.step("Clicked send button");
		Thread.sleep(12000); 
		String ActualUrl= "Thanks for contacting us. We'll get back to you as soon as possible.";
		String ExpUrl= driver.findElement(Verifysuccessmessage).getText();
		softAssert.assertEquals(ActualUrl, ExpUrl, "URL Mismatched");
		Allure.step("Verified url ");
		softAssert.assertAll();
		
	}
	public void SubmitContactFormEmptyfields() throws Exception
	{
		
		
		//wait for 3 seconds and click 'find out more and apply     
		Thread.sleep(3000); 
		JavascriptExecutor js1 = (JavascriptExecutor) driver; 
		js1.executeScript("window.scrollBy(0,400)");		
		driver.findElement(send_Button).click();
		Allure.step("Clicked send button without entering details");
		Thread.sleep(12000); 
		String ActualUrl= "Email is invalid";
		String ExpUrl= driver.findElement(invalid_message).getText();
		softAssert.assertEquals(ActualUrl, ExpUrl, "validation message Mismatched");
		Allure.step("Verified validation message ");
		softAssert.assertAll();
		
	}
	public void InvalidEmailContactUsFormSub() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(name).sendKeys("Arnavil");
		Allure.step("Entered name");
		driver.findElement(email).sendKeys("Ar87097080");
		Allure.step("Entered invalid email");
		driver.findElement(phoneno).sendKeys("01234567891");
		Allure.step("Entered phoneno");
		driver.findElement(comments).sendKeys("Test Data to check the contact form. Testing the comments. Test Data to check the contact form. Testing the comments. Test Data to check the contact form. Testing the comments. Test Data to check the contact form. Testing the comments"
				+ ". Test Data to check the contact form. Testing the comments");
		Allure.step("Entered name");
		
		//scrolldown     
	
		JavascriptExecutor js1 = (JavascriptExecutor) driver; 
		js1.executeScript("window.scrollBy(0,400)"); 
		driver.findElement(send_Button).click();
		Allure.step("Clicked send button by entered invalid email id");
		Thread.sleep(12000); 
	
		WebElement e1 = driver.findElement(email);
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		String actual = (String)js.executeScript("return arguments[0].validationMessage;", e1); 
		String expected = "Please include an '@' in the email address. 'Ar87097080' is missing an '@'."; 
		softAssert.assertEquals(actual, expected, "validation Mismatched");
		System.out.println(actual.equals(expected));
		
		
		/*String ActualUrl= "Email is invalid";
		String ExpUrl= driver.findElement(invalid_message).getText();
		softAssert.assertEquals(ActualUrl, ExpUrl, "URL Mismatched");
		Allure.step("Verified url ");*/
		softAssert.assertAll();
		
	}
}
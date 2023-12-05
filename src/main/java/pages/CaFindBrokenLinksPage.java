package pages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class CaFindBrokenLinksPage
{
	public WebDriver driver;
	SoftAssert softAssert =new SoftAssert();
	public  CaFindBrokenLinksPage(WebDriver driver)
	{
		this.driver=driver; 
	}
//	By
	
	public void FindLinks()
	{
		List <WebElement> links = driver.findElements(By.tagName("a"));


		// Iterating each link and checking the response status
		for (WebElement link : links)
		{
			
		String url = link.getAttribute("href");
		verifyLink(url);
		}
	}
	public void verifyLink(String url)
	{
		try 
		{
			URL link = new URL(url);
			HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
			httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
			httpURLConnection.connect();


			if (httpURLConnection.getResponseCode() == 200) 
			{
				System.out.println(url + " - " + httpURLConnection.getResponseMessage());
				
				String actMsg =httpURLConnection.getResponseMessage();
				String expMsg = "OK";
				softAssert.assertEquals(actMsg, expMsg, "Broken Link Found");
				softAssert.assertAll();
				
				
			} 
			else 
			{
				System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
				
				//will found broken links 
				String actMsg =httpURLConnection.getResponseMessage();
				String expMsg = "OK";
				softAssert.assertEquals(actMsg, expMsg, "Broken Link Found");
				softAssert.assertAll();
				
			}
		}
		catch (Exception e) 
		{
			System.out.println(url + " - " + "is a broken link");
			
		}
		
	}

}

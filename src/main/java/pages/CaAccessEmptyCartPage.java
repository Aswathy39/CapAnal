package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Allure;
public class CaAccessEmptyCartPage {
	public WebDriver driver;
	SoftAssert softAssert =new SoftAssert();

	public  CaAccessEmptyCartPage(WebDriver driver)
	{
		this.driver=driver; 
	}
    By CartIcon_Home = By.xpath("//a[@class='header__icon header__icon--cart link focus-inset']");//cart icon
	By cart_empty_msg=By.xpath("//h2[@class='cart__empty-text']");//empty msg showing clicking cart icon
	By continue_shopping=By.xpath("//a[@href='/collections/all']");
	By login_cart_screen=By.xpath("(//a[@href='/account/login'])[1]");
	
	public void navigateTo_Empty_Cart()
	{
		driver.findElement(CartIcon_Home).click();
		Allure.step("Clicked on cart icon");
		
		//verifying 'cart empty' message
		String ActualUrl= "Your cart is empty";
		String ExpUrl= driver.findElement(cart_empty_msg).getText();
		softAssert.assertEquals(ActualUrl, ExpUrl, "URL Mismatched");
		Allure.step("Verified url ");
		softAssert.assertAll();
		
		//click 'continue shopping'
		driver.findElement(continue_shopping).click();
		Allure.step("Clicked on continue_shopping");
		
		//verifying clicking 'continue shopping' button redirects to the correct url/page
		String ActualUrl_continueshop= "https://capital-analytical.myshopify.com/collections/all";
		String ExpUrl_continueshop= driver.getCurrentUrl();
		softAssert.assertEquals(ActualUrl_continueshop, ExpUrl_continueshop, "URL Mismatched");
		Allure.step("Verified url ");
		softAssert.assertAll();
		
		//click 'cart icon'
		driver.findElement(CartIcon_Home).click();
		Allure.step("Clicked on cart icon");
		
		//clicked 'login'
		driver.findElement(login_cart_screen).click();
		Allure.step("Clicked on Log in");
		
		//verifying clicking 'continue shopping' button redirects to the correct url/page
		String ActualUrl_login= "https://capital-analytical.myshopify.com/account/login";
		String ExpUrl_login= driver.getCurrentUrl();
		softAssert.assertEquals(ActualUrl_login, ExpUrl_login, "URL Mismatched");
		Allure.step("Verified url ");
		softAssert.assertAll();	
		
	}
}

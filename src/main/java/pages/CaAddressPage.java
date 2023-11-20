package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Allure;

public class CaAddressPage 
{
	
	public WebDriver driver;
	SoftAssert softAssert =new SoftAssert();
	public  CaAddressPage(WebDriver driver)
	{
		this.driver=driver; 
	}
	
	By ViewAddressLink = By.xpath("//*[@id=\"shopify-section-template--16897772126422__main\"]/div/div[2]/div[2]/a");
	By addAddressBtn = By.xpath("//*[@id=\"shopify-section-template--16897772290262__main\"]/div/div/button");
	By firstName =By.id("AddressFirstNameNew");
	By firstNameEdit = By.xpath("//li[2]/div/form/div/input");
	By lastName = By.id("AddressLastNameNew");
	By lastNameEdit = By.xpath("//li[2]/div/form/div[2]/input");
	By companyName = By.id("AddressCompanyNew");
	By companyNameEdit = By.xpath("//li[2]/div/form/div[3]/input");
	By addressOne = By.id("AddressAddress1New");
	By addressOneEdit = By.xpath("//li[2]/div/form/div[4]/input");
	By addressTwo = By.id("AddressAddress2New");
	By addressTwoEdit = By.xpath("//li[2]/div/form/div[5]/input");
	By city =By.id("AddressCityNew");
	By cityEdit=By.xpath("//li[2]/div/form/div[6]/input");
	By adrsCountry = By.id("AddressCountryNew");
	By countryDropEdit = By.xpath("//li[2]/div/form/div[7]/div/select");
	By country =By.xpath("//option[. = 'United Kingdom']");
	By country2 = By.xpath("/html/body/main/div/div/ul/li[2]/div/form/div[7]/div/select/option[15]");
	By postalCode=By.id("AddressZipNew");
	By postalCodeEdit=By.xpath("//li[2]/div/form/div[9]/input");
	By phone =By.id("AddressPhoneNew");
	By phoneEdit =By.xpath("//li[2]/div/form/div[10]/input");
	By submit = By.xpath("//*[@id=\"address_form_new\"]/div[12]/button[1]");
	By address =By.xpath("/html/body/main/div/div/div/button");
	By verifyAddrs = By.xpath("//li[2]/p");
	By cancelBtn = By.xpath("//*[@id=\"address_form_new\"]/div[12]/button[2]");
	By adrsVer =By.xpath("/html/body/main/div/div/div/div/h2");
	By edit = By.xpath("//li[2]/button");
	By updateBtn = By.xpath("/html/body/main/div/div/ul/li[2]/div/form/div[12]/button[1]");
	By deletebtn = By.xpath("//*[@id=\"shopify-section-template--16897772290262__main\"]/div/ul/li[2]/button[2]");
	By verifyAddrsDeleted = By.linkText("Daviz Gregori");
	
	public void navigateToAddressPage()
	{
		
		driver.findElement(ViewAddressLink).click();
		Allure.step("Clicked on view addresses link ");
		
		driver.findElement(addAddressBtn).click();
		Allure.step("Clicked on add address button");
		
	}
	public void addAddress() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(firstName).sendKeys("David");
		Allure.step("Entered first name ");
		driver.findElement(lastName).sendKeys("Gregory");
		Allure.step("Entered last name ");
		driver.findElement(companyName).sendKeys("David & G test company Limited");
		Allure.step("Entered company name ");
		driver.findElement(addressOne).sendKeys("20 mariantia flat");
		Allure.step("Entered address one");
		driver.findElement(addressTwo).sendKeys("near round road church");
		Allure.step("Entered address two ");
		driver.findElement(city).sendKeys("Mnchester");
		Allure.step("Entered city ");
		
		selectCountryDrop();
		Allure.step("Selected country from dropdown");
		
		driver.findElement(postalCode).sendKeys("M23 54D6");
		Allure.step("Entered postal code ");
		
		driver.findElement(phone).sendKeys("+44 1111111111");
		Allure.step("Entered phone number");
		driver.findElement(submit).click();
		Allure.step("Clicked on submit");
		
	}
	public void selectCountryDrop()
	{
		 driver.findElement(adrsCountry).click();
		    {
		      WebElement dropdown = driver.findElement(adrsCountry);
		      dropdown.findElement(country).click();
		    }
	}
	public void selectCountryDrop2()
	{
		 driver.findElement(countryDropEdit).click();
		    {
		      WebElement dropdown = driver.findElement(countryDropEdit);
		      dropdown.findElement(country2).click();
		    }
	}
	public void addEmptyAddress() throws Exception
	{
		Thread.sleep(3000);
		driver.findElement(address).click();
		Allure.step("Clicked on add address button");
		driver.findElement(submit).click();
		
		
	}
	public void clickCancelBtn() throws Exception
	{
		Thread.sleep(3000);
		driver.findElement(address).click();
		
		Thread.sleep(2000);
		driver.findElement(firstName).sendKeys("David");
		Allure.step("Entered first name ");
		driver.findElement(lastName).sendKeys("Gregory");
		Allure.step("Entered last name ");
		driver.findElement(companyName).sendKeys("David & G test company Limited");
		Allure.step("Entered company name ");
		
		Allure.step("Clicked on add address button");
		driver.findElement(cancelBtn).click();
		
		String actadrs = "Add a new address";
		String expAddrs= driver.findElement(adrsVer).getText();
		softAssert.assertEquals(actadrs, expAddrs, "Message Mismatch");
		Allure.step("Checking whether the 'add a new address form is closed");
		//as the user click 'cancel' the add address form close, so the assert fails
		softAssert.assertAll();
		
	}
	public void editAddress() throws Exception
	{
		Thread.sleep(4000);
		driver.findElement(edit).click();

		Allure.step("Clicked on edit button");
		Thread.sleep(2000);
		//scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("window.scrollBy(0,500)");
		
		driver.findElement(firstNameEdit).clear();
		driver.findElement(firstNameEdit).sendKeys("Daviz");
		Allure.step("Edited first name ");
		driver.findElement(lastNameEdit).clear();
		driver.findElement(lastNameEdit).sendKeys("Gregori");
		Allure.step("Edited last name ");
		driver.findElement(companyNameEdit).clear();
		driver.findElement(companyNameEdit).sendKeys("David & G company Limited");
		Allure.step("Edited company name ");
		
		driver.findElement(addressOneEdit).clear();
		driver.findElement(addressOneEdit).sendKeys("20 mariantia flats");
		Allure.step("Edited address one");
		driver.findElement(addressTwoEdit).clear();
		driver.findElement(addressTwoEdit).sendKeys("near church road");
		Allure.step("Edited address two ");
		driver.findElement(cityEdit).clear();
		driver.findElement(cityEdit).sendKeys("Manchester");
		Allure.step("Edited city ");
		
		selectCountryDrop2();
		Allure.step("Selected country from dropdown");
		
		driver.findElement(postalCodeEdit).clear();
		driver.findElement(postalCodeEdit).sendKeys("M23 83D6");
		Allure.step("Entered postal code ");
		
		driver.findElement(phoneEdit).clear();
		driver.findElement(phoneEdit).sendKeys("+44 122121212");
		Allure.step("Entered phone number");
		driver.findElement(updateBtn).click();
		Allure.step("Clicked on submit");
		
	}
	
	public void deleteAddress() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(deletebtn).click();
		Allure.step("Address is deleted");
		Thread.sleep(2000);
		//shopify popup to delete address
	    driver.switchTo().alert().dismiss();
	    Thread.sleep(2000);
	    driver.findElement(deletebtn).click();
	    Thread.sleep(2000);
	    driver.switchTo().alert().accept();
		
	}

}

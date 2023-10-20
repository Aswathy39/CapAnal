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
	By firstNameEdit = By.id("AddressFirstName_8351873990870");
	By lastName = By.id("AddressLastNameNew");
	By lastNameEdit = By.id("AddressLastName_8351873990870");
	By companyName = By.id("AddressCompanyNew");
	By companyNameEdit = By.id("AddressCompany_8351873990870");
	By addressOne = By.id("AddressAddress1New");
	By addressOneEdit = By.id("AddressAddress1_8351873990870");
	By addressTwo = By.id("AddressAddress2New");
	By addressTwoEdit = By.id("AddressAddress2_8351873990870");
	By city =By.id("AddressCityNew");
	By cityEdit=By.id("AddressCity_8351873990870");
	By adrsCountry = By.id("AddressCountryNew");
	By countryDropEdit = By.id("AddressCountry_8351873990870");
	By country =By.xpath("//option[. = 'United Kingdom']");
	By country2 = By.xpath("//*[@id=\"AddressCountry_8351873990870\"]/option[227]");
	By postalCode=By.id("AddressZipNew");
	By postalCodeEdit=By.id("AddressZip_8351873990870");
	By phone =By.id("AddressPhoneNew");
	By phoneEdit =By.id("AddressPhone_8351873990870");
	By submit = By.xpath("//*[@id=\"address_form_new\"]/div[12]/button[1]");
	By address =By.xpath("/html/body/main/div/div/div/button");
	By verifyAddrs = By.xpath("//li[2]/p");
	By cancelBtn = By.xpath("//*[@id=\"address_form_new\"]/div[12]/button[2]");
	By adrsVer =By.xpath("/html/body/main/div/div/div/div/h2");
	By edit = By.xpath("//*[@id=\"EditFormButton_8351873990870\"]");
	By updateBtn = By.xpath("//*[@id=\"address_form_8351873990870\"]/div[12]/button[1]");
	
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
		
//		String actadrs = "David Gregory\\nDavid & G test company Limited\\n20 mariantia flat\\nnear round road church\\nMnchester M23 54D6\\nUnited Kingdom";
//		String expAddrs= driver.findElement(verifyAddrs).getText();
//		softAssert.assertEquals(actadrs, expAddrs, "Message Mismatch");
//		softAssert.assertAll();
		
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
		softAssert.assertAll();
		
	}
	public void editAddress() throws Exception
	{
		Thread.sleep(4000);
		driver.findElement(edit).click();

		Allure.step("Clicked on edit button");
		Thread.sleep(2000);
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

}

package neoStox_PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import utility_All.UtilityCommonMethod;

public class NeoStox_LoginPage 
{	
	@FindBy(id = "MainContent_signinsignup_txt_mobilenumber") private WebElement mobNuberField;
	@FindBy(id = "lnk_signup1") private WebElement clickMe;
	
	public NeoStox_LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterMobileNumber(WebDriver driver, String mobNumber) 
	{
		UtilityCommonMethod.wait(driver, 1000);
		mobNuberField.sendKeys(mobNumber);
		Reporter.log("Entering mobile number...",true);
	}
	
	public void clickSignIn(WebDriver driver) 
	{
		UtilityCommonMethod.wait(driver, 1000);
		clickMe.click();
		Reporter.log("Clicking on sign in button...",true);
	}
}

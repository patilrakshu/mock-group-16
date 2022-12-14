package neoStox_PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import utility_All.UtilityCommonMethod;

public class NeoStox_PasswordPage 
{
	@FindBy(id = "txt_accesspin") private WebElement enterPassword;
	@FindBy(id = "lnk_submitaccesspin") private WebElement submitButton;
	
	public NeoStox_PasswordPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterPasscode(String pass, WebDriver driver) 
	{
		UtilityCommonMethod.wait(driver, 1000);
		enterPassword.sendKeys(pass);
		Reporter.log("Entering password number...",true);
	}
	
	public void clickSignIn(WebDriver driver) 
	{
		UtilityCommonMethod.wait(driver, 1000);
		submitButton.click();
		Reporter.log("Clicking on submit button...",true);
	}

}

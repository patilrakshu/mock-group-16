package neoStox_PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import utility_All.UtilityCommonMethod;

public class NeoStox_ClickSignInButton
{
	@FindBy(linkText = "Sign In") private WebElement clickSignInButton;
	
	public NeoStox_ClickSignInButton(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSignInButton(WebDriver driver) 
	{
		UtilityCommonMethod.wait(driver, 1000);
		Reporter.log("Clicking on sign in...", true);
		clickSignInButton.click();
	}

}

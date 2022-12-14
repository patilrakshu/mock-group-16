package neoStox_PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import utility_All.UtilityCommonMethod;


public class NeoStox_PopUpPage 
{
	@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement okButton;
	@FindBy(xpath = "(//a[text()='Close'])[5]") private WebElement closeButton;
	
	public NeoStox_PopUpPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
//	public void handlePopUp(WebDriver driver)
//	{
//		UtilityCommonMethod.wait(driver, 1000);
//		okButton.click();
//		Reporter.log("clicking on ok button...", true);
//		UtilityCommonMethod.wait(driver, 1000);
//		closeButton.click();
//		Reporter.log("clicking on close button...", true);
//	}
	
	//use for combo test Ng class where we declared validate userName as well accBalance
	public void handlePopUp(WebDriver driver)
	{
		if(okButton.isDisplayed())
		{
			UtilityCommonMethod.wait(driver, 1000);
			okButton.click();
			Reporter.log("clicking on ok button...", true);
			UtilityCommonMethod.wait(driver, 1000);
			closeButton.click();
			Reporter.log("clicking on close button...", true);
		}
		else
		{
			UtilityCommonMethod.wait(driver, 1000);
			Reporter.log("Pop-Up not display so just wait for few ms...", false);
		}
	
	}

}

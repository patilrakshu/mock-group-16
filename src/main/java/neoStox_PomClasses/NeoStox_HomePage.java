package neoStox_PomClasses;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import utility_All.UtilityCommonMethod;

public class NeoStox_HomePage 
{
	@FindBy(xpath = "//span[@id='lbl_username']") private WebElement userName;
	@FindBy(xpath = "//ul[contains(@class,'dropdown-menu dropdown')]//input") private WebElement darkTheme;	
	@FindBy(xpath = "//span[@id='lbl_curbalancetop']") private WebElement availablefunds;
	@FindBy (xpath = "//span[text()='Logout']") private WebElement logOutButton;
	
	public NeoStox_HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getUserName(WebDriver driver) throws IOException
	{
		UtilityCommonMethod.wait(driver, 1000);
		String actUserName = userName.getText();
		String actualUserName = actUserName.substring(3);
		UtilityCommonMethod.takeScreenShot(driver, actualUserName);
		Reporter.log("getting actual user name is "+actualUserName+"...", true);
		return actUserName;
	}
	
	public String getAvailableFunds(WebDriver driver) throws IOException 
	{
		UtilityCommonMethod.wait(driver, 1000);
		String accBalance = availablefunds.getText();
		Reporter.log("getting available account balance is "+accBalance+"...", true);
		return accBalance;
	}
	
	public void clickonDarkTheme() throws InterruptedException 
	{
		userName.click();
		Thread.sleep(1000);
		darkTheme.click();
	}
	
	public void clickOnLogOutButton(WebDriver driver) 
	{
		UtilityCommonMethod.wait(driver, 1000);
		userName.click();
		UtilityCommonMethod.wait(driver, 1000);
		logOutButton.click();
		Reporter.log("clicking on logout button...", true);
	}

}

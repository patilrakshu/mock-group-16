package neoStox_TestClass;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base_All.BaseNew;
import neoStox_PomClasses.NeoStox_ClickSignInButton;
import neoStox_PomClasses.NeoStox_HomePage;
import neoStox_PomClasses.NeoStox_LoginPage;
import neoStox_PomClasses.NeoStox_PasswordPage;
import neoStox_PomClasses.NeoStox_PopUpPage;
import utility_All.UtilityCommonMethod;


public class ValidateNeoStoxAccBalance extends BaseNew
{
  NeoStox_ClickSignInButton signIn;
  NeoStox_LoginPage logIn;
  NeoStox_PasswordPage pass;
  NeoStox_PopUpPage popUp;
  NeoStox_HomePage home;
  
  @BeforeClass
  public void neoStoxOpen() throws InterruptedException 
  {
	  launchBrowser();
	  signIn=new NeoStox_ClickSignInButton(driver);
	  logIn=new NeoStox_LoginPage(driver);
	  pass=new NeoStox_PasswordPage(driver);
	  popUp=new NeoStox_PopUpPage(driver);
	  home=new NeoStox_HomePage(driver);	  
  }
  @BeforeMethod
  public void neoStoxLogInDetails() throws EncryptedDocumentException, IOException, InterruptedException 
  {
	  signIn.clickOnSignInButton(driver);
	  logIn.enterMobileNumber(driver, UtilityCommonMethod.readDataFromPropertiesFile("mobNumber"));
	  logIn.clickSignIn(driver);
	  UtilityCommonMethod.wait(driver, 1000);
	  pass.enterPasscode(UtilityCommonMethod.readDataFromPropertiesFile("password"), driver);
	  Thread.sleep(1000);
	  pass.clickSignIn(driver);
	  Thread.sleep(1000);
	  popUp.handlePopUp(driver);
	  
  }
  @Test
  public void showAvailableFunds() throws IOException
  {
	  Assert.assertNotNull(home.getAvailableFunds(driver),"TC is failed unable fetch account balace...");
	  UtilityCommonMethod.takeScreenShot(driver, "accBalance");
	  Reporter.log("Validate available funds passed...", true);
  } 
  @AfterMethod
  public void logOutFromNeoStox()
  {
	  UtilityCommonMethod.wait(driver, 2000);
	  home.clickOnLogOutButton(driver);
	  Reporter.log("loging out from NeoStox...", true);
  }
  @AfterClass
  public void closeBrowser()
  {
	  driver.close();
	  Reporter.log("closing browser...", true);
  }
  
}

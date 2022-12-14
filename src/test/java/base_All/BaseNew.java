package base_All;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class BaseNew 
{
	protected static WebDriver driver;
	public void launchBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\selenium-java-4.4.0\\chromedriver.exe");
		driver=new ChromeDriver();
//		driver.manage().window().maximize();
		driver.get("https://neostox.com/");
		Reporter.log("launching browser successfully...",true);
		Thread.sleep(1000);
	}
}

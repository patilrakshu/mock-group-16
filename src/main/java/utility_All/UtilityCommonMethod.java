package utility_All;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class UtilityCommonMethod 
{
	
	//wait
	public static void wait(WebDriver driver, int waitTime) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
		Reporter.log("waiting for "+waitTime+"ms...",true);
	}

	//screenshots
	public static void takeScreenShot(WebDriver driver, String fileName) throws IOException
	{
		wait(driver, 1000);
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("D:\\selenium-java-4.4.0\\ScreenShot"+fileName+".png");
		FileHandler.copy(src, dest);
		Reporter.log("taking screenshot...",true);
	}
	
	//scrolling
	public static void scrolling(WebDriver driver, WebElement element) 
	{
		wait(driver, 1000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		Reporter.log("scrolling at "+element+"...",true);
	}
	
	public static String readDataFromPropertiesFile(String key) throws IOException
	{
		//step1. create object of properties file
		Properties prop=new Properties();
		
		//step2. create object of fileInputstream
		FileInputStream myFile=new FileInputStream("C:\\Users\\raksh\\eclipse-workspace\\JUBER_MAVEN\\NeoStox_Details.properties");
				
		//step3.load file into properties
		prop.load(myFile);
		
		//step4. get key and stored in reference variable
		String value = prop.getProperty(key);
		Reporter.log("reading "+key+" from property file", true);
		return value;				
	}
	
	//excel data reading
//	public static String excelDataRead(int row, int cell) throws EncryptedDocumentException, IOException
//	{
//		File f=new File("D:\selenium-java-4.4.0\MyExcel"\\mock group 16.xlsx");
//		String result = WorkbookFactory.create(f).getSheet("Neostox").getRow(row).getCell(cell).getStringCellValue();
//		Reporter.log("reading data from excel sheet...",true);
//		return result;
//	}
		

}

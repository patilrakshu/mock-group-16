package base_All;

import java.io.IOException;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import utility_All.UtilityCommonMethod;

public class Listner extends BaseNew implements ITestListener

{
	public void onTestFailure(ITestResult result)
	{
		Reporter.log("TC "+result.getName()+" is failed...", true);
		try 
		{
			UtilityCommonMethod.takeScreenShot(driver, result.getName());
		} 
		catch (IOException e) 
		{
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void onTestSuccess(ITestResult result)
	{
		Reporter.log("TC "+result.getName()+" is passed...", true);	
	}

	
	public void onTestSkipped(ITestResult result)
	{
		Reporter.log("TC "+result.getName()+" is skipped...", true);
	}

}

package retryUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImpClass implements IRetryAnalyzer{
    int count=0;
    int limitcount=5;
	@Override
	public boolean retry(ITestResult result) {
		if(count<=5) 
		{
			return true;
		}
		return false;
	}
	

}

package TestLayer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class failhelper implements IRetryAnalyzer {
	int counter = 0;
	int maximum=4;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(counter<maximum)
		{
			counter++;
			return true;
		}
		
		
		return false;
	}

}

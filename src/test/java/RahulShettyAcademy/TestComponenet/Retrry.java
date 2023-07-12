package RahulShettyAcademy.TestComponenet;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retrry implements IRetryAnalyzer {
	int min = 0;
	int max = 1;

	@Override
	public boolean retry(ITestResult result) {

         if(min<max) {
        	 min++;
        	 return true;
         }
		return false;
	}

}

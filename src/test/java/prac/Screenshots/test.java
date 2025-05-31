package prac.Screenshots;

import org.testng.ITestListener;
import org.testng.ITestResult;

class test implements ITestListener{

	  @Override
	  public void onTestFailure(ITestResult tr) {
	    System.out.println("On Test Failure");
	  }

	  @Override
	  public void onTestSkipped(ITestResult tr) {
		  System.out.println("On Test Skipped");
	  }

	  @Override
	  public void onTestSuccess(ITestResult tr) {
		  System.out.println("On Test Success");
	  }

	  
}
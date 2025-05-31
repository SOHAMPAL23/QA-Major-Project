package prac;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testng {

	
	//Before Suite Before Test 
	
	@BeforeClass
	   public void BeforeClass() {
		   System.out.println("Before class  run");
	   }
	   
	   @BeforeMethod
	   public void beforeMethod() {
		   System.out.println("Before Method run");
	   }
	   
	   @Test(enabled=true)
	   public void Test1 () {
		   System.out.println("Test1 run");
	   }
	   
	   @Test(expectedExceptions = ArithmeticException.class)
	   public void Test2 () {
		   System.out.println(1/0);
	   }
	   
	   @Test(timeOut = 5000)
	   public void Test3 () throws InterruptedException {
		   System.out.println("Test 3 run");
		   Thread.sleep(2000); // if it goes more then the expected then it will show  error
	   }
	   
	   @Test(invocationCount =4,dependsOnMethods = "Test1")
	   public void Test4 () {
		   System.out.println("Test 4 run");
	   }
	   
	   @Test(dependsOnMethods = "Test1")
	   public void Test5 () {
		   System.out.println("Test2 run");
	   }
	   
	   @Test(dependsOnMethods = "Test1")
	   public void Test6 () {
		   System.out.println("Test2 run");
	   }
	   
	   @DataProvider(name = "userData")
	   public Object[][] Test7 () {
		  
		return new Object[][] {
			{"Shivam","shiv@gmail.com"},{"Soham","Sohampal@gmail.com"},{"Som","som@gmail.com"}
		};
	   }
	   
	   @Test (dataProvider="userData")
	   public void Test8 (String name ,String email) {
		  System.out.print("Your name is " + name + "Your Email is "+ email);
		
	   }
	   
	   @AfterMethod
	   public void AfterMethod() {
		   System.out.println("After Method");
	   }
	   
	   @AfterClass
	   public void AfterClass() {
		   System.out.println("After class  run");
	   }
}

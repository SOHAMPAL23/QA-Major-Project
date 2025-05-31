package prac.CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CSV {

	 @Test(dataProvider = "csvDataProvider")
	 public void testMethod(String username, String password) {
	 System.out.println("Username: " + username + ", Password: " + password);
	 }
	 
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
	System.out.println("Before method ran.");
	}
	 @Test(groups = {"smoke"})
	 public void loginWithValidCredentials() {
	 System.out.println("Executing: loginWithValidCredentials");
	 }
	 @Test(groups = {"regression"})
	 public void loginWithInvalidCredentials() {
	 System.out.println("Executing: loginWithInvalidCredentials");
	 }
	 @Test(groups = {"sanity"})
	 public void registerNewUser() {
	 System.out.println("Executing: registerNewUser");
	 }
	 @Test(groups = {"smoke", "regression"})
	 public void loginSearchProduct() {
	 System.out.println("Executing: loginSearchProduct");
	 }
	 @Test(groups = {"regression", "sanity"})
	 public void logoutFilterProductByCategory() {
	 System.out.println("Executing: logOutFilterProductByCategory");
	 }
	 @Test(groups = {"smoke"})
	 public void loginAddToCart() {
	 System.out.println("Executing: loginAddToCart");
	 }
	 @Test(groups = {"sanity"})
	 public void loginApplyDiscountCoupon() {
	 System.out.println("Executing: loginApplyDiscountCoupon");
	 }
	 @Test(groups = {"smoke", "sanity"})
	 public void loginPlaceOrder() {
	 System.out.println("Executing: loginPlaceOrder");
	 }
	 @Test(groups = {"regression"})
	 public void viewOrderHistory() {
	 System.out.println("Executing: viewOrderHistory");
	 }
	 @Test(groups = {"sanity"})
	 public void loginLogoutUser() {
	 System.out.println("Executing: loginLogoutUser");
	 }
	
}

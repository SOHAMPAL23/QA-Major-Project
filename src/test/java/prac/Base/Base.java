package prac.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class Base {

	private Properties prop;

	public Base() {
		try {
            prop = new Properties();
            FileInputStream file = new FileInputStream("src/test/resources/config.properties"); 
            prop.load(file); 
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage()); 
        } catch (IOException e) {
            e.printStackTrace(); 
        }

	}
	
	@Test
	public void intialize() {
		String browsername = prop.getProperty("Browser");
		if(browsername == "chrome") {
			
		}
		else if (browsername =="firefox") {
			
		}
	}
}

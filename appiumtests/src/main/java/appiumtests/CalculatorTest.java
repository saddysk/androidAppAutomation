package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

//import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculatorTest {

//	static AppiumDriver<MobileElement> driver;
	static AndroidDriver<MobileElement> driver;
	
	public static void main(String[] args) {
		try {
			System.out.println("try block");
			openCalculator();
		} catch (Exception e) {
			System.out.println("catch block");
			System.out.println(e.getCause());
			System.out.println("MESSAGE: " + e.getMessage());
//			e.printStackTrace();
		}
	}

	public static void openCalculator() throws Exception {		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", "[device name here eg. oppof1]");
		cap.setCapability("udid", "[device id here]");
		cap.setCapability("platformName", "[Android/ ios/ ...]");
		cap.setCapability("platformVersion", "[eg. Android 10]");
		
		cap.setCapability("appPackage", "[com.example.calculator]");
		cap.setCapability("appActivity", "[com.example.calculator.MainActivity]");

		
		URL url = new URL("[location of appium server. Eg.- http://localhost:4723/wd/hub]");
		
		System.out.println("Setting up the driver...");
		
//		driver = new AppiumDriver<MobileElement>(url, cap);
		driver = new AndroidDriver<MobileElement>(url, cap);
		
		System.out.println("Application started.");	
		
		MobileElement two = driver.findElement(By.id("com.example.calculator:id/btn2"));
		MobileElement nine = driver.findElement(By.id("com.example.calculator:id/btn9"));
		MobileElement equal = driver.findElement(By.id("com.example.calculator:id/btnequal"));
		MobileElement multiply = driver.findElement(By.id("com.example.calculator:id/btnmultiply"));
		
		MobileElement textresult = driver.findElement(By.id("com.example.calculator:id/textresult"));
		
		two.click();
		multiply.click();
		nine.click();
		equal.click();
		
		String result = textresult.getText();
		
		System.out.println("\nResult: " + result);
	}
}

package appiumtests;

//import java.net.MalformedURLException;
import java.net.URL;

//import org.apache.commons.validator.EmailValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

//import java.util.concurrent.TimeUnit;

public class Login {
//	initializing the the driver
	static AndroidDriver<MobileElement> driver;
	static String emails[] = {"rakto@rk.com", "crampie@gmail.org", "sdbv@lkesg.com", "dkvdh@sdkvg.as", "crispy@yahoo.in", "saddam@sksaddam.com", "bakwas@mail.in"};
	static String passwords[] = {"675r67#$65", "f54d5w23dW@", "gfh^Y477g4w", "asfojinuu4@$#4RN", "ABF524$43", "myPassword->abc123", "all%$$done"};
	
//	driver function
	public static void main(String[] args) {
//		starting the working function
		try {
			System.out.println("try block");
			openLoginApp();
		} catch (Exception e) {
			System.out.println("catch block");
			System.out.println(e.getCause());
			System.out.println("MESSAGE: " + e.getMessage());
		}		
	}
	
//	functional method
	public static void openLoginApp() throws Exception {
		
		DesiredCapabilities cap = new DesiredCapabilities();
//		set desired capabilities to interact with the application
		cap.setCapability("deviceName", "[device name here eg. oppof1]");
		cap.setCapability("udid", "[device id here]");
		cap.setCapability("platformName", "[Android/ ios/ ...]");
		cap.setCapability("platformVersion", "[eg. Android 10]");
		
		// remove [] before running the file

		cap.setCapability("appPackage", "com.example.login");
		cap.setCapability("appActivity", "com.example.login.MainActivity");

//		setting url of the appium server
		URL url = new URL("[location of appium server. Eg.- http://localhost:4723/wd/hub]");
		System.out.println("Setting up the driver...");
		driver = new AndroidDriver<MobileElement>(url, cap);
		System.out.println("Application started.");
		
//		getting the elements to invoke actions
		MobileElement emaiId = driver.findElement(By.id("com.example.login:id/editTextTextEmailAddress"));
		MobileElement password = driver.findElement(By.id("com.example.login:id/editTextTextPassword"));
		MobileElement loginBtn = driver.findElement(By.id("com.example.login:id/button"));
		MobileElement status = driver.findElement(By.id("com.example.login:id/textView"));
		
		String output;
		for (int i = 0; i < emails.length; i++) {
			emaiId.setValue(emails[i]);
			password.setValue(passwords[i]);
			loginBtn.click();
//			if there is a lag while fetching the data (especially when fetched from the server)
//			TimeUnit.SECONDS.sleep(1);
			output = status.getText();
			

			if (output.equals("Login successful")) {
				System.out.println("\nFound the credentials");
				System.out.println("----------------------");
				System.out.println("Email: " + emails[i]);
				System.out.println("Password.: " + passwords[i]);
				break;
			}
			else
				System.out.println("\nCredential " + (i+1) + " didn't match.\nChecking further from the list...");
		}
		
	}

}

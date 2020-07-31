package sauceLabs;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabTest {

	public static final String USERNAME = "aishagonen"; 
	public static final String ACCESS_KEY = "661e2e25-9826-4603-9406-7f167b9345d4";
	public static final String URL = "https://"+ USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	public static String browserName = "Firefox";
	
	public static void main(String[] args) throws MalformedURLException {
			
		//Use Options function to change browser following:
		
				FirefoxOptions cap = new FirefoxOptions();
				
		        //ChromeOptions cap = new ChromeOptions(); 
				
				//SafariOptions cap = SafariOptions();
				
				//Dont change this part :
		         cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
		        		 			UnexpectedAlertBehaviour.IGNORE);
		         
		         //Create desired capabilities :
		         DesiredCapabilities caps = new DesiredCapabilities();
		         caps.setCapability("name", "Google verification");
		         caps.setCapability("browserName", "Firefox");
		         caps.setCapability("browserVersion", "70");
		         caps.setCapability("platformName", "Windows 10");
		         caps.setCapability("version", "53.0");

		WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), cap);
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Selenium Automation");
		
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		System.out.println(driver.getTitle());
		
		driver.quit();
		System.out.println("Test is completed... ");
		
		
		
	}

}

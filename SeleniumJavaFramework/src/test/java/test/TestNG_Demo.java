package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;
import demo.Log4jDemo;

public class TestNG_Demo {
	WebDriver driver = null;
	public static String browserName = null;
	private static Logger logger = LogManager.getLogger(Log4jDemo.class);
	String projectPath = System.getProperty("user.dir");

	
	@BeforeTest
	public void setUpTest() {
		PropertiesFile.getProperties();
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath+"\\Driver\\Chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",projectPath+"\\Driver\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		//set property for chrome drive
		
		logger.info("Browser started");

	}
	 @Test
	public void googleSearch() {
		//goto google search
		driver.get("https://google.com/");

		//enter the text in search box
		driver.findElement(By.name("q")).sendKeys("Automation step by step");

		//click on search button
		//driver.findElement(By.name("btnK")).click();
		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);


	}
	 
	 @AfterTest
	public void tearDownTest() {
		//close browser
		driver.close();

		//print message on the console
		System.out.println("Completed successfully");
		PropertiesFile.setProperties();

	}

}

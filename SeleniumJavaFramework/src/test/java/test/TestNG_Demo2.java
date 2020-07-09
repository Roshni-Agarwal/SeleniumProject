package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Demo2 {
	WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest() {
		//set property for chrome drive
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Driver\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();

	}
	 @Test
	public void googleSearch() {
		//goto google search
		driver.get("https://google.com/");

		//enter the text in search box
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Automation step by step");

		//click on search button
		//driver.findElement(By.name("btnk")).click();
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);


	}
	 
	 @Test
		public void googleSearch2() {
			//goto google search
			driver.get("https://google.com/");

			//enter the text in search box
			driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Automation step by step");

			//click on search button
			//driver.findElement(By.name("btnk")).click();
			driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);


		}
	 
	 @AfterTest
	public void tearDownTest() {
		//close browser
		driver.close();

		//print message on the console
		System.out.println("Completed successfully");

	}

}

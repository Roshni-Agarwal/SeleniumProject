package demo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoIDDemo {
	
	public static void main(String[] args) throws Exception {
		test1();
	}
	public static void test1() throws Exception {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Driver\\Chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.tinyupload.com/");
		//driver.findElement(By.name("uploaded_file")).click();
		//driver.findElement(By.name("uploaded_file")).sendKeys(Keys.RETURN);;
		//Runtime.getRuntime().exec("E:\\Cafe\\agreement\\DXC\\A ONE COFFEE DXC AGREEMENT\\FileUploadScript.exe");
		
		Thread.sleep(3000);
		driver.close();
	}

}

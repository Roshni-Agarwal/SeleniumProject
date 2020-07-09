package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtendReportsBasicDemo {

	private static WebDriver driver = null;

	public static void main(String[] args) {

		ExtentHtmlReporter htmlRepoter = new ExtentHtmlReporter("extendReports.html");
		//ExtentHtmlReporter htmlRepoter = new ExtentHtmlReporter("extendReports.html");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlRepoter);

		ExtentTest test1 = extent.createTest("Google search Test One", "this is a test to validate google search functionality");


		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Driver\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();

		test1.log(Status.INFO, "Starting Test Case");
		driver.get("https://google.com/");
		test1.pass("Navigated to google.com");

		driver.findElement(By.name("q")).sendKeys("Automation step by step");
		test1.pass("Entered text in searchbox");

		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test1.pass("pressed keyboard enter key");

		driver.close();
		driver.quit();
		test1.pass("Closed the browser");

		test1.info("Test Completed");

		//test2 cases
		ExtentTest test2 = extent.createTest("Google search Test Two", "this is a test to validate google search functionality");


		System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Driver\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();

		test2.log(Status.INFO, "Starting Test Case");
		driver.get("https://google.com/");
		test2.pass("Navigated to google.com");

		driver.findElement(By.name("q")).sendKeys("Automation step by step");
		test2.pass("Entered text in searchbox");

		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test2.fail("pressed keyboard enter key");

		driver.close();
		driver.quit();
		test2.pass("Closed the browser");

		test2.info("Test Completed");


		//calling flush to writes everything in the log file
		extent.flush();

	}

}

package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class ExcelDataProvider {

	static WebDriver driver = null;

	@BeforeTest
	public void setUpTest() {
		String projectPath = System.getProperty("user.dir");
		PropertiesFile.getProperties();
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Driver\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();


	}


	//public static void main(String[] args) {
	//String excelPath = "C:\\Users\\ad\\eclipse-workspace\\SeleniumJavaFramework\\excel\\data.xlsx";
	//testData(excelPath, "Sheet1");
	//}
	@Test(dataProvider = "testData1")
	public void test1(String Username, String Password) throws Exception {

		System.out.println(Username+" | "+Password);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(Username);
		driver.findElement(By.id("pass")).sendKeys(Password);
		driver.findElement(By.name("LogIn")).sendKeys(Keys.RETURN);
		Thread.sleep(3000);
	}

	@DataProvider(name = "testData1")
	public Object[][] getData() {
		String excelPath = "C:\\Users\\ad\\eclipse-workspace\\SeleniumJavaFramework\\excel\\data.xlsx";
		Object data[][] = testData(excelPath, "Sheet1");
		return data;
	}
	public static Object[][] testData(String excelPath, String sheetName) {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount();
		int colcount = excel.getCOLCount();

		Object data[][] = new Object[rowCount-1][colcount];

		for(int i=1;i<rowCount;i++) {
			for(int j=0;j<colcount;j++) {
				String cellData = excel.getCellDataString(i, j);
				//System.out.print(cellData+" | ");
				data[i-1][j] = cellData;
			}
			//System.out.println();
		}
		return data;
	}

}

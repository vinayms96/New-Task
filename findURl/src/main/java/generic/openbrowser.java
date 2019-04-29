package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentAventReporter;

public class openbrowser implements auto_constant {

	public static WebDriver driver = null;
	public ExtentAventReporter htmlReporter;
	public ExtentReports reports;
	public ExtentTest test;
	
	@BeforeSuite
	public void extentOpen() {
		htmlReporter = new ExtentAventReporter(extentSave);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		test = reports.createTest("getUrl","Getting all Errors");
	}
	
	@BeforeTest
	public void open() {
		
//		WebDriverManager.chromedriver().setup();
		System.setProperty(chromeKey, chromeValue);
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless");
		driver = new ChromeDriver(co);
		test.info("Chrome Browser is Launched");
		driver.manage().window().maximize();
		test.info("Test URL entered...");
		driver.get(url);
		
	}
	
	@AfterTest
	public void close() {
		driver.quit();
		test.info("Chrome browser closed");
	}
	
	@AfterSuite
	public void extentClose() {
		reports.flush();
	}
	
}

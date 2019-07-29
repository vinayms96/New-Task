package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentAventReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class openBrowser implements auto_constant {
	public static WebDriver driver;
	public ExtentReports extent;
	public ExtentAventReporter avent;

	@BeforeSuite
	public void open() {
		
		// Extent reports
		avent = new ExtentAventReporter(".\\src\\test\\resources\\Report");
		extent = new ExtentReports();
		extent.attachReporter(avent);
		
		ExtentTest browse = extent.createTest("Choosing Browser");
		
		// Choose Browser
		if (property.getData("browser").equals("CH")) {
			WebDriverManager.chromedriver().setup();
			if (property.getData("head") == "On") {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
				browse.pass("Headless Chrome Browser Launched");
			} else {
				driver = new ChromeDriver();
				browse.pass("Chrome Browser Launched");
			}
		} else if (property.getData("browser").equals("FF")) {
			WebDriverManager.firefoxdriver().setup();
			if (property.getData("head") == "On") {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				driver = new FirefoxDriver(options);
				browse.pass("Headless Firefox Browser Launched");
			} else {
				driver = new FirefoxDriver();
				browse.pass("Firefox Browser Launched");
			}
		}
		driver.manage().window().maximize();
		driver.get(url);
		browse.pass("Website url "+url+" launched");
	}

	@AfterSuite
	public void close() {
		extent.flush();
//		driver.quit();
	}

}

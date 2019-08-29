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
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class openBrowser implements auto_constant {
	public static WebDriver driver;
	public static ExtentReports extent;
	static ExtentHtmlReporter html;
	static ExtentTest browse;

	@BeforeSuite
	public void open() {
		
		// Extent reports
		html = new ExtentHtmlReporter("./src/test/resources/Report/"+property.getData("reportName"));
		extent = new ExtentReports();
		extent.attachReporter(html);
		
		browse = extent.createTest("Choosing Browser");
		
		// Choose Browser
		if (property.getData("browser").equals("CH")) {
			WebDriverManager.chromedriver().setup();
			if (property.getData("head").equals("On")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
				browse.info("Headless Chrome Browser Launched");
			} else {
				driver = new ChromeDriver();
				browse.info("Chrome Browser Launched");
			}
		} else if (property.getData("browser").equals("FF")) {
			WebDriverManager.firefoxdriver().setup();
			if (property.getData("head").equals("On")) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				driver = new FirefoxDriver(options);
				browse.info("Headless Firefox Browser Launched");
			} else {
				driver = new FirefoxDriver();
				browse.info("Firefox Browser Launched");
			}
		}
		driver.manage().window().maximize();
		driver.get(url);
		browse.info("Website url "+url+" launched");
	}

	@AfterSuite
	public void close() {
		extent.flush();
		driver.quit();
	}

}

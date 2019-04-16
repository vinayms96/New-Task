package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class openbrowser implements auto_constant{
	public WebDriver driver;
	
	@BeforeTest
	public void open() {
		System.setProperty(chromekey, chromevalue);
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless");
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}
}

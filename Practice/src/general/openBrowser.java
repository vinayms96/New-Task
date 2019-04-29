package general;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class openBrowser implements auto_constant{
	public WebDriver driver = null;
	
	@BeforeTest
	public void open() {
		System.setProperty(chromeKey, chromeValue);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	@AfterTest
	public void close() {
		driver.quit();
	}
}

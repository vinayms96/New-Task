//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class open implements auto_constant {
//		public static WebDriver driver = null;
//
//		@SuppressWarnings("unused")
//		@BeforeSuite
//		public void openBr() {
//				if (property.getData("browser").equals("CH")) {
//						WebDriverManager.chromedriver().setup();
//						ChromeOptions co = new ChromeOptions();
//						if (head == "--headless") {
//								co.addArguments(head);
//								System.out.println("Headless Chrome Browser Launched");
//						} else if (head == "OFF") {
//								driver = new ChromeDriver();
//								System.out.println("Chrome Browser Launched");
//						}
//				} else if (property.getData("browser").equals("FF")) {
//						WebDriverManager.firefoxdriver().setup();
//						driver = new FirefoxDriver();
//				}
//				driver.manage().window().maximize();
//				driver.get(url);
//				System.out.println("Website Launched\n");
//		}
//		
//		@SuppressWarnings("unused")
//		@AfterSuite
//		public void close() {
//				driver.quit();
//				if (property.getData("browser").equals("CH")) {
//						System.out.println("Chrome Browser Closed");
//				} else if (property.getData("browser").equals("FF")) {
//						System.out.println("Firefox Browser Closed");
//				}
//		}
//}

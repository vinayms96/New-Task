package generic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class action extends openBrowser{
//	private static Actions a;
//	
//	private action(WebDriver driver) {
//		a = new Actions(driver);
//	}

	public static void actMove(WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform();
	}
	
	public static void actClick(WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).click().perform();
	}
	
}

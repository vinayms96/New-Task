package generic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class action extends openBrowser{

	static Actions a = new Actions(driver);
	static JavascriptExecutor js;
	
	public static void actClick(WebElement ele) {
		a.moveToElement(ele).click().perform();
	}
	
	public static void actMove(WebElement ele) {
		a.moveToElement(ele).perform();
	}
	
	public static void actEnter() {
		   a.sendKeys(Keys.ENTER).build().perform();
	}
	
	public static void actjsClick(WebElement ele) {
		js.executeScript("arguments[0].click();",ele);
	}
}

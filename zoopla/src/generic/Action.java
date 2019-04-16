package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action {
	static Actions a;
	public static void actMove(WebDriver driver,WebElement ele) {
		a = new Actions(driver);
		a.moveToElement(ele).perform();
	}
	
	public static void actClick(WebDriver driver,WebElement ele) {
		a.moveToElement(ele).click().perform();
	}

}

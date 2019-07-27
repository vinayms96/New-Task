package generic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class wait extends openBrowser {
	static WebDriverWait w = new WebDriverWait(driver, 10);

	public static void waitVisible(WebElement ele) {
		w.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void waitClick(WebElement ele) {
		w.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public static void waitRefresh(WebElement ele) {
		w.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(ele)));
	}
}

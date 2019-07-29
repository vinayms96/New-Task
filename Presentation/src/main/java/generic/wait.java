package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
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
	
	@SuppressWarnings("deprecation")
	public static void fluentWait() {
		Wait wait = new FluentWait<WebDriver>(driver)
				.withTimeout(45, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
	}
}

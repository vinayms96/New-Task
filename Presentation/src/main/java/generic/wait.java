package generic;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
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
//	@SuppressWarnings("deprecation")
//	public static void fluentWait(WebDriver driver) {
		// Waiting 30 seconds for an element to be present on the page, checking
		   // for its presence once every 5 seconds.
		   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		       .withTimeout(30, TimeUnit.SECONDS)
		       .pollingEvery(5, TimeUnit.SECONDS)
		       .ignoring(NoSuchElementException.class);

		   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
		     @Override
			public WebElement apply(WebDriver driver) {
		       return driver.findElement(By.id("foo"));
		     }
		   });
//	}
}

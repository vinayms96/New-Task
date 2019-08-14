package pageModels;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import generic.action;
import generic.openBrowser;

public class listing_pg {
	JavascriptExecutor js;
	ExtentTest listing = openBrowser.extent.createTest("Listing Page");

	@FindAll(@FindBy(xpath = "//div[@class='search results']/div[2]/ol/li"))
	private List<WebElement> prodClick;

	public listing_pg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//	public void fromList(WebDriver driver) {
////		generic.wait.waitRefresh(hoverProd);
//		action.actMove(hoverProd);
//		Random r = new Random();
//		for (int loop = 0; loop < choose1.size(); loop++) {
//			List<WebElement> choose2 = driver.findElements(By.xpath("//div[@class='search results']/div[2]/ol/li[1]/div/div/div[3]/div["+loop+"]/div/div"));
//			System.out.println(choose2.size());
//			System.out.println(choose2.toString());
//			action.actClick(driver.findElement(By.xpath("//div[@class='search results']/div[2]/ol/li[1]/div/div/div[3]/div["+loop+"]/div/div["+r.nextInt(choose2.size())+"]")));
//		}
//	}

	public void goProd(WebDriver driver) {
		js = (JavascriptExecutor)driver;
		Random r = new Random();
		int choose = r.nextInt(prodClick.size());
		if(choose == 0){
			js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//div[@class='search results']/div[2]/ol/li[1]/div/a")));
			listing.pass("A Product link is clicked from Listing Page");
			action.actClick(driver.findElement(By.xpath("//div[@class='search results']/div[2]/ol/li[1]/div/a")));
		}else {
			js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//div[@class='search results']/div[2]/ol/li["+choose+"]/div/a")));
			listing.pass("A Product link is clicked from Listing Page");
			action.actClick(driver.findElement(By.xpath("//div[@class='search results']/div[2]/ol/li["+choose+"]/div/a")));
		}
	}

//	public void cartClick() {
//		action.actClick(cart);
//	}
}

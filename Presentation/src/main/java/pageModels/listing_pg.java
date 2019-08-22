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
	
	//Fail Case elements
	@FindBy(xpath = "//h1[@class='page-title']/span")
	private WebElement searchHead;

	public listing_pg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

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

	public void headSearched() {
		if(searchHead.getText().contains("Dress")) {
			listing.fail("Search Text is displayed");
		}else {
			listing.fail("Search text is NOT displayed");
		}
	}
}

package pageModels;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.action;

public class listing_pg {

//	@FindBy(xpath = "//div[@class='search results']/div[2]/ol/li[1]")
//	private WebElement hoverProd;
//	@FindBy(xpath = "//div[@class='search results']/div[2]/ol/li[1]/div/div/div[3]/div")
//	private List<WebElement> choose1;
//	@FindBy(xpath = "//div[@class='swatch-opt-436']/..//form/button")
//	private WebElement cart;
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
		Random r = new Random();
		int choose = r.nextInt(prodClick.size());
		if(choose == 0){
			action.actClick(driver.findElement(By.xpath("//div[@class='search results']/div[2]/ol/li[1]/div/a")));
		}else {
			action.actClick(driver.findElement(By.xpath("//div[@class='search results']/div[2]/ol/li["+choose+"]/div/a")));
		}
	}

//	public void cartClick() {
//		action.actClick(cart);
//	}
}

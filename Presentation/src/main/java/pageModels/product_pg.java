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

public class product_pg {

	@FindAll(@FindBy(xpath = "//div[@class='product-add-form']/form/..//div[@class='swatch-opt']/div/div"))
	private List<WebElement> swatches;
	@FindBy(xpath = "//button[@title='Add to Cart']")
	private WebElement cartButton;

	public product_pg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void swatches(WebDriver driver) {
		System.out.println(swatches.size());
		Random r = new Random();
		for (int loop = 0; loop < swatches.size(); loop++) {
			List<WebElement> choose = driver.findElements(By.xpath(
					"//div[@class='product-add-form']/form/..//div[@class='swatch-opt']/div[" + loop + "]/div/div"));
			System.out.println(choose);
			int rand = r.nextInt(choose.size());
			if (rand <= 0) {
				action.actClick(driver
						.findElement(By.xpath("//div[@class='product-add-form']/form/..//div[@class='swatch-opt']/div["
								+ loop + "]/div/div[1]")));
			}else {
				action.actClick(driver
						.findElement(By.xpath("//div[@class='product-add-form']/form/..//div[@class='swatch-opt']/div["
								+ loop + "]/div/div[" + rand + "]")));
			}
		}
	}
	
	public void addCart() {
		action.actClick(cartButton);
	}
}

package pageModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.action;
import generic.openBrowser;

public class home_pg extends openBrowser{

	@FindBy(xpath = "//nav[@class='navigation']/ul/li[3]/a")
	private WebElement mainCategory;
	@FindBy(xpath = "//nav[@class='navigation']/ul/li[3]/ul/li[1]/a")
	private WebElement subCat1;
	@FindBy(xpath = "//nav[@class='navigation']/ul/li[3]/ul/li[1]/ul/li[1]/a")
	private WebElement subCat2;

	public home_pg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void mainCat() throws InterruptedException {
		action.actMove(mainCategory);
		Thread.sleep(3000);
//		action.actClick(mainCategory);
	}
	public void subCategory1() throws InterruptedException {
		action.actMove(subCat1);
		Thread.sleep(3000);
	}
	public void subcategory2() throws InterruptedException {
		action.actClick(subCat2);
		Thread.sleep(3000);
	}
}

package pageModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.action;

public class account_pg {

	@FindBy(xpath = "//div[@class='content block-collapsible-nav-content']/ul/li[2]/a")
	private WebElement order;
	
	public account_pg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void orderLink() {
		action.actClick(order);
	}
	
}

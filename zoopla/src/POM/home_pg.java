package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.openbrowser;

public class home_pg extends openbrowser {

	@FindBy(xpath="//input[@id=\"search-input-location\"]")
	private WebElement search;
	
	@FindBy(xpath="//button[@id=\"search-submit\"]")
	private WebElement sub;
	
	public home_pg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void searchbox(String value) {
		search.sendKeys(value);
	}
	
	public void submit() {
		sub.click();
	}
	
}

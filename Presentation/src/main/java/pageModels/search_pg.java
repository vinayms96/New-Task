package pageModels;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.action;
import generic.property;

public class search_pg {

	@FindBy(xpath = "//input[@id='search']")
	private WebElement searchBox;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchButton;
	
	
	public search_pg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void search(WebDriver driver) {
		searchBox.sendKeys(property.getData("keyWord"));
		action.actEnter();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
}

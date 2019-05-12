package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.action;

public class home_page {

	@SuppressWarnings("unused")
	private int count=0;

	@FindBy(xpath = "//button[text()=\"✕\"]")
	private WebElement close;

	@FindBy(xpath = "//a[text()=\"Login & Signup\"]")
	private WebElement logPop;

	@FindBy(xpath = "//input[@class=\"_2zrpKA\"]")
	private WebElement user;

	@FindBy(xpath = "//span[text()=\"CONTINUE\"]")
	private WebElement next;

	@FindBy(xpath = "//input[@type=\"password\"]")
	private WebElement pass;

	@FindBy(xpath = "//div[@class=\"_1avdGP\"]/button[2]")
	private WebElement logPush;

	public home_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public int popClose() {
		if (close.isDisplayed()) {
			count++;
		} else {
			System.out.println("Login Popup not Displayed");
		}
		return count;
	}

	public void openPop() {
		if (logPop.isDisplayed()) {
			logPop.click();
		}
	}

	public void userName(String name) {

		if (user.isDisplayed()) {
			user.sendKeys(name);
		}
	}

	public void passWord(String pwd) {
		pass.sendKeys(pwd);
	}

//	public void cont() {
//		next.click();
//	}

	public void logPrompt() {
		action.actClick(logPush);
	}

}

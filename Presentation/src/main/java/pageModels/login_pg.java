package pageModels;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.property;

public class login_pg {
	JavascriptExecutor js;

	@FindBy(xpath = "//button[@class='action action-auth-toggle']/span")
	private WebElement signIn;
	@FindBy(xpath = "//input[@id='login-email']")
	private WebElement email;
	@FindBy(xpath = "//input[@id='login-password']")
	private WebElement pass;
	@FindBy(xpath = "//button[@class='action action-login secondary']/span")
	private WebElement signButton;
	
	public login_pg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickSign(WebDriver driver) throws Exception {
		Thread.sleep(5000);
//		action.actClick(signIn);
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", signIn);
	}
	public void mail() throws Exception {
		Thread.sleep(2000);
		email.sendKeys(property.getData("1"));
	}
	public void password() throws Exception {
		Thread.sleep(2000);
		pass.sendKeys(property.getData("pass"));
	}
	public void buttonSign(WebDriver driver) {
//		action.actClick(signButton);
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", signButton);
	}
	
}

package pageModels;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import generic.openBrowser;
import generic.property;

public class login_pg {
	ExtentTest login = openBrowser.extent.createTest("Login Page");
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
		if(driver.findElement(By.xpath("(//div[@class=\"modal-inner-wrap\"])[1]")).isDisplayed()) {
			login.pass("Signin popup Displayed");
		}else {
			login.fail("Signin popup is NOT Displayed");
		}
	}
	public void mail() throws Exception {
		Thread.sleep(2000);
		email.sendKeys(property.getData("1"));
		login.info("Email id is entered");
	}
	public void password() throws Exception {
		Thread.sleep(2000);
		pass.sendKeys(property.getData("pass"));
		login.info("Password is Entered");
	}
	public void buttonSign(WebDriver driver) {
//		action.actClick(signButton);
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", signButton);
		login.info("Signin button clicked");
	}
	
}

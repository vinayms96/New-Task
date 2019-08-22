package pageModels;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import generic.action;
import generic.auto_constant;
import generic.openBrowser;

public class checkout_pg implements auto_constant {
	ExtentTest checkout = openBrowser.extent.createTest("Checkout Page");
	JavascriptExecutor js;
	static String orderID;

	@FindBy(xpath = "//div[@class='control _with-tooltip']//input[@id='customer-email']")
	private WebElement _1;
	@FindBy(xpath = "//div[@class='control']/input[@name='firstname']")
	private WebElement _2;
	@FindBy(xpath = "//div[@class='control']/input[@name='lastname']")
	private WebElement _3;
	@FindBy(xpath = "//div[@class='control']/input[@name='street[0]']")
	private WebElement _4;
	@FindBy(xpath = "//div[@class='control']/input[@name='city']")
	private WebElement _5;
	@FindBy(xpath = "//select[@name='region_id']")
	private WebElement _6;
	@FindBy(xpath = "//div[@class='contelerol']/input[@name='postcode']")
	private WebElement _7;
	@FindBy(xpath = "(//select[@class='select'])[1]")
	private WebElement _8;
	@FindBy(xpath = "//div[@class='control _with-tooltip']/input[@name='telephone']")
	private WebElement _9;
	@FindBy(xpath = "//span[contains(text(),'Cash On Delivery')]")
	private WebElement codRadio;
//	@FindBy(xpath = "//button[@class='button action continue primary']")
//	private WebElement next;
	@FindBy(xpath = "//tbody/tr/td/input[@value='flatrate_flatrate']")
	private WebElement shipMethod;
	@FindBy(xpath = "//button[@data-role='opc-continue']/span")
	private WebElement next;
//	@FindBy(xpath = "//div[@class='checkout-billing-address']/div/input[@id='billing-address-same-as-shipping-checkmo']")
//	private WebElement bankTransfer;
	@FindBy(xpath = "(//button[@class='action primary checkout']/span)[1]")
	private WebElement placeOrder;
	@FindBy(xpath = "//h1[@class='page-title']/span")
	private WebElement thank;
	@FindBy(xpath = "//div[@class='checkout-success']/p/a/strong")
	private WebElement orderId;
	@FindBy(xpath = "//span[@class='customer-name']/button")
	private WebElement user;
	@FindBy(xpath = "(//div[@class='customer-menu']/ul/li)[1]/a")
	private WebElement account;

	public checkout_pg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void shipping(WebDriver driver) throws Exception {
		Thread.sleep(3000);
		js = (JavascriptExecutor) driver;
		Point p = next.getLocation();
		Thread.sleep(7000);
			action.actClick(next, p);
			js.executeScript("arguments[0].scrollIntoView(true);", next);
			js.executeScript("arguments[0].click();", next);
			checkout.info("Next button is clicked");
	}

	public void bank(WebDriver driver) throws Exception {
		Thread.sleep(5000);
		js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", placeOrder);
			js.executeScript("arguments[0].click();", placeOrder);
			checkout.info("PlaceOrder button is Clicked");
	}

	public void confirmationPage() {
		String orderID = orderId.getText();
		checkout_pg.orderID = orderID;
		if (orderId.isDisplayed()) {
			System.out.println("Order Confirmation page is displayed");
			checkout.pass("Order Confirmation page is displayed");
		} else {
			System.out.println("Order Confirmation page is NOT displayed");
			checkout.fail("Order Confirmation page is NOT displayed");
		}
		action.actClick(orderId);
		checkout.info("Order Id link is clicked");
	}
}

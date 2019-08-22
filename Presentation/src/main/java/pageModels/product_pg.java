package pageModels;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import generic.action;
import generic.openBrowser;

public class product_pg {
	ExtentTest product = openBrowser.extent.createTest("Product Page");
	static String Size;
	static String Color;
	static Integer Qty;
	static WebElement getOp1;
	static WebElement getOp2;
	static String productName;
	JavascriptExecutor js;

	@FindAll(@FindBy(xpath = "//div[@class='product-add-form']/form/..//div[@class='swatch-opt']/div/div"))
	private List<WebElement> swatches;
	@FindBy(xpath = "//button[@title='Add to Cart']")
	private WebElement cartButton;
	@FindAll(@FindBy(xpath = "//div[@class='swatch-attribute-options clearfix']/div[@class='swatch-option color']"))
	private List<WebElement> swatch1;
	@FindAll(@FindBy(xpath = "//div[@class='swatch-attribute-options clearfix']/div[@class='swatch-option text']"))
	private List<WebElement> swatch2;
	@FindBy(xpath = "//input[@id='qty']")
	private WebElement newQty;
	@FindBy(xpath = "//div[@class='messages']/div/div")
	private WebElement messages;
	@FindBy(xpath = "//div[@class='product-options-bottom']/.//div[@class='field qty']/div/input")
	private WebElement prodQty;
	@FindBy(xpath = "//div[@class='page-title-wrapper product']/h1/span")
	private WebElement prodName;
	
	//Fail case Elements
	@FindBy(xpath = "//span[contains(text(),'In stock')]")
	private WebElement stock;

	public product_pg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void swatches(WebDriver driver) throws Exception {
		js = (JavascriptExecutor)driver;
		Thread.sleep(2000);
		Random r = new Random();
		
		String productName = prodName.getText();
		product_pg.productName = productName;
		
		//Selecting first Swatch
		WebElement getOp1 = swatch1.get(r.nextInt(swatch1.size()));
		js.executeScript("arguments[0].scrollIntoView(true)", getOp1);
		product_pg.getOp1 = getOp1;
		String Size = getOp1.getAttribute("aria-label").toString();
		product_pg.Size = Size;
		action.actClick(getOp1);
		product.info("Size '"+Size+"' is selected");
		
		//Selecting Second swatch
		Thread.sleep(2000);
		WebElement getOp2 = swatch2.get(r.nextInt(swatch2.size()));
		product_pg.getOp2 = getOp2;
		String Color = getOp2.getAttribute("aria-label").toString();
		product_pg.Color = Color;
		action.actClick(getOp2);
		product.info("Color '"+Color+"' is selected");
		
		Robot rob = new Robot();
		newQty.click();
		rob.keyPress(KeyEvent.VK_DELETE);
		newQty.sendKeys("1");
		rob.keyRelease(KeyEvent.VK_DELETE);
		product.info("Qty "+Qty+" is Entered");
		
		Integer Qty = Integer.valueOf(prodQty.getAttribute("value"));
		product_pg.Qty = Qty;
		
	}

	public void addCart() throws Exception {
		Thread.sleep(1000);
		action.actClick(cartButton);
		product.info("Add to Cart button clicked");
	}
	
	public void confirmMsg(WebDriver driver) throws Exception {
		js = (JavascriptExecutor)driver;
		Thread.sleep(5000);
		js.executeScript("arguments[0].scrollIntoView(true)", messages);
		if((messages.getAttribute("data-bind")).equals("html: message.text")) {
			System.out.println("The Confirmation message is Displayed");
			product.pass("The Confirmation message is Displayed");
		}else {
			System.out.println("The Confirmation message is NOT Displayed");
			product.fail("The Confirmation message is NOT Displayed");
		}
	}
	
	public void stockCheck() {
		if(stock.getText().equals("In stock")) {
			product.fail("Product is in Stock");
		}else {
			product.fail("Product is Out of Stock");
		}
	}
}

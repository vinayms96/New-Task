package pageModels;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import generic.action;
import generic.openBrowser;

public class cart_pg {
	ExtentTest cart = openBrowser.extent.createTest("Cart Page");
	minicart_pop mp;
	JavascriptExecutor js;

	@FindBy(xpath = "//td[@class='col item']//strong[@class='product-item-name']/a")
	private WebElement cartName;
	@FindBy(xpath = "//td[@class='col price']//span[@class='cart-price']/span")
	private WebElement cartPrice;
	@FindBy(xpath = "//div[@class='control qty']/input[@class='input-text qty']")
	private WebElement cartQty;
	@FindBy(xpath = "//td[@class='col subtotal']/span/span/span")
	private WebElement subTotal;
	@FindBy(xpath = "//li[@class='item']//button[@class='action primary checkout']")
	private WebElement checkout;
	@FindBy(xpath = "//span[contains(text(),'See Details')]")
	private WebElement seeDetails;

	public cart_pg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//	public void checkProdname(WebDriver driver) {
//		mp = new minicart_pop(driver);
//		
//		//Product Name check
//		System.out.println(mp.productName);
//		System.out.println(mp.productPrice);
//		if ((mp.productName).equals(cartName.getText())) {
//			System.out.println("Same product is displayed in Cart Page");
//		} else {
//			System.out.println("Different product is displayed in Cart Page");
//		}
//		
//		//Product price check
//		if ((mp.productPrice).equals(cartPrice.getText())) {
//			System.out.println("Product price is same in Cart");
//		}else {
//			System.out.println("Product price is NOT same in Cart");
//		}
//	}
	
//	public void configOptions() {
//		int count = 1;
//		while(count<3) {
//			switch (count) {
//			case 1:
//				if (((product_pg.getOp1).getAttribute("aria-label").toString()).equals(product_pg.Size)) {
//					System.out.println("Same Size is added to Cart");
//				} else {
//					System.out.println("Different Size is added to Cart");
//				}
//				break;
//			case 2:
//				if ((product_pg.getOp2.getAttribute("aria-label").toString()).equals(product_pg.Color)) {
//					System.out.println("Same Color Attribute is added to Cart");
//				} else {
//					System.out.println("Different Color Attribute is added to Cart");
//				}
//				break;
//			default:
//				System.out.println("Product not added to Cart.");
//			}
//			count++;
//		}
//	}
	
	public void clickCheckout(WebDriver driver) throws Exception {
		js = (JavascriptExecutor)driver;
		Thread.sleep(5000);
		js.executeScript("arguments[0].scrollIntoView(true);", checkout);
		action.actClick(checkout);
		cart.info("Checkout button is clicked");
	}

}

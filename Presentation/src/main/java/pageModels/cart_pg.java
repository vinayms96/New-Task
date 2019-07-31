package pageModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.action;

public class cart_pg {
	minicart_pop mp;

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

	public cart_pg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void checkProdname(WebDriver driver) {
		mp = new minicart_pop(driver);
		
		//Product Name check
		if ((mp.productName).equals(cartName.getText())) {
			System.out.println("Same product is displayed in Cart Page");
		} else {
			System.out.println("Different product is displayed in Cart Page");
		}
		
		//Product price check
		if ((mp.productPrice).equals(cartPrice.getText())) {
			System.out.println("Product price is same in Cart");
		}else {
			System.out.println("Product price is NOT same in Cart");
		}
	}
	
	public void clickCheckout() {
		action.actClick(checkout);
	}

}

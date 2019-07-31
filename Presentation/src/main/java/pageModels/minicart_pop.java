package pageModels;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.action;

public class minicart_pop {
	product_pg pp;
	WebElement getOp1;
	WebElement getOp2;
	String productName;
	String productPrice;

	@FindBy(xpath = "//a[@class='action showcart']")
	private WebElement mini;
	@FindBy(xpath = "//div[@class='items-total']/span")
	private WebElement itemCount;
	@FindBy(xpath = "//div[@class='page-title-wrapper product']/h1/span")
	private WebElement prodName;
	@FindBy(xpath = "//div[@class='minicart-items-wrapper']/ol/li[1]/div/div/strong/a")
	private WebElement miniName;
	@FindAll(@FindBy(xpath = "//div[@class='minicart-items-wrapper']/ol/li[1]/div/div/div/div/dl/dd/span"))
	private List<WebElement> options;
	@FindBy(xpath = "//div[@class='actions'][2]/div/a")
	private WebElement goCart;
	@FindBy(xpath = "//input[@class='item-qty cart-item-qty']")
	private WebElement miniQty;
	@FindBy(xpath = "//div[@class='minicart-wrapper']/a/span[2]")
	private WebElement cartCounter;
	@FindAll(@FindBy(xpath = "//div[@class='swatch-opt']/div[1]/div/div[@class='swatch-option text']"))
	private List<WebElement> swatch1;
	@FindAll(@FindBy(xpath = "//div[@class='swatch-opt']/div[2]/div/div[@class='swatch-option color']"))
	private List<WebElement> swatch2;
	@FindBy(xpath = "//span[contains(text(),'See Details')]")
	private WebElement seeDetails;
	@FindBy(xpath = "//div[@class='product-options-bottom']/.//div[@class='field qty']/div/input")
	private WebElement prodQty;
	@FindBy(xpath = "//span[@class='price-wrapper ']/span")
	private WebElement prodPrice;
	@FindBy(xpath = "//span[@class='minicart-price']/span")
	private WebElement miniPrice;

	public minicart_pop(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void openPop(WebDriver driver) throws Exception {
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(5000);
		action.actClick(mini);
	}

	public void miniCount() {
		Integer item = Integer.valueOf(itemCount.getText());
		System.out.println(item + " Product(s) added to Cart");
	}

	public void productName() {
		productName = (miniName.getText().toString());
		if ((miniName.getText().toString()).equals(prodName.getText().toString())) {
			System.out.println("The Product '" + prodName.getText().toString() + "' is added to Cart");
		} else {
			System.out.println("The Product '" + prodName.getText().toString() + "' is NOT added to Cart");
		}
	}

//	public void configOptions(WebDriver driver) {
//		int count = 1;
//		pp = new product_pg(driver);
//		while(count<3) {
//			switch (count) {
//			case 1:
//				if ((Size).equals(Size)) {
//					System.out.println("Same Size is added to Cart");
//				} else {
//					System.out.println("Different Size is added to Cart");
//				}
//				break;
//			case 2:
//				if ((Color).equals(Color)) {
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
	
	public void checkPrice() {
		productPrice = prodPrice.getText();
		if(prodPrice.getText().equals(miniPrice.getText())) {
			System.out.println("Product Price is Same");
		}else {
			System.out.println("Product price is NOT Same");
		}
	}
	
	public void miniProdQty() {
		Integer Qty = Integer.valueOf(prodQty.getAttribute("value"));
		action.actClick(seeDetails);
		if(Integer.valueOf(miniQty.getAttribute("data-item-qty")).equals(Qty)) {
			System.out.println("Same Qty is added to Cart");
		}else {
			System.out.println("Different Qty is added to Cart");
		}
	}

	public void goToCart() {
		action.actClick(goCart);
	}
}

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
	@FindBy(xpath = "//div[@id='ui-id-28']/.//input")
	private WebElement miniQty;
	@FindBy(xpath = "//div[@class='minicart-wrapper']/a/span[2]")
	private WebElement cartCounter;

	public minicart_pop(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void openPop(WebDriver driver) {
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		action.actClick(mini);
	}

	public void miniCount() {
		Integer item = Integer.valueOf(itemCount.getText());
		System.out.println(item + " Product(s) added to Cart");
	}

	public void productName() {
		if ((miniName.getText()).equals(prodName.getText())) {
			System.out.println("The Product " + prodName + "is added to Cart");
		} else {
			System.out.println("The Product " + prodName + "is NOT added to Cart");
		}
	}

	public void configOptions(WebDriver driver) {
		int count = 1;
		pp = new product_pg(driver);
		while(count<3) {
			switch (count) {
			case 1:
				if ((options.get(count).getText()).equals(pp.Size)) {
					System.out.println("Same Size is added to Cart");
				} else {
					System.out.println("Different Size is added to Cart");
				}
				break;
			case 2:
				if ((options.get(count).getText()).equals(pp.Color)) {
					System.out.println("Same Color Attribute is added to Cart");
				} else {
					System.out.println("Different Color Attribute is added to Cart");
				}
				break;
			default:
				System.out.println("Product not added to Cart.");
			}
			count++;
		}
	}
	
	public void goToCart() {
		action.actClick(goCart);
	}
	
	public void miniProdQty() {
		if(miniQty.getAttribute("data-item-qty").equals(pp.Qty)) {
			System.out.println("Same Qty is added to Cart");
		}else {
			System.out.println("Different Qty is added to Cart");
		}
	}
}

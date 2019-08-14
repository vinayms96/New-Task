package pageModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import generic.action;
import generic.openBrowser;

public class account_pg {
	ExtentTest account = openBrowser.extent.createTest("Account Page");

	@FindBy(xpath = "//div[@class='content block-collapsible-nav-content']/ul/li[2]/a")
	private WebElement order;
	@FindBy(xpath = "//div[@class='table-wrapper orders-history']/table/tbody/tr/td")
	private WebElement getID;
	@FindBy(xpath = "//tr[@id='order-item-row-1']/td/strong")
	private WebElement acProductName;
	
	public account_pg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyProductName() {
		System.out.println(product_pg.productName);
		if((acProductName.getText()).equals(product_pg.productName)) {
			System.out.println("The Product ordered is "+" '"+product_pg.productName+"'");
			account.pass("The Product ordered is "+" '"+product_pg.productName+"'");
		}else {
			System.out.println("Could not retrieve the Product Name");
			account.fail("Could not retrieve the Product Name");
		}
	}
	
	public void orderLink() {
		action.actClick(order);
		account.info("Order Page is opened");
	}
	
	public void checkOrderId() {
		String acID = getID.getText();
		if(acID.equals(checkout_pg.orderID)) {
			System.out.println("Order placed Successfully with Order Id: "+acID);
			account.pass("Order placed Successfully with Order Id: "+acID);
		}else {
			System.out.println("Order NOT placed Successfully");
			account.fail("Order NOT placed Successfully");
		}
	}
	
	
	
}

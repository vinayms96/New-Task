package pageModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.action;

public class account_pg {

	@FindBy(xpath = "//div[@class='content block-collapsible-nav-content']/ul/li[2]/a")
	private WebElement order;
	@FindBy(xpath = "//div[@class='table-wrapper orders-history']/table/tbody/tr/td")
	private WebElement getID;
	
	public account_pg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void orderLink() {
		action.actClick(order);
	}
	
	public void checkOrderId(WebDriver driver) {
		checkout_pg cp = new checkout_pg(driver);
		Integer acID = Integer.valueOf(getID.getText());
		if(acID.equals(cp.orderID)) {
			System.out.println("Order placed Successfullywith Order Id: "+acID);
		}else {
			System.out.println("Order NOT placed Successfully");
		}
	}
	
}

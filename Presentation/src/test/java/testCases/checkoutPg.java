package testCases;

import org.testng.annotations.Test;

import generic.openBrowser;
import pageModels.checkout_pg;

public class checkoutPg extends openBrowser{
	@Test
	public void checkout() throws Exception{
		checkout_pg chp = new checkout_pg(driver);
//		chp.filldetails();		
		chp.shipping(driver);
		chp.bank(driver);
		chp.confirmationPage();
		chp.getOrderId();
		chp.accountPage(driver);
	}
}

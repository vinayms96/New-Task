package testCases;

import org.testng.annotations.Test;

import generic.openBrowser;
import pageModels.checkout_pg;

public class checkoutPg extends openBrowser{
	@Test
	public void checkout() throws Exception{
		checkout_pg chp = new checkout_pg(driver);
//		chp.filldetails();		
		chp.shipping();
		chp.bank();
		chp.confirmationPage();
		chp.getOrderId();
		chp.accountPage();
	}
}

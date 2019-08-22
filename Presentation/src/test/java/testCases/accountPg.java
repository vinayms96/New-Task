package testCases;

import org.testng.annotations.Test;

import generic.openBrowser;
import pageModels.account_pg;

public class accountPg extends openBrowser{

	@Test
	public void account() throws Exception {
		account_pg ap = new account_pg(driver);
		ap.verifyProductName();
		ap.orderLink();
		ap.checkOrderId();
	}
	
}

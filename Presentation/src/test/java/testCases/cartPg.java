package testCases;

import org.testng.annotations.Test;

import generic.openBrowser;
import pageModels.cart_pg;

public class cartPg extends openBrowser{

	@Test
	public void cart() throws Exception {
		cart_pg cp = new cart_pg(driver);
//		cp.checkProdname(driver);
//		cp.configOptions();
		cp.clickCheckout(driver);
	}
	
}

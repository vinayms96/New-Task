package testCases;

import org.testng.annotations.Test;

import generic.openBrowser;
import pageModels.minicart_pop;

public class minicartPop extends openBrowser{
	
	@Test
	public void miniCart() throws Exception {
		minicart_pop mp = new minicart_pop(driver);
//		product_pg pp = new product_pg(driver);
		mp.openPop(driver);
		mp.miniCount();
		mp.productName();
//		pp.configOptions(driver);
		mp.checkPrice();
		mp.miniProdQty();
		mp.goToCart();	
	}
	
}

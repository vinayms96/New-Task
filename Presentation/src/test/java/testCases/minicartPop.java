package testCases;

import org.testng.annotations.Test;

import generic.openBrowser;
import pageModels.minicart_pop;

public class minicartPop extends openBrowser{
	
	@Test
	public void miniCart() {
		minicart_pop mp = new minicart_pop(driver);
		mp.openPop(driver);
		mp.miniCount();
		mp.productName();
		mp.configOptions(driver);
		mp.goToCart();
	}
	
}

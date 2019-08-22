package testCases;

import org.testng.annotations.Test;

import generic.openBrowser;
import pageModels.product_pg;

public class productPg extends openBrowser{
	@Test
	public void product() throws Exception{
		product_pg pp = new product_pg(driver);
		pp.swatches(driver);
		pp.addCart();
		pp.confirmMsg(driver);
		pp.stockCheck();
	}
}

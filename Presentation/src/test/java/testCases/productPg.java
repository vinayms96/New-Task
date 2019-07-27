package testCases;

import org.testng.annotations.Test;

import generic.openBrowser;
import pageModels.product_pg;

public class productPg extends openBrowser{
	@Test
	public void product(){
		product_pg pp = new product_pg(driver);
		pp.swatches(driver);
	}
}

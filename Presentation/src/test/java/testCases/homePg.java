package testCases;

import org.testng.annotations.Test;

import generic.openBrowser;
import pageModels.home_pg;

public class homePg extends openBrowser{
	@Test
	public void home() throws Exception {
		home_pg hp = new home_pg(driver);
		
		hp.mainCat();
		hp.subCategory1();
		hp.subcategory2();
	}
}

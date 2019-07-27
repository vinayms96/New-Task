package testCases;

import org.testng.annotations.Test;

import generic.openBrowser;
import pageModels.listing_pg;

public class listingPg extends openBrowser {
	@Test
	public void listing() {
		listing_pg lp = new listing_pg(driver);
		
//		lp.fromList(driver);
		lp.goProd(driver);
//		lp.cartClick();
	}
}

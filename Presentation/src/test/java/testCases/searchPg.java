package testCases;

import org.testng.annotations.Test;

import generic.openBrowser;
import pageModels.search_pg;

public class searchPg extends openBrowser{
	@Test
	public void search() {
		search_pg sp = new search_pg(driver);
		sp.search(driver);
	}
}

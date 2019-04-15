package script;

import org.testng.annotations.Test;

import POM.search_pg;
import generic.openbrowser;

public class searchpg extends openbrowser {
	
	@Test
	public void getAll() {
		search_pg sp = new search_pg(driver);
		
		sp.collect();
		System.out.println("Check");
	}
}

package script;

import org.testng.annotations.Test;

import POM.search_pg;
import generic.openbrowser;

public class searchpg extends openbrowser {
	
	@Test
	public void getAll() {
		search_pg sp = new search_pg(driver);
		
		System.out.println("Displaying all the Property prices of the Search Page...\n");
		sp.collect();
		
	}
}

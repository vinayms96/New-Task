package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import POM.home_pg;
import generic.Property;
import generic.openbrowser;


public class homepg extends openbrowser {

	@Test
	public void zoop() {
		home_pg hp = new home_pg(driver);
		
		//Enter the Search
		System.out.println("Entering the Search Location...");
		hp.searchbox(Property.getProp(dataprop, "location"));
		hp.submit();
		String actual = driver.getTitle();
		String expected = "Property for Sale in London - Buy Properties in London - Zoopla";
		try {
			System.out.println("Checking the Page opened is of searched Location...");
			Assert.assertEquals(expected, actual);
			System.out.println("Search Results displayed are of Search Location.");
		}catch(Exception e) {
			System.out.println("Wrong page is displayed.");
		}
	}
	
}

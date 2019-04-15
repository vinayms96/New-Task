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
		hp.searchbox(Property.getProp(dataprop, "location"));
		hp.submit();
		String actual = driver.getTitle();
		String expected = "Property for Sale in London - Buy Properties in London - Zoopla";
		try {
			Assert.assertEquals(expected, actual);
			System.out.println("Search Results are displayed.");
		}catch(Exception e) {
			System.out.println("Wrong page is displayed.");
		}
	}
	
}

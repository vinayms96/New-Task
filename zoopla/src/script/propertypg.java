package script;

import org.testng.annotations.Test;

import POM.property_pg;
import generic.openbrowser;

public class propertypg extends openbrowser{

	@Test
	public void details() {
	property_pg pp = new property_pg(driver);
	System.out.println("Going to Agents Page...");
	pp.agent();
	}
}

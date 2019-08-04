package testCases;

import org.testng.annotations.Test;

import generic.openBrowser;
import pageModels.login_pg;

public class loginPg extends openBrowser{

	@Test
	public void login() throws Exception {
		login_pg lp = new login_pg(driver);
		lp.clickSign(driver);
		lp.mail();
		lp.password();
		lp.buttonSign(driver);
	}
	
}

package testCases;

import org.testng.annotations.Test;

import POM.home_page;
import excelUtilities.callUtils;
import generic.openBrowser;

public class homePage extends openBrowser{
	
	
	@Test(dataProvider = "userPass",dataProviderClass = callUtils.class)
	public void home(String name , String pass) {
		home_page hp = new home_page(driver);
//		excelUtils excel = new excelUtils(sheetName+1,readPath);
		
		if(hp.popClose()==1) {
			hp.userName(name);
			hp.passWord(pass);
			hp.logPrompt();
		}else if(hp.popClose()==0) {
			hp.openPop();
			hp.userName(name);
			hp.passWord(pass);
			hp.logPrompt();
		}
	}

}

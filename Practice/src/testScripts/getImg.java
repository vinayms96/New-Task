package testScripts;

import org.testng.annotations.Test;

import Pom.get_Img;
import general.openBrowser;

public class getImg extends openBrowser{
	
	@Test
	public void findImg() {
		
		get_Img gi = new get_Img(driver);
		
		gi.img();
	}

}

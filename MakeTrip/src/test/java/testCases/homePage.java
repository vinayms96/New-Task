package testCases;

import com.mmt.generic.openBrowser;
import com.mmt.pomClasses.home_Page;
import org.testng.annotations.Test;

@Test
public class homePage extends openBrowser {
    public void home(){
        home_Page hp = new home_Page(driver);
        hp.verifyCat();
        hp.selectType();
    }
}

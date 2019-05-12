package POM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import generic.Action;
import generic.openbrowser;

public class search_pg extends openbrowser {

	@FindBys(@FindBy(xpath="//div[@class=\"listing-results-wrapper\"]/div[2]/a"))
	private List<WebElement> prices;
	
	public search_pg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void collect() {
		ArrayList<WebElement> al = new ArrayList<WebElement>();
		for(WebElement ele : prices) {
			al.add(ele);
		}
		int val = al.size();
		System.out.println(val);
//		ArrayList<String> element = al;
		Collections.sort(al,Collections.reverseOrder());
		for(int i=0 ; i<val; i++) {
		System.out.println("Price of Property "+i+": "+al.get(i).getText());
		}
		
		System.out.println("Selecting 5th Property from the List...");
//		al.get(4).click();
		Action.actClick(driver, prices.get(4));
	}
	
}

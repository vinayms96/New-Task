package Pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class get_Img {

	@FindAll(@FindBy(tagName = "img"))
	private List<WebElement> ele;

	public get_Img(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void img() {

		for(int i=0 ; i<ele.size();i++) {
			System.out.println(ele.get(i).getAttribute("outerHTML"));
		}

		for (WebElement val : ele) {
			if (val.getAttribute("src") != null) {
				System.out.println(val.getAttribute("src"));
			}else {
				System.out.println("\n src link NOT Found: "+val.getAttribute("outerHTML")+"\n");
			}
		}

	}

}

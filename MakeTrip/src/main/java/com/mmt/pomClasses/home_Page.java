package com.mmt.pomClasses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmt.generic.Property;
import com.mmt.generic.action;
import com.mmt.generic.common.dateSelector;

public class home_Page {

	@FindBy(xpath = "//div[@class=\"makeFlex\"]/ul/li")
	private List<WebElement> type;
	@FindBy(xpath = "//ul[@class='makeFlex font12']/li")
	private List<WebElement> menus;

	// Fsw Inout data
	@FindBy(xpath = "//div[@class='fsw_inner ']/div")
	private List<WebElement> fswRow;
//	@FindBy(xpath = "(//div[@id='react-autowhatever-1']/..//ul/li)[1]/div[1]/div/p[1]")
//	private static WebElement selectSuggestion;
//	@FindBy(xpath = "//div[@id='react-autowhatever-1']/..//ul/li")
//	private static List<WebElement> sugg;
	

	// From City
	@FindBy(xpath = "//div[@class='fsw_inner ']/div/label[@for='fromCity']")
	private WebElement fromCity;

	// To City
	@FindBy(xpath = "//div[@class='fsw_inputBox searchToCity inactiveWidget ']/label")
	private WebElement toCity;

	// FromDate
	@FindBy(xpath = "//div[@class='fsw_inputBox dates inactiveWidget ']/label")
	private WebElement fromDate;
	@FindAll(@FindBy(xpath = "//div[@class='DayPicker-wrapper']/div[2]/div/div[3]/div/div"))
	private WebElement from;

	// ReturnDate
	@FindBy(xpath = "(//div[@class='DayPicker-Months']/div[1]/div[3]/div)[1]")
	private WebElement dayLoop;
	@FindBy(xpath = "//div[@class='DayPicker-Months']/div[1]/div[3]")
	private WebElement weekLoop;
	@FindBy(xpath = "//div[@class='DayPicker-Months']/div[1]")
	private WebElement monthLoop;

	// SearchButton
	@FindBy(xpath = "//p[@class='makeFlex vrtlCenter ']/a")
	private WebElement searchBut;

	public home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/* Check if Flights Menu is Selected */
	public void verifyCat() {
		ArrayList<WebElement> menuList = new ArrayList<>(15);
		for (WebElement ele : menus) {
			menuList.add(ele);
		}
		Iterator<WebElement> iter = menuList.iterator();
		while (iter.hasNext()) {
			WebElement ele = (WebElement) iter.next();
			String fetchClass = ele.findElement(By.tagName("a")).getAttribute("class");
			if (fetchClass.contains("active")) {
				if ((ele.findElement(By.xpath("//span[text()='Flights']")).getText()).equals("Flights")) {
					break;
				} else {
					action.actClick(menuList.get(0));
					break;
				}
			}
		}
	}

	/* Select the Type of Trip */
	public void selectType() {
		ArrayList<WebElement> li = new ArrayList<>(5);
		for (WebElement ele : type) {
			li.add(ele);
		}
		if (Property.getData("travelType").equals("1")) {
			System.out.println("Chose ONEWAY TRIP");
			home_Page.loop(0, li);
		} else if (Property.getData("travelType").equals("2")) {
			System.out.println("Chose ROUND CITY");
			home_Page.loop(1, li);
			String text = li.get(1).getText();
			System.out.println(text);
		} else if (Property.getData("travelType").equals("3")) {
			System.out.println("Chose MULTI CITY");
			home_Page.loop(2, li);
		}
	}

	public static void loop(int num, ArrayList<WebElement> li) {
		if (!(li.get(num).getAttribute("class")).equals("selected")) {
			action.actClick(li.get(num).findElement(By.tagName("span")));
		}
	}

	public void fsw(String from, String to, WebDriver driver) {
		try {
			dateSelector ds = new dateSelector(driver);
		for (int loop = 1; loop < fswRow.size(); loop++) {
			switch (loop) {
			case 1:
				action.actClick(fromCity);
				ds.dateSelect(loop, from, driver);
				break;
			case 2:
				action.actClick(toCity);
				ds.dateSelect(loop, to, driver);
				break;
			case 3:
				ds.dateSelect(loop, "", driver);
			case 4:
//				dateSelector.dateSelect(loop, "", driver);
//				break;
				continue;
			default:
				continue;
			}
		}
		}catch(Exception e){
//			e.printStackTrace();
			System.out.println("Home Page: "+e.getMessage());
		}
	}

	public void search() {
		action.actClick(searchBut);
	}
}

package com.mmt.pomClasses;

import com.mmt.generic.Property;
import com.mmt.generic.action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class home_Page {

	@FindBy(xpath = "//div[@class=\"makeFlex\"]/ul/li")
	private List<WebElement> type;
	@FindBy(xpath = "//ul[@class='makeFlex font12']/li")
	private List<WebElement> menus;

	// Fsw Inout data
	@FindBy(xpath = "//div[@class='fsw_inner ']/div")
	private List<WebElement> fswRow;
	@FindBy(xpath = "(//div[@id='react-autowhatever-1']/..//ul/li)[1]/div[1]/div/p[1]")
	private static WebElement selectSuggestion;
	@FindBy(xpath = "//div[@id='react-autowhatever-1']/..//ul/li")
	private static List<WebElement> sugg;
	@FindBy(xpath = "//div[@class='hsw_autocomplePopup autoSuggestPlugin']/div/input")
	private static WebElement Input;

	// From City
	@FindBy(xpath = "//div[@class='fsw_inner ']/div/label[@for='fromCity']")
	private WebElement fromCity;

	// To City
	@FindBy(xpath = "//div[@class='fsw_inputBox searchToCity inactiveWidget ']/label")
	private WebElement toCity;

	// FromDate
	@FindBy(xpath = "//div[@class='fsw_inputBox dates inactiveWidget ']/label")
	private WebElement fromDate;

	// ReturnDate
	@FindBy(xpath = "(//div[@class='DayPicker-Months']/div[1]/div[3]/div)[1]")
	private WebElement dayLoop;
	@FindBy(xpath = "//div[@class='DayPicker-Months']/div[1]/div[3]")
	private WebElement weekLoop;
	@FindBy(xpath = "//div[@class='DayPicker-Months']/div[1]")
	private WebElement monthLoop;
	
	//SearchButton
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
		Iterator iter = menuList.iterator();
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
		if (Property.getData("travelType") == "one") {
			System.out.println("Chose ONEWAY TRIP");
			home_Page.loop(0, li);
		} else if (Property.getData("travelType") == "two") {
			System.out.println("Chose ROUND CITY");
			home_Page.loop(1, li);
			String text = li.get(1).getText();
			System.out.println(text);
		} else {
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
		for (int loop = 1; loop < fswRow.size(); loop++) {
			switch (loop) {
			case 1:
				action.actClick(fromCity);
				dateSelector(loop, from, driver);
			case 2:
				action.actClick(toCity);
				dateSelector(loop, to, driver);
			case 4:
				dateSelector(loop, "", driver);
			}
		}
	}

	public static void dateSelector(int loop, String fromto, WebDriver driver) {
		Input.sendKeys(fromto);
		if (loop == 1 || loop == 2) {
			Robot r;
			try {
				r = new Robot();
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 1; i < sugg.size(); i++) {
				String cityCode = sugg.get(i).findElement(By.xpath("//div[@class='makeFlex hrtlCenter']/div/p[1]")).getText();
				if (fromto.contains(cityCode)) {
					action.actClick(selectSuggestion);
					break;
				}
			}
		} else if (loop > 3) {
			datePickLoop:
			for (int month = 1; month < 3; month++) {
				for (int week = 1; week < 6; week++) {
					for (int day = 1; day < 8; day++) {
						WebElement ele = driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[" + month + "1]/div[3]/div[" + week + "1]/div[" + day + "1]"))
								.findElement(By.tagName("div"));
						String content = ele.getAttribute("aria-selected");
						if (content.equals("true")) {
							pickReturn(month, week, day, driver);
							break datePickLoop;
						}
					}
				}
			}
		}
	}

	public static void pickReturn(int month, int week, int day, WebDriver driver) {
		int count = 1;
		for (int mon = month; mon < 3; mon++) {
			for (int wk = week; wk < 6; wk++) {
				for (int d = day; d < 8; d++) {
					WebElement ele = driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[" + mon + "1]/div[3]/div[" + wk + "1]/div[" + d + "1]"))
							.findElement(By.tagName("div"));
					if (count == 7) {
						action.actClick(ele.findElement(By.tagName("div")));
					}
					count++;
				}
			}
		}
	}
	
	public void search() {
		action.actClick(searchBut);
	}
}

package com.mmt.generic.common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmt.generic.action;

public class dateSelector {
	
	@FindBy(xpath = "//div[@class='hsw_autocomplePopup autoSuggestPlugin']/div/input")
	private static WebElement Input;
	@FindBy(xpath = "(//div[@id='react-autowhatever-1']/..//ul/li)[1]/div[1]/div/p[1]")
	private static WebElement selectSuggestion;
	@FindBy(xpath = "//div[@id='react-autowhatever-1']/..//ul/li")
	private static List<WebElement> sugg;
	@FindBy(xpath = "//input[@id='departure']")
	private WebElement dept;
	
	public dateSelector(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void dateSelect(int loop, String fromto, WebDriver driver) {
		System.out.println("Loop "+loop);
		try {
		Input.sendKeys(fromto);
		if (loop <= 2 && loop != 0) {
			Robot r;
			try {
				r = new Robot();
				r.keyPress(KeyEvent.VK_ENTER);
//				Input.sendKeys(fromto);
				r.keyRelease(KeyEvent.VK_ENTER);
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			for (int i = 1; i < sugg.size(); i++) {
				driver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);
				if(sugg.get(i).findElement(By.xpath("//div[@class='makeFlex hrtlCenter']/div/p[1]")).isDisplayed()) {
					String cityCode = sugg.get(i).findElement(By.xpath("//div[@id='react-autowhatever-1']/div/ul/li["+i+"]/div/div/p[1]")).getText();
					System.out.println(cityCode.split(" ").toString());
					System.out.println(cityCode);
					action.actClick(selectSuggestion);
				}
				
			}			
		} 
		else if (loop > 2) {
			action.actClick(dept);
			LocalDate todayDate = LocalDate.now();
			System.out.println(todayDate.withDayOfMonth(1));
		} 
		else if (loop == 10) {
			datePickLoop: for (int month = 1; month < 3; month++) {
				for (int week = 1; week < 6; week++) {
					for (int day = 1; day < 8; day++) {
						WebElement ele = driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[" + month
								+ "1]/div[3]/div[" + week + "1]/div[" + day + "1]")).findElement(By.tagName("div"));
						String content = ele.getAttribute("aria-selected");
						if (content.equals("true")) {
							pickReturn(month, week, day, driver);
							break datePickLoop;
						}
					}
				}
			}
		}
		}catch(Exception e) {
			System.out.println("error "+e.getMessage());
		}
	}
	public static void pickReturn(int month, int week, int day, WebDriver driver) {
		int count = 1;
		for (int mon = month; mon < 3; mon++) {
			for (int wk = week; wk < 6; wk++) {
				for (int d = day; d < 8; d++) {
					WebElement ele = driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[" + mon
							+ "1]/div[3]/div[" + wk + "1]/div[" + d + "1]")).findElement(By.tagName("div"));
					if (count == 7) {
						action.actClick(ele.findElement(By.tagName("div")));
					}
					count++;
				}
			}
		}
	}
}

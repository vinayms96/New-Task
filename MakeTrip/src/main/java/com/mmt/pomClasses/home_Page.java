package com.mmt.pomClasses;

import com.mmt.generic.Property;
import com.mmt.generic.action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class home_Page {

    @FindBy(xpath = "//div[@class=\"makeFlex\"]/ul/li")
    private List<WebElement> type;
    @FindBy(xpath = "//ul[@class='makeFlex font12']/li")
    private List<WebElement> menus;

    public home_Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /*Check if Flights Menu is Selected*/
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

    /*Select the Type of Trip*/
    public void selectType() {
        ArrayList<WebElement> li = new ArrayList<>(5);
        for (WebElement ele : type) {
            li.add(ele);
        }
            if (Property.getData("travelType") == "one") {
                System.out.println("Chose ONEWAY TRIP");
                home_Page.loop(0,li);
            } else if (Property.getData("travelType") == "two") {
                System.out.println("Chose ROUND CITY");
                home_Page.loop(1,li);
                String text = li.get(1).getText();
                System.out.println(text);
            } else {
                System.out.println("Chose MULTI CITY");
                home_Page.loop(2,li);
            }
    }
    public static void loop(int num,ArrayList<WebElement> li){
        if(!(li.get(num).getAttribute("class")).equals("selected")){
            action.actClick(li.get(num).findElement(By.tagName("span")));
        }
    }

}

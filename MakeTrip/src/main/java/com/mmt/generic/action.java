package com.mmt.generic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class action extends openBrowser{

    static Actions act = new Actions(driver);

    public static void actMove(WebElement ele){
        act.moveToElement(ele).perform();
    }

    public static void actClick(WebElement ele){
        act.moveToElement(ele).click(ele).build().perform();
    }
}

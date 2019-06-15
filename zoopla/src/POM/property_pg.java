package POM;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.openbrowser;

public class property_pg extends openbrowser {

	@FindBy(xpath = "//div[@class=\"ui-agent\"]/a/div[2]/h4")
	private WebElement agentDetails;

	public property_pg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void agent() {
		try {
			agentDetails.isDisplayed();
			agentDetails.click();
			String actual = driver.getTitle();
			String expected = "Cameron Estate Agents, UB8 - Estate and Letting Agents  - Zoopla";
			try{
				assertEquals(actual, expected);
				System.out.println("Agents page is Displayed");
			}catch(Exception e) {
				System.out.println("Agents page not displayed");
			}
		}catch(Exception e) {
			System.out.println("Element not Found");
		}
	}
}

package pageModels;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.action;

public class product_pg {
	String Size;
	String Color;
	String Qty;

	@FindAll(@FindBy(xpath = "//div[@class='product-add-form']/form/..//div[@class='swatch-opt']/div/div"))
	private List<WebElement> swatches;
	@FindBy(xpath = "//button[@title='Add to Cart']")
	private WebElement cartButton;
	@FindAll(@FindBy(xpath = "//div[@class='swatch-opt']/div[1]/div/div[@class='swatch-option text']"))
	private List<WebElement> swatch1;
	@FindAll(@FindBy(xpath = "//div[@class='swatch-opt']/div[2]/div/div[@class='swatch-option color']"))
	private List<WebElement> swatch2;
	@FindBy(xpath = "//div[@class='messages']/div/div")
	private WebElement messages;
	@FindBy(xpath = "//div[@class='product-options-bottom']/.//div[@class='field qty']/div/input")
	private WebElement prodQty;

	public product_pg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void swatches() {
		Random r = new Random();
		
		//Selecting first Swatch
		WebElement getOp1 = swatch1.get(r.nextInt(swatch1.size()));
		Size = getOp1.getAttribute("aria-label");
		action.actClick(getOp1);
		
		//Selecting Second swatch
		WebElement getOp2 = swatch2.get(r.nextInt(swatch2.size()));
		Color = getOp2.getAttribute("aria-label");
		action.actClick(getOp2);
	}

	public void addCart() {
		action.actClick(cartButton);
	}
	
	public void confirmMsg(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		generic.wait.waitVisible(messages);
		if(messages.getAttribute("data-bind").equals("html: message.text")) {
			System.out.println("The Confirmation message is Displayed");
		}else {
			System.out.println("The Confirmation message is NOT Displayed");
		}
	}
	
	public void getProdQty() {
		Qty = prodQty.getAttribute("value");
	}
}

package pageModels;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.action;

public class product_pg {
	String Size;
	String Color;
	Integer Qty;
	WebElement getOp1;
	WebElement getOp2;

	@FindAll(@FindBy(xpath = "//div[@class='product-add-form']/form/..//div[@class='swatch-opt']/div/div"))
	private List<WebElement> swatches;
	@FindBy(xpath = "//button[@title='Add to Cart']")
	private WebElement cartButton;
	@FindAll(@FindBy(xpath = "//div[@class='swatch-attribute-options clearfix']/div[@class='swatch-option color']"))
	private List<WebElement> swatch1;
	@FindAll(@FindBy(xpath = "//div[@class='swatch-attribute-options clearfix']/div[@class='swatch-option text']"))
	private List<WebElement> swatch2;
	@FindBy(xpath = "//input[@id='qty']")
	private WebElement newQty;
	@FindBy(xpath = "//div[@class='messages']/div/div")
	private WebElement messages;
	@FindBy(xpath = "//div[@class='product-options-bottom']/.//div[@class='field qty']/div/input")
	private WebElement prodQty;
	@FindBy(xpath = "//span[contains(text(),'See Details')]")
	private WebElement seeDetails;

	public product_pg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void swatches() throws Exception {
		
		Thread.sleep(2000);
		Random r = new Random();
		
		//Selecting first Swatch
		getOp1 = swatch1.get(r.nextInt(swatch1.size()));
		Size = getOp1.getAttribute("aria-label").toString();
		System.out.println("Size "+Size);
		action.actClick(getOp1);
		
		//Selecting Second swatch
		Thread.sleep(2000);
		getOp2 = swatch2.get(r.nextInt(swatch2.size()));
		Color = getOp2.getAttribute("aria-label").toString();
		System.out.println("color "+Color);
		action.actClick(getOp2);
		
		Robot rob = new Robot();
		newQty.click();
		rob.keyPress(KeyEvent.VK_DELETE);
		newQty.sendKeys("1");
		rob.keyRelease(KeyEvent.VK_DELETE);
		
		Qty = Integer.valueOf(prodQty.getAttribute("value"));
		
	}

	public void addCart() throws Exception {
		Thread.sleep(1000);
		action.actClick(cartButton);
	}
	
	public void confirmMsg(WebDriver driver) throws Exception {
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(3000);
		if((messages.getAttribute("data-bind")).equals("html: message.text")) {
			System.out.println("The Confirmation message is Displayed");
		}else {
			System.out.println("The Confirmation message is NOT Displayed");
		}
	}
	
	public void configOptions(WebDriver driver) {
		int count = 1;
		action.actClick(seeDetails);
		while(count<3) {
			switch (count) {
			case 1:
				if ((getOp1.getAttribute("aria-label").toString()).equals(Size)) {
					System.out.println("Same Size is added to Cart");
				} else {
					System.out.println("Different Size is added to Cart");
				}
				break;
			case 2:
				if ((getOp2.getAttribute("aria-label").toString()).equals(Color)) {
					System.out.println("Same Color Attribute is added to Cart");
				} else {
					System.out.println("Different Color Attribute is added to Cart");
				}
				break;
			default:
				System.out.println("Product not added to Cart.");
			}
			count++;
		}
	}
}

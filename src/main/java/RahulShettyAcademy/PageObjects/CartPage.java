package RahulShettyAcademy.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAcademy.AbstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent{

	public WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    By buttons = By.cssSelector(".totalRow button");
    
    @FindBy(css=".totalRow button")
    WebElement proceed;
    
	@FindBy(xpath = "//div[@class='cart'] //h3")
	WebElement elementadded;

	public boolean verifyaddeditem(String it) {
		boolean flag = elementadded.getText().equalsIgnoreCase(it);
		return flag;
	}

	public CheckoutPage clickoncheckout() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		elementtobeVisible(buttons);
		proceed.click();
		CheckoutPage ch = new CheckoutPage(driver);
		return ch;
	}
}

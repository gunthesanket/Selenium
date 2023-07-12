package RahulShettyAcademy.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAcademy.AbstractComponent.AbstractComponent;

public class ThankYouPage extends AbstractComponent{

	public WebDriver driver;
	
	public ThankYouPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	By testtobe = By.cssSelector("label.ng-star-inserted");
	@FindBy(css="label.ng-star-inserted")
	WebElement textpr;
	
	public String fetchText() {
		return textpr.getText();
	}
	
}

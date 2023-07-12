package RahulShettyAcademy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAcademy.AbstractComponent.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	public WebDriver driver;

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement dropdown;

	@FindBy(xpath = "//a[@class='btnn action__submit ng-star-inserted']")
	WebElement button_2;
	
	By button_1 = By.xpath("//a[@class='btnn action__submit ng-star-inserted']");

	@FindBy(xpath = "//section[@class='ta-results list-group ng-star-inserted']/button")
	List<WebElement> desiredcont;
	By countries = By.cssSelector("section.ta-results");

	@FindBy(css = "section.ta-results.list-group.ng-star-inserted button span")
	List<WebElement> allcont;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ThankYouPage selectcountry(String con) {
		dropdown.sendKeys(con);
		elementtobeVisible(countries);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		elementtobeVisible(countries);
		int i = 0;
		for (WebElement l : allcont) {
			System.out.println(l.getText());

			if (l.getText().equalsIgnoreCase("India")) {
				desiredcont.get(i).click();
				break;
			}
			i++;
		}

		elementtobeVisible(button_1);
		button_2.click();
		ThankYouPage tp = new ThankYouPage(driver);
		return tp;
	}
}

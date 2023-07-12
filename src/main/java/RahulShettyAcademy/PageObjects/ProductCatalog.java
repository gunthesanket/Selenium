package RahulShettyAcademy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import RahulShettyAcademy.AbstractComponent.AbstractComponent;

public class ProductCatalog extends AbstractComponent {
	public WebDriver driver;

	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div.container div:nth-child(2) div div div h5 b")
	List<WebElement> itemsincart;

	By items = By.cssSelector("div.container div:nth-child(2) div div div h5 b");

	By chose = By.xpath("//b/parent::h5/following::button[2]");
	By msg = By.xpath("//div[@id='toast-container']");

	public void selectitems(String it) {

		elementtobeVisible(items);
		for (int i = 0; i < itemsincart.size(); i++) {

			System.out.println(itemsincart.get(i).getText());
			if (itemsincart.get(i).getText().equalsIgnoreCase(it)) {
				elementtobeVisible(chose);

				itemsincart.get(i).findElements(chose).get(i).click();
			}
		}

		elementtobeVisible(msg);
	}

}

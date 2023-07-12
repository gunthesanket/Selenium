package RahulShettyAcademy.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAcademy.AbstractComponent.AbstractComponent;

public class OrderPage extends AbstractComponent {

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[2]")
	List<WebElement> items;
	boolean flag;

	public boolean orderlist(String item) {
		for (int i = 0; i < items.size(); i++) {

			if (items.get(i).getText().equalsIgnoreCase(item)) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}

}

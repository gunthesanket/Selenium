package RahulShettyAcademy.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import RahulShettyAcademy.PageObjects.CartPage;
import RahulShettyAcademy.PageObjects.OrderPage;

public class AbstractComponent {

	public WebDriver driver;
	By cart = By.xpath("//button[@routerlink='/dashboard/cart']");

	@FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
	WebElement orders;

	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement carttobe;

	public OrderPage gotoorderpage() {
		orders.click();
		OrderPage pg = new OrderPage(driver);
		return pg;
	}

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public CartPage clickoncart() throws InterruptedException {
		elementtobeVisible(cart);
		Thread.sleep(2000);
		carttobe.click();
		CartPage cp = new CartPage(driver);
		return cp;
	}

	public void elementtobeVisible(By locat) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locat));
	}

	public void webelementtobeVisible(WebElement locat) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(locat));
	}
}

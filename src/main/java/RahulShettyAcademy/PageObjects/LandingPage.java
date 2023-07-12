package RahulShettyAcademy.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAcademy.AbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent {

	private WebDriver driver;

	@FindBy(id = "userEmail")
	WebElement username;

	@FindBy(css = "#userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement login;

	@FindBy(css = "[class*='flyInOut']")
	WebElement errormesg;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void gotoapp() {
		driver.get("https://rahulshettyacademy.com/client");

	}

	public ProductCatalog loginToApplication(String name, String pass) {
		driver.get("https://rahulshettyacademy.com/client");
		username.sendKeys(name);
		password.sendKeys(pass);
		login.click();
		ProductCatalog pd = new ProductCatalog(driver);
		return pd;
	}

	public String geterrormessage() {
		webelementtobeVisible(errormesg);
		return errormesg.getText();
	}

}

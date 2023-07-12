package RahulShettyAcademy.SeleniumFrameworkDesign;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import RahulShettyAcademy.PageObjects.CartPage;
import RahulShettyAcademy.PageObjects.CheckoutPage;
import RahulShettyAcademy.PageObjects.LandingPage;
import RahulShettyAcademy.PageObjects.ProductCatalog;
import RahulShettyAcademy.PageObjects.ThankYouPage;
import RahulShettyAcademy.TestComponenet.BaseTest;
import RahulShettyAcademy.TestComponenet.Retrry;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidationTest extends BaseTest {

	@Test(groups= {"Sanket"},retryAnalyzer=Retrry.class)
	public void ErrorValidation() throws IOException, InterruptedException {

		obj.loginToApplication("sanketgunthe@gmail.com", "Sanku8983s#");
		System.out.println(obj.geterrormessage());
		Assert.assertEquals("Incorrect email or password.", obj.geterrormessage());
	}
	
	
	@Test
	public void ErrorValidationorderitem() throws IOException, InterruptedException {
		String it = "iphone 13 pro";
		ProductCatalog pd = obj.loginToApplication("sanketgunthe@gmail.com", "Sanku8983#");
		pd.selectitems("iphone 13 pro");
		CartPage cp = pd.clickoncart();
		boolean flag = cp.verifyaddeditem(it);
		Assert.assertTrue(flag);
		
	}

	
	
}

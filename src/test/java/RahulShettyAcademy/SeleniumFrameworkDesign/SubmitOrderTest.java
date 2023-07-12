package RahulShettyAcademy.SeleniumFrameworkDesign;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RahulShettyAcademy.PageObjects.CartPage;
import RahulShettyAcademy.PageObjects.CheckoutPage;
import RahulShettyAcademy.PageObjects.LandingPage;
import RahulShettyAcademy.PageObjects.OrderPage;
import RahulShettyAcademy.PageObjects.ProductCatalog;
import RahulShettyAcademy.PageObjects.ThankYouPage;
import RahulShettyAcademy.TestComponenet.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest {

	

	@Test(groups = { "Sanket" }, dataProvider = "getdata")
	public void submitOrder(String usernmae, String pass) throws IOException, InterruptedException {
		String it = "iphone 13 pro";
		ProductCatalog pd = obj.loginToApplication(usernmae, pass);
		pd.selectitems("iphone 13 pro");
		CartPage cp = pd.clickoncart();
		boolean flag = cp.verifyaddeditem(it);
		Assert.assertTrue(flag);
		CheckoutPage ch = cp.clickoncheckout();
		ThankYouPage tp = ch.selectcountry("Ind");
		System.out.println(tp.fetchText());
	}

	@DataProvider
	public Object[][] getdata() {
		return new Object[][] { { "sanketgunthe@gmail.com", "Sanku8983#" },
				{ "sanketgunthe06@gmail.com", "Sanku8983#" } };
	}

	@Test(dependsOnMethods = { "submitOrder" })
	public void orderHistroyTest() {
		ProductCatalog pd = obj.loginToApplication("sanketgunthe@gmail.com", "Sanku8983#");
		OrderPage pg = pd.gotoorderpage();
		boolean flag = pg.orderlist("iphone 13 pro");
		System.out.println(flag);
		Assert.assertTrue(flag);
	}

}

package RahulShettyAcademy.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		String it = "iphone 13 pro";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("sanketgunthe@gmail.com");
		driver.findElement(By.cssSelector("#userPassword")).sendKeys("Sanku8983#");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("div.container div:nth-child(2) div div div h5 b")));

		List<WebElement> items = driver.findElements(By.cssSelector("div.container div:nth-child(2) div div div h5 b"));

		for (int i = 0; i < items.size(); i++) {

			System.out.println(items.get(i).getText());
			if (items.get(i).getText().equalsIgnoreCase(it)) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b/parent::h5")));
				//Thread.sleep(1000);
				items.get(i).findElements(By.xpath("//b/parent::h5/following::button[2]")).get(i).click();
			}
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@routerlink='/dashboard/cart']")));

		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		String cart = driver.findElement(By.xpath("//div[@class='cart'] //h3")).getText();

		if (!cart.equalsIgnoreCase(it)) {
			Assert.assertTrue(false);
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".totalRow button")));
    
		driver.findElement(By.cssSelector(".totalRow button")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("Ind");

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("section.ta-results")));

		js.executeScript("window.scrollBy(0,500)");
		List<WebElement> ls = driver
				.findElements(By.cssSelector("section.ta-results.list-group.ng-star-inserted button span"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section.ta-results.list-group.ng-star-inserted button span")));
		int i = 0;
		for (WebElement l : ls) {
			System.out.println(l.getText());

			if (l.getText().equalsIgnoreCase("India")) {
				driver.findElements(By.xpath("//section[@class='ta-results list-group ng-star-inserted']/button"))
						.get(i).click();
				break;
			}
			i++;
		}
		js.executeScript("window.scrollBy(0,500)");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")));

		driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("label.ng-star-inserted")));

		System.out.println(driver.findElement(By.cssSelector("label.ng-star-inserted")).getText());
		driver.close();
	}

}

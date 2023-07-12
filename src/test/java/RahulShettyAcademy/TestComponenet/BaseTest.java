package RahulShettyAcademy.TestComponenet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import RahulShettyAcademy.PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public LandingPage obj;

	@BeforeMethod(alwaysRun = true)
	public void launchapp() throws IOException {
		driver = initialiseapp();
		obj = new LandingPage(driver);
		obj.gotoapp();
	}

	public String getscreenshot(String testcasename) throws IOException {
		String path = System.getProperty("user.dir") + "//reports" + testcasename + ".png";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "//reports" + testcasename + ".png"));
		return path;
	}

	@AfterMethod(alwaysRun = true)
	public void closebrowser() throws IOException {
		driver.close();
	}

	public WebDriver initialiseapp() throws IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\RahulShettyAcademy\\Resources\\Global.properties");

		Properties prop = new Properties();
		prop.load(file);
		String browserName = System.getProperty("Browser") != null ? System.getProperty("Browser")
				: prop.getProperty("Browser");
		// prop.getProperty("Browser");
		if (browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless")) {
				options.addArguments("headless");
				
			}
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(1440,900));
		}

		else if (browserName.equalsIgnoreCase("fire")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}
}

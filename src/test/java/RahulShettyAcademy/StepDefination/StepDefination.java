package RahulShettyAcademy.StepDefination;

import java.io.IOException;

import org.testng.Assert;

import RahulShettyAcademy.PageObjects.CartPage;
import RahulShettyAcademy.PageObjects.CheckoutPage;
import RahulShettyAcademy.PageObjects.ProductCatalog;
import RahulShettyAcademy.PageObjects.ThankYouPage;
import RahulShettyAcademy.TestComponenet.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination extends BaseTest {
	public ProductCatalog pd;
	public CartPage cp;
	public ThankYouPage tp;
	public CheckoutPage ch;

	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		launchapp();

	}

	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String usernmae, String pass) {
		String it = "iphone 13 pro";
		pd = obj.loginToApplication(usernmae, pass);

	}

	@When("^I add product (.+) to Cart$")
	public void i_add_product_to_cart(String productName) throws InterruptedException {
		pd.selectitems(productName);
		cp = pd.clickoncart();
		boolean flag = cp.verifyaddeditem(productName);
		Assert.assertTrue(flag);
	}

	@When("^Checkout (.+) and submit the order$")
	public void checkout_submit_order(String productName) {
		ch = cp.clickoncheckout();
		tp = ch.selectcountry("Ind");

	}

	
	@Then("{string} message is displayed on ConfirmationPage")
	public void message_displayed_confirmationPage(String string) {
		System.out.println(tp.fetchText());
	}


	@Then("{string} error message is displayed on ConfirmationPage")
	public void error_message_displayed_confirmationPage(String string) {
		System.out.println(obj.geterrormessage());
		Assert.assertEquals(string, obj.geterrormessage());
	}
	
}

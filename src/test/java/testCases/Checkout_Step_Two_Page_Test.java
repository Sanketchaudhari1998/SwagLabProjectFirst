package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page;
import pages.Checkout_Step_One_Page;
import pages.Checkout_Step_Two_Page;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.Screenshotcode;

public class Checkout_Step_Two_Page_Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	Cart_Page cart;
	Checkout_Step_One_Page check1;
	Checkout_Step_Two_Page check2;
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		login = new LoginPage();
		invent = new Inventory_Page();
		cart = new Cart_Page();
		check1 = new Checkout_Step_One_Page();
		check2 = new Checkout_Step_Two_Page();
		login.loginToApplication();
		invent.add6Products();
		invent.enterToCart();
		cart.verifyCheckoutBtn();
		check1.inputInformation();
	}
	
	@Test
	public void verifyPageTitleTest()
	{
		String expTitle= "Checkout: Overview";
		String actTitle= check2.verifyPageTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("checkout step one page title is = " + actTitle);
	}
	@Test
	public void verifyAppLogoTitleTest()
	{
		String expTitle= "Swag Labs";
		String actTitle= check2.verifyAppLogoTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("checkout step one page logo title is = " + actTitle);
	}
	@Test
	public void verifyMenuBtnTest()
	{
		boolean result = check2.verifyMenuBtn();
		Assert.assertEquals(result, true);
		Reporter.log("Menu button on checkout step one page isDisplay = " + result);
	}
	@Test
	public void verifyprodQuantityLabelTest()
	{
		String expLabel= "QTY";
		String actLabel= check2.verifyprodQuantityLabel();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Label for product quantity = " + actLabel);
	}
	@Test
	public void verifyProdDescriptionLabelTest()
	{
		String expLabel= "Description";
		String actLabel= check2.verifyProdDescriptionLabel();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Label for product description = " + actLabel);
	}
	@Test
	public void verifyTwitterLogoTest()
	{
		boolean result = check2.verifyTwitterLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Twitter logo is present = " + result);
	}
	@Test
	public void verifyFacebookLogoTest()
	{
		boolean resultFacebook = check2.verifyFacebookLogo();
		Assert.assertEquals(resultFacebook, true);
		Reporter.log("Facebook logo is present = " + resultFacebook);
	}
    @Test
    public void verifyLinkedinLogotest()
    {
    	boolean resultLinkedin = check2.verifyLinkedinLogo();
    	Assert.assertEquals(resultLinkedin, true);
    	Reporter.log("Linkedin logo is present = " + resultLinkedin);
    }
	@Test
	public void verifyFooterTextTest()
	{
		String expFooterTxt = "© " + "2024" + " Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
		String actFooterTxt = check2.verifyFooterText();
		Assert.assertEquals(expFooterTxt, actFooterTxt);
		Reporter.log("Footer text is = " + actFooterTxt);
	}
	@Test
	public void verifyPaymentInfoLabelTest()
	{
		String exp= "Payment Information:";
		String act= check2.verifyPaymentInfoLabel();
		Assert.assertEquals(exp, act);
		Reporter.log("Payment Info Label is = " + act);
	}
	@Test
	public void verifyPaymentInfoValueTest()
	{
		String exp= "SauceCard #31337";
		String act= check2.verifyPaymentInfoValue();
		Assert.assertEquals(exp, act);
		Reporter.log("Payment Info value is = " + act);
	}
	@Test
	public void verifyShippingInfoLabelTest()
	{
		String exp= "Shipping Information:";
		String act= check2.verifyShippingInfoLabel();
		Assert.assertEquals(exp, act);
		Reporter.log("Shipping Info Label is = " + act);
	}
	@Test
	public void verifyShippingInfoValueTest()
	{
		String exp= "Free Pony Express Delivery!";
		String act= check2.verifyShippingInfoValue();
		Assert.assertEquals(exp, act);
		Reporter.log("Shipping Info value is = " + act);
	}
	@Test
	public void verifyTotalInfoLabelTest()
	{
		String exp= "Price Total";
		String act= check2.verifyTotalInfoLabel();
		Assert.assertEquals(exp, act);
		Reporter.log("Total Info Label is = " + act);
	}
	@Test
	public void verifySubTotalTest()
	{
		String exp= "Item total: $" + "129.94";
		String act= check2.verifySubTotal();
		Assert.assertEquals(exp, act);
		Reporter.log("Sub Total is = " + act);
	}
	@Test
	public void verifyTaxTest()
	{
		String exp= "Tax: $" + "10.40";
		String act= check2.verifyTax();
		Assert.assertEquals(exp, act);
		Reporter.log("Total Tax is = " + act);
	}
	@Test
	public void verifyTotalTest()
	{
		String exp= "Total: $" + "140.34";
		String act= check2.verifyTotal();
		Assert.assertEquals(exp, act);
		Reporter.log("Total is = " + act);
	}
	@Test
	public void clickOnCancelBtnTest()
	{
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=check2.clickOnCancelBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("checkout step 2 page cancel button on click url = " + actURL);
	}
	@Test
	public void clickOnFinishBtnTest()
	{
		String expURL="https://www.saucedemo.com/checkout-complete.html";
		String actURL=check2.clickOnFinishBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("checkout step 2 page Finish button on click url = " + actURL);
	}
	
	
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Screenshotcode.captureScreenshot(it.getName());
		}
		driver.close();
	}

}

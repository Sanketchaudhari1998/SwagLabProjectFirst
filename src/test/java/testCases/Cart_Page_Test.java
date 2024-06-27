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
import pages.Inventory_Page;
import pages.LoginPage;
import utility.Screenshotcode;

public class Cart_Page_Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	Cart_Page cart;
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		login = new LoginPage();
		invent = new Inventory_Page();
		cart = new Cart_Page();
		login.loginToApplication();
		invent.add6Products();
		invent.enterToCart();
	}
	
	
	@Test
	public void verifyCartPageURLTest()
	{
		String expUrl= "https://www.saucedemo.com/cart.html";
		String actUrl= cart.verifyCartPageURL();
		Assert.assertEquals(expUrl, actUrl);
		Reporter.log("Cart page Url is = " + actUrl);
		
	}
	@Test
	public void verifyPageTitleTest()
	{
		String expTitle= "Your Cart";
		String actTitle= cart.verifyPageTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Cart page title is = " + actTitle);
	}
	@Test
	public void verifyAppLogoTitleTest()
	{
		String expTitle= "Swag Labs";
		String actTitle= cart.verifyAppLogoTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Cart page app logo title is = " + actTitle);
	}
	@Test
	public void verifyMenuBtnTest()
	{
		boolean result = cart.verifyMenuBtn();
		Assert.assertEquals(result, true);
		Reporter.log("Menu button on cart page isDisplay = " + result);
	}
	@Test
	public void verifyprodQuantityLabelTest()
	{
		String expLabel= "QTY";
		String actLabel= cart.verifyprodQuantityLabel();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Label for product quantity = " + actLabel);
	}
	@Test
	public void verifyProdDescriptionLabelTest()
	{
		String expLabel= "Description";
		String actLabel= cart.verifyProdDescriptionLabel();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Label for product description = " + actLabel);
	}
	@Test
	public void verifyContinueShoppingBtnTest()
	{
		String expUrl= "https://www.saucedemo.com/inventory.html";
		String actUrl= cart.verifyContinueShoppingBtn();
		Assert.assertEquals(expUrl, actUrl);
		Reporter.log("After clicking on continue shopping button Url is = " + actUrl);
	}
	@Test
	public void verifyCheckoutBtnTest()
	{
		String expUrl= "https://www.saucedemo.com/checkout-step-one.html";
		String actUrl= cart.verifyCheckoutBtn();
		Assert.assertEquals(expUrl, actUrl);
		Reporter.log("After clicking on checkout button Url is = " + actUrl);
	}
	@Test
	public void verifyTwitterLogoTest()
	{
		boolean result = cart.verifyTwitterLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Twitter logo is present = " + result);
	}
	@Test
	public void verifyFacebookLogoTest()
	{
		boolean resultFacebook = cart.verifyFacebookLogo();
		Assert.assertEquals(resultFacebook, true);
		Reporter.log("Facebook logo is present = " + resultFacebook);
	}
    @Test
    public void verifyLinkedinLogotest()
    {
    	boolean resultLinkedin = cart.verifyLinkedinLogo();
    	Assert.assertEquals(resultLinkedin, true);
    	Reporter.log("Linkedin logo is present = " + resultLinkedin);
    }
	@Test
	public void verifyFooterTextTest()
	{
		String expFooterTxt = "© " + "2024" + " Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
		String actFooterTxt = cart.verifyFooterText();
		Assert.assertEquals(expFooterTxt, actFooterTxt);
		Reporter.log("Footer text is = " + actFooterTxt);
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
